package genericDeser.fileOperations;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author shashiupadhyay
 *
 */
public class FileProcessor {
	
	private static String Preference_Input_File;
	BufferedReader buffer_reader;

	/**
	 * @param filename file
	 */
	public FileProcessor(String filename) {
		try {
			setPreference_Input_File(filename);
			buffer_reader = new BufferedReader(new FileReader(getPreference_Input_File()));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Entered input file : " + getPreference_Input_File() + " is missing.");
			System.exit(0);
		}  finally {}
	}

	public static String getPreference_Input_File() {
		return Preference_Input_File;
	}

	/**
	 * @param preference_Input_File_In preference_Input_File_In
	 */
	public static void setPreference_Input_File(String preference_Input_File_In) {
		Preference_Input_File = preference_Input_File_In;
	}

	public synchronized String readNextLine() {
		String lineJustFetched = null;

		try {
			lineJustFetched = buffer_reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		} finally {}
		return lineJustFetched;
	}

	// javarevisited.blogspot.com/2012/03/finalize-method-in-java-tutorial.html#ixzz4LQ3v75wF
	@Override
    protected void finalize() throws Throwable {
        try{
            if(buffer_reader != null){
            	try {
    				buffer_reader.close();
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    				System.exit(0);
            } 
        }
            }catch(Throwable t){
            throw t;
        }finally{
            System.out.println("Calling finalize of Super Class");
            super.finalize();
        }
    }
	
	@Override
	public String toString() {
		return "Respective file is being processed : " + getPreference_Input_File();
	}
	
}
