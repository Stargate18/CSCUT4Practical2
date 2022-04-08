import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import java.lang.Number;

/**
 * Recieves from the user a file of unformatted names, and returns them ina
 * formatted state, either as tabbed taext or an HTML table.
 *
 * @param args the command line arguments.
 * @param -u   - upper case mode. If present, all output will be in upper case,
 *             instead of title case.
 * @param -h   - HTML mode. If present, output will be in the form of an HTML
 *             document, containing the results in a table. In addition the
 *             default file extension becomes ".html".
 */
public class FormatNamesm {

	public static void main(String[] args) {
		// Define new booleans to hold the status of the flags.
		boolean uppercasemode = false;
		boolean htmlmode = true;
		// Iterate over each argument provided at the command line, activating the flags
		// if their presence is detected.
		for (String x : args) {
			if (x.equals("-u")) {
				uppercasemode = true;
			}
			if (x.equals("-h")) {
				htmlmode = true;
			}
		}
		// Define strings for the filename, a FIle object for the input file, a
		// PrintWriter for the output file, and scanners for both the console and input
		// file.
		// These are place here as new variables defined within a try-catch cannot be
		// used outside them.
		String inputFileName;
		String outputFileName;
		File inputFile;
		PrintWriter output = null;
		Scanner in = new Scanner(System.in);
		Scanner inFile = null;
		// Print a message asking the user for the input filename.
		System.out.println("supply filename for input:");
		// Infinitely loop over the contained code, until the break line is reached,
		// meaning all commands are carried out without an exception.
		while (true) {
			try {
				// Receive the next line of command line input, and store that as the filename.
				inputFileName = in.nextLine();
				// Open the file at the destination provided by the input file name.
				inputFile = new File(inputFileName);
				// Define a new scanner to receive the contents of the input file.
				inFile = new Scanner(inputFile);
				// End the infinite loop.
				break;
			} catch (IOException e) {
				// Print a message detailing the exception.
				System.err.println("IOException: " + e.getMessage() + "not found");
			}
		}
		// Print a message asking the user for the output filename.
		System.out.println("supply filename for output:");
		// Infinitely loop over the contained code, until the break line is reached,
		// meaning all commands are carried out without an exception.
		while (true) {
			try {
				// Receive the next line of command line input, and store that as the filename.
				outputFileName = in.nextLine();
				// If the output filename has no extension, append the extension ".txt" to it,
				// or ".html" if the program is in HTML mode.
				if (!outputFileName.contains(".")) {
					if (htmlmode) {
						outputFileName = outputFileName + ".html";
					} else {
						outputFileName = outputFileName + ".txt";
					}
				}
				// Define a new writer to write the results to the output file.
				output = new PrintWriter(outputFileName);
				// End the infinite loop.
				break;
			} catch (FileNotFoundException e) {
				// Print a message detailing the exception.
				System.err.println("FileNotFoundException: " + e.getMessage() + " not openable");
			}
		}
		// If the program is running in HTML mode, write the header information and the
		// header row of the table.
		if (htmlmode) {
			output.println(
					"<html><head><title>Format Names Output</title></head><body><table><tr><th>Name</th><th>Date</th></tr>");
		}
		// Run the contained code while there are still lines in the input file.
		while (inFile.hasNextLine()) {
			// Receive the next line from the input, and split it based on whitespace.
			String[] splitname = inFile.nextLine().split(" ");
			// Define new strings for the fomatted name and the formatted date.
			String fname = "";
			String date = "";
			// If the program is running in HTML mode, write the start of a new table row.
			if (htmlmode) {
				output.print("<tr><td>");
			}
			// Iterate over each split sring in the input.
			for (String x : splitname) {
				// If the string contains a number, run the contained code.
				if (x.matches("\\d.*")) {
					// Split up the date string, saving it with the appropriate formatting.
					date = x.substring(0, 2) + "/" + x.substring(2, 4) + "/" + x.substring(4);
					// If the program is running in HTML mode, add the end of the previous cell, the
					// start and end of this one, and the end of the row, as dates only appear after
					// the name is completed.
					if (htmlmode) {
						date = "</td><td>" + date + "</td></tr>";
					}
					// If the string does not contain a number, run the contained code.
				} else {
					// IF the string is 1 character, treat it as an itial, capitalizing it and
					// adding a period.
					if (x.length() == 1) {
						x = x.toUpperCase() + ".";
						// If the string is larger and the program is in upper case mode, set the whole
						// string to upper case.
					} else if (uppercasemode) {
						x = x.toUpperCase();
						// If the program is in non-upper case mode, set the first letter to uppercase
						// and add the rest of the string set to lower case.
					} else {
						x = x.substring(0, 1).toUpperCase() + x.substring(1).toLowerCase();
					}
					// Add the resultant string to the name string.
					fname = fname + x + " ";
				}
			}
			// Use the format function to add the name and date to a formatted string.
			fname = String.format("%-30s%s", fname, date);
			// Add the new row to the output file.
			output.println(fname);
		}
		// If the program is in HTML mode, append the closing body tag.
		if (htmlmode) {
			output.print("</body>");
		}
		output.close();

	} // main

}
// FormatNamesm