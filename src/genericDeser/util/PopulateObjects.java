package genericDeser.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import genericDeser.fileOperations.FileProcessor;
import genericDeser.util.First;
import genericDeser.util.LoggerHandler;
import genericDeser.util.Second;
import genericDeser.util.genericDeserTokens;

/**
 * @author shashiupadhyay
 *
 */
public class PopulateObjects {
	private FileProcessor fileProcessor;
	private Map<String, Class<?>> string_datatype_map;
	private Map<Class<?>, Class<?>> datatype_class_map;
	private Map<First, Integer> repository_first_class;
	private Map<Second, Integer> repository_second_class;
	private List<String> serializedFormat = null;
	private String file_processor_fetchedline = null;

	public PopulateObjects() {
		LoggerHandler.writeMessage(this.getClass().getSimpleName(), LoggerHandler.DebugLevel.CONSTRUCTOR);
		
		repository_first_class = new HashMap<>();
		repository_second_class = new HashMap<>();
		
		datatype_class_map = new HashMap<>();
		datatype_class_map.put(Integer.TYPE, Integer.class);
		datatype_class_map.put(Double.TYPE, Double.class);
		datatype_class_map.put(Short.TYPE, Short.class);
		datatype_class_map.put(Float.TYPE, Float.class);
		datatype_class_map.put(Boolean.TYPE, Boolean.class);

		string_datatype_map = new HashMap<>();
		string_datatype_map.put("int", Integer.TYPE);
		string_datatype_map.put("double", Double.TYPE);
		string_datatype_map.put("String", String.class);
		string_datatype_map.put("short", Short.TYPE);
		string_datatype_map.put("float", Float.TYPE);
		string_datatype_map.put("boolean", Boolean.TYPE);
		
	}

	/**
	 * @param inpustringslist  contains the input string from 
	 * @throws Exception exception
	 */
	private void serializeObjects(List<String> inpustringslist) throws Exception {
		if (inpustringslist == null || inpustringslist.size() < 1)
			return;

		String variabletype = null, variableValue = null, methodName = null;
		Method method = null;
		Class<?> class_cons_instance;
		Object parameters = null;
		String className;
		Class<?> class_newinstance = null;
		Object obj_instance = null;

		String variableString = inpustringslist.get(0);
		if (variableString.trim().toLowerCase().startsWith(genericDeserTokens.FQN.getValue())) {
			String[] token = variableString.split(genericDeserTokens.COLON.getValue());
			className = token[1];
			class_newinstance = Class.forName(className);
			obj_instance = class_newinstance.newInstance();
		}

		Class<?>[] signature = new Class[1];

		for (int i = 1; i < inpustringslist.size(); i++) {
			variableString = inpustringslist.get(i);
			StringTokenizer tokenizer = new StringTokenizer(variableString, genericDeserTokens.COMMA.getValue());
			while (tokenizer.hasMoreTokens()) {
				variableString = tokenizer.nextToken();
				if (variableString != null) {
					if (variableString.trim().toLowerCase()
							.startsWith(genericDeserTokens.TYPE.getValue().toLowerCase())) {
						String type[] = variableString.split(genericDeserTokens.EQUAL.getValue());
						if (type != null && type.length >= 2) {
							variabletype = type[1];
							signature = initializeMethodType(variabletype, signature);
						}
					}

					if (variableString.trim().toLowerCase()
							.startsWith(genericDeserTokens.VAR.getValue().toLowerCase())) {
						String mtype[] = variableString.split(genericDeserTokens.EQUAL.getValue());
						if (mtype != null && mtype.length >= 2) {
							methodName = mtype[1];
							methodName = genericDeserTokens.SET.getValue().concat(methodName);
						}
					}

					if (variableString.trim().toLowerCase()
							.startsWith(genericDeserTokens.VALUE.getValue().toLowerCase())) {
						String mvalue[] = variableString.split(genericDeserTokens.EQUAL.getValue());
						if (mvalue != null && mvalue.length >= 2) {
							variableValue = mvalue[1];
						}
					}
				}
			}

			if (methodName != null && signature != null) {
				method = class_newinstance.getMethod(methodName, signature);
			}

			class_cons_instance = string_datatype_map.get(variabletype);
			if (datatype_class_map.containsKey(class_cons_instance)) {
				class_cons_instance = datatype_class_map.get(class_cons_instance);
				Constructor<?> cons = class_cons_instance.getConstructor(String.class);
				if (variableValue != null) {
					parameters = cons.newInstance(variableValue);
				}
			} else {
				parameters = variableValue;
			}
			if (obj_instance != null && parameters != null) {
				method.invoke(obj_instance, parameters);
			}
		}

		if (obj_instance != null) {
			populateObjects(obj_instance);
		}

	}

	/**
	 * @param obj_instance instance of class objects
	 */
	private void populateObjects(Object obj_instance) {
		if (obj_instance instanceof First) {
			if (repository_first_class.containsKey(obj_instance)) {
				repository_first_class.put((First) obj_instance, repository_first_class.get(obj_instance) + 1);
			} else {
				repository_first_class.put((First) obj_instance, 1);
			}
		} else if (obj_instance instanceof Second) {
			if (repository_second_class.containsKey(obj_instance)) {
				repository_second_class.put((Second) obj_instance, repository_second_class.get(obj_instance) + 1);
			} else {
				repository_second_class.put((Second) obj_instance, 1);
			}
		} else {
			System.err.println("Object is not the instance of First and Class");
		}
	}

	/**
	 * @param fileProcessorIn reference of file processor
	 */
	public void deserObjects(FileProcessor fileProcessorIn) {
		fileProcessor = fileProcessorIn;
		try {
			while ((file_processor_fetchedline = fileProcessor.readNextLine()) != null) {
				if (file_processor_fetchedline.trim().toLowerCase().startsWith(genericDeserTokens.FQN.getValue())) {
					serializeObjects(serializedFormat);
					serializedFormat = new ArrayList<>(10);
					serializedFormat.add(file_processor_fetchedline);
				} else {
					serializedFormat.add(file_processor_fetchedline);
				}
			}
			serializeObjects(serializedFormat);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	
	/**
	 * @param variableType datatype in string format
	 * @param signature  datatype in datatype format
	 * @return signature datatype in datatype format
	 */
	public Class<?>[] initializeMethodType(String variableType, Class<?>[] signature) {
		if (string_datatype_map.get(variableType) != null) {
			signature[0] = string_datatype_map.get(variableType);
		}
		return signature;
	}

	public int getUniqueObjects(Map map) {
		int uniqueobjects = map.size();
		return uniqueobjects;
	}


	public int getTotalFirstObjects() {
		int firstobjcount = 0;
		for (Integer count : repository_first_class.values())
			firstobjcount += count;
		return firstobjcount;
	}

	public int getTotalSecondObjects() {
		int secondobjcount = 0;
		for (Integer count : repository_second_class.values())
			secondobjcount += count;
		return secondobjcount;
	}
	
	public void displayOutput(LoggerHandler.DebugLevel debuglevelIn) {
		LoggerHandler.writeMessage("Number of unique First objects\t:\t" + this.getUniqueObjects(repository_first_class),
				debuglevelIn);
		LoggerHandler.writeMessage("Total Number of First objects\t:\t" + this.getTotalFirstObjects(),
				debuglevelIn);
		LoggerHandler.writeMessage("Number of unique Second objects\t:\t" + this.getUniqueObjects(repository_second_class),
				debuglevelIn);
		LoggerHandler.writeMessage("Total Number of Second objects\t:\t" + this.getTotalSecondObjects(),
				debuglevelIn);
	}
}
