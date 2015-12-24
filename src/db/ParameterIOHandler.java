package db;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
			
			
			//TODO fix the bug that when scanner gets closed here, main menu crashes
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			choice = sc.nextLine();
			
		} else {
			try {
				f.createNewFile();
			} catch (IOException e) {
				System.err.println("ERROR: could not create new file");
			}
		}
		
		
		//save the settings if the user typed "y" when asked to overwrite.
		//This choice is "y" by default, so for new files this is always true
		if (choice.equalsIgnoreCase("y")){
			try {
				fos = new FileOutputStream(f);
				buffer = new BufferedOutputStream(fos);
				output = new ObjectOutputStream(buffer);
				output.writeObject(params);
				output.close();
			} catch (IOException e) {
				System.err.println("ERROR: Could not perform save action");
			}
		}
		
	}
	
	
	
	//looks for a serialized hash on the given path, de-serializes and returns it
	@SuppressWarnings("unchecked")
	public static Hashtable<String, Integer> loadParameters(String path){
		Hashtable<String, Integer> res = null;
		FileInputStream fis;
	    BufferedInputStream buffer;
	    ObjectInputStream input;
		
		File f = new File(path);
		
		//if file exists, try to load it, otherwise display an error that the
		//file could not be found
		if ( f.exists() ){
			try {
				fis = new FileInputStream(f);
				buffer = new BufferedInputStream(fis);
				input = new ObjectInputStream(buffer);
				res = (Hashtable<String, Integer>) input.readObject();	//suppresed unchecked warning is for this line
			} catch (IOException e) {
				System.err.println("ERROR: could not load settings file");
			} catch (ClassNotFoundException e) {
				System.err.println("ERROR: invalid savefile format");
			}

		} else {
			System.err.println("ERROR: could not find that file");
		}
		
		return res;
	}
	
	
}
