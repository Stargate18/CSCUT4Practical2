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
public class FormatNamesm {

	public static void main(String[] args) {
		boolean uppercasemode = false;
		for (String x : args) {
			if (x.equals("-u")) {
				uppercasemode = true;
			}
		}
		String inputFileName;
		String outputFileName;
		File inputFile;
		PrintWriter output = null;
		Scanner in = new Scanner(System.in);
		Scanner inFile = null;
		System.out.println("supply filename for input:");
		try {
			inputFileName = in.nextLine();
			inputFile = new File(inputFileName);
			inFile = new Scanner(inputFile);
		} catch (IOException e) {
			System.err.println("IOException: " + e.getMessage() + "not found");
		}
		System.out.println("supply filename for output:");
		try {
			outputFileName = in.nextLine();
			output = new PrintWriter(outputFileName);
		} catch (FileNotFoundException e) {
			System.err.println("FileNotFoundException: " + e.getMessage() + " not openable");
			System.exit(0);
		}

		ArrayList<String> inputnames = new ArrayList<String>();
		System.out.println("init check");
		while (inFile.hasNextLine()) {
			System.out.println("first line scanned");
			String received = inFile.nextLine();
			inputnames.add(received);
			System.out.println(received);
			String[] splitname = received.split(" ");
			System.out.println(splitname);
			String finals = "";
			String date = "";
			for (String x : splitname) {
				System.out.println(x);
				if (x.matches("\\d.*")) {
					date = x.substring(0, 2) + "/" + x.substring(2, 4) + "/" + x.substring(4);
				} else {
					if (x.length() == 1) {
						x = x.toUpperCase() + ".";
					} else if (uppercasemode) {
						x = x.toUpperCase();
					} else {
						x = x.substring(0, 1).toUpperCase() + x.substring(1);
					}
					finals = finals + x + " ";
				}
			}
			System.out.println("all gotten");
			finals = String.format("%-30s%s", finals, date);
			System.out.println("formatted");
			output.println(finals);
			System.out.println("done!");
		}

		output.close();

	} // main

}
// FormatNamesm