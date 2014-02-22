/**
 * 
 */
package assignment5;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
/**
 * author: Ving Trung
 * filename: c7p16.java
 * description: chapter 7 project 16
 * 		This program will display the total amount spent on each category in the hotel log.
 * last changed: 2/2/2014
 */
public class c7p16 {
	/**
	 * @param args
	 */
	public static boolean check_input(String input, int place){
		switch(place){
		case 2:
			if(input.matches("[0-9]+.[0-9]+")){
				return true;
			} else {
				return false;
			}
		case 3:
			if(input.matches("[0-9]+/[0-9]+/\\d{2}")){
				return true;
			} else {
				return false;
			}
		default: 
			return true;
		}
	} 	//check_input
		//checks hotelLog.txt to see if the input has a correct price and date format.
	
	public static boolean grab_input(double[] prices, String[] input, Scanner in){
		String inputLine = "";
		String inputWord = "";
		int lineCount = 0;
		while(in.hasNext()){
			inputLine = in.nextLine();
			//System.out.println("X: " + inputLine);
			Scanner stringText = new Scanner(inputLine);
			stringText.useDelimiter(";");
			int count = 0;
			while(stringText.hasNext()){
				inputWord = stringText.next();
				if(count == 2){
					double price = Double.parseDouble(inputWord);
					prices[lineCount] = price;
					//System.out.printf("$%.2f\n",prices[lineCount]);
				}
				if(count == 1){
					input[lineCount] = inputWord;
				}
				if(!check_input(inputWord, count)){
					System.out.println("Format Error on line " + (lineCount + 1) +": " + inputWord);
					return false;
				}
				if(count < 4){
				count++;
				} else {
					System.out.println("Too much data entries on line: " + (lineCount + 1));
					return false;
				}
			}
			if(count < 4){
				System.out.println("Not enough data entries on line: " + (lineCount + 1));
				return false;
			}
			lineCount++;
			stringText.close();		
		}
		return true;
	} 	//grab_input
		//takes in double array, string array, and a scanner object
		//fills double array with prices, fill string array with activity
		//return false if the formating in the scanner is not correct to standard in hotelLog.
	
	public static int count_line(Scanner in){
		int count = 0;
		while(in.hasNext()){
			in.nextLine();
			count++;
		}
		return count;
	}	//count_line
		//return the number of lines in the document of the Scanner;
	
	public static boolean check_match(String input, String[] output){
		for(int count = 0; count < output.length; count++){
			if(input.equals(output[count])){
				return true;
			} 
		}
		return false;
	} 	//check_match
		//take in a string value and returns true if the string value exist in the input string array;
	
	public static void print_result(double[] prices, String input[]){
		String[] output = new String[input.length];			//store categories that has already been printed
		int outputCount = 0;								//count the number of places that has not been filled
		double sum = 0;
		for(int lineCount = 0; lineCount < input.length; lineCount++){
			sum = 0;
			if(!check_match(input[lineCount],output)){
				output[outputCount] = input[lineCount]; 	//if match, add to output array to avoid printing same category again
				outputCount++; 								//add place for next output array entry if needed.
				for(int count = 0; count < prices.length; count++){
					if(input[count].equals(input[lineCount])){
						sum += prices[count];
					}
				}
				System.out.printf("$%.2f has been spent on %s.\n", sum, input[lineCount]);
			}
		}
	}	//print_result
		//print the total spent in each category
	
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("This program will display the total amount spent on each category in the hotel log.\n");
		try{
			File inputFile = new File("hotelLog.txt");
			Scanner countIn = new Scanner(inputFile);
			int lineCount = count_line(countIn);
			countIn.close();
			
			String[] inputLine = new String[lineCount];
			double[] prices = new double[lineCount];
			Scanner in = new Scanner(inputFile);
			if(grab_input(prices, inputLine, in)){
				print_result(prices, inputLine);
			} else {
				System.out.println("File was not formatted correctly");
			}
			in.close();
		}
		catch(IOException exception){ //print when file hotelLog.txt does not exist
			System.out.println("hotelLog.txt was not found");
		}
	}
}
