package db;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Hashtable;
import java.util.Scanner;

public class ParameterIOHandler {
	
	//serializes the given hash and save it to the given path
	public static void saveParameters(String path, Hashtable<String, Integer> params){
		File f = new File(path);
		String choice = "y";
		FileOutputStream fos;
		BufferedOutputStream buffer;
		ObjectOutputStream output;
		
		//ask user if he wants to overwrite the save file if it already exists.
		//If it doesn't exist, create a new file.
		if (f.exists()){
			System.out.println("File already exists, do you wish to overwrite? [y/n])");
			@SuppressWarnings("resource")	//TODO fix the bug that when scanner gets closed here, main menu crashes
			Scanner sc = new Scanner(System.in);
			choice = sc.nextLine();
		} else {
			try {
				f.createNewFile();
			} catch (IOException e) {
				System.err.println("ERROR: could not create new file");
			}
		}
		
		
		//save the settings
		if (choice.equalsIgnoreCase("y")){
			try {
				fos = new FileOutputStream(f);
				buffer = new BufferedOutputStream(fos);
				output = new ObjectOutputStream(buffer);
				output.writeObject(params);
				output.close();
			} catch (IOException e) {
				System.err.println("ERROR: Could not perform save action");
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	//looks for a serialized hash on the given path, de-serializes and returns it
	public static Hashtable<String, Integer> loadParameters(String path){
		Hashtable<String, Integer> res = null;
		
		
		
		return res;
	}
	
	
}
