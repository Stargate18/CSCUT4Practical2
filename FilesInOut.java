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
    	boolean uppercasemode = false;
    	for (String x : args) {
			if (x.equals("-u")) {
				uppercasemode = true;
			}
		}
    	
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
    		String received = in.nextLine();
    		inputnames.add(received);
    		String[] splitname = received.split(" ");
    		String finals = "";
    		String date = "";
    		for (String x : splitname) {
    			if (x.matches("\\d.*")) {
    				date = x.substring(0,2) + "/" + x.substring(2,4) + "/" + x.substring(4);
    			} else {
    				if (uppercasemode) {
    					x = x.toUpperCase();
    				} else {
    					x = x.substring(0,1).toUpperCase() + x.substring(1);
    				}
    				finals = finals + x + " ";
    			}
    		}
    		finals = String.format("%-30s%s", finals, date);
    		System.out.println(finals);
    	}
    	
    	
        // Set up a new PrintWriter to write the output file.
        // Add suitable code into the above processing (because you need to do this line by line also.
        // That is, read a line, write a line, loop.

        // Finally, add code to read the filenames as arguments from the command line.

    } // main

} // FilesInOut
