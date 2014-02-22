/**
 * 
 */
package assignment5;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * author: Ving Trung
 * filename: c7p8.java
 * description: chapter 7 project 8
 * 		This program reverses the text in a file.
 * last changed: 2/2/2014
 */
public class c7p8 {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static String reverse_string(String input){
		String tempString = "";
		System.out.print(tempString);
		int place;
		for(int count = 0; count < input.length(); count++){
			place = input.length() - 1 - count;
			tempString += input.charAt(place);
			//System.out.print(tempString);
		}
		return tempString;
	}	//reverse_string
		//take in string input
		//returns string with reverse characters.
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String inputfile = "input.txt";
		System.out.println("This program reverses the text in a file.\n");
		
		try{
			File inputFile = new File(inputfile);
			Scanner in = new Scanner(inputFile);
			
			//System.out.print("Please enter the name of the new file: \n");
			String filename = "output.txt";
			
			PrintWriter out = new PrintWriter(filename);
			String textinput;
			while(in.hasNext()){
				textinput = in.nextLine();
				//System.out.print(textinput);
				textinput = reverse_string(textinput);
				out.println(textinput);
			}
			
			System.out.println("input.txt has been written backwards into " + filename);
	
			System.out.print("file has been created");
			out.close();
			in.close();
		}
		catch(IOException exception){
			System.out.println(inputfile + " was not found.");
		}
		
	}

}
