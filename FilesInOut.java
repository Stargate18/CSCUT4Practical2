import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

/**
 * 
 * CSCU9T4 Java strings and files exercise.
 *
 */
public class FilesInOut {

    public static void main(String[] args){
        // Replace this with statements to set the file name (input) and file name (output).
        // Initially it will be easier to hardcode suitable file names.
    	File file = new File(".\\src\\input.txt");
    	String output = "output.txt";
    	ArrayList<String> inputnames = new ArrayList<String>();
        // Set up a new Scanner to read the input file.
        // Processing line by line would be sensible here.
        // Initially, echo the text to System.out to check you are reading correctly.
        // Then add code to modify the text to the output format.
    	
    	Scanner in = new Scanner("");;
    	try {
			in = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	while (in.hasNextLine())
    	{
    	  inputnames.add(in.nextLine());
    	  System.out.println(inputnames.get(inputnames.size() - 1));
    	}
    	
    	
        // Set up a new PrintWriter to write the output file.
        // Add suitable code into the above processing (because you need to do this line by line also.
        // That is, read a line, write a line, loop.

        // Finally, add code to read the filenames as arguments from the command line.

    } // main

} // FilesInOut
