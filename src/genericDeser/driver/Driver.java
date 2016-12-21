package genericDeser.driver;


import genericDeser.fileOperations.FileProcessor;
import genericDeser.util.InputValidations;
import genericDeser.util.LoggerHandler;
import genericDeser.util.PopulateObjects;

public class Driver {
	public static void main(String[] args) {
		if (args != null && InputValidations.validatingInputArguments(args)) {
			FileProcessor read_processing;
			PopulateObjects populate_objects;
			String inputFile = FileProcessor.getPreference_Input_File();
			read_processing = new FileProcessor(inputFile);
			populate_objects = new PopulateObjects();
			populate_objects.deserObjects(read_processing);
			populate_objects.displayOutput(LoggerHandler.DebugLevel.OUTPUT);
		} else {
			LoggerHandler.writeMessage("Few Input Arguments are missing !!", LoggerHandler.DebugLevel.ERROR);
		}
	}


}
