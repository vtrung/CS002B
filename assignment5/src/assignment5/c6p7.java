/**
 * 
 */
package assignment5;

/**
 * author: Ving Trung
 * filename: c6p7.java
 * description: chapter 6 project 7
 * 		This program contains a method to reverse an array.
 * last changed: 2/2/2014
 *
 */
public class c6p7 {

	/**
	 * @param args
	 */
	public static int[] reverseArray(int[] inputArray){
		int[] tempArray = new int[inputArray.length];
		int place;
		for(int count = 0; count < inputArray.length; count++){
			place = inputArray.length - 1 - count;
			tempArray[count] = inputArray[place];
		}
		return tempArray;
	}	//reverseArray
		//returns a int array in reverse order of the input int array
	
	public static void printIntArray(int[] inputArray){
		for(int count = 0; count < inputArray.length; count++){
			System.out.print(inputArray[count] + " ");
		}
		System.out.print("\n");
	}	//printIntArray
		//print an integer array to console
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] someArray = {1,4,9,16,9,7,4,9,11};
		printIntArray(someArray);
		int[] reversedArray = reverseArray(someArray);
		printIntArray(reversedArray);
	}

}
