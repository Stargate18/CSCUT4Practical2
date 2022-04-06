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
		boolean htmlmode = true;
		for (String x : args) {
			if (x.equals("-u")) {
				uppercasemode = true;
			}
			if (x.equals("-h")) {
				htmlmode = true;
			}
		}
		String inputFileName;
		String outputFileName;
		File inputFile;
		PrintWriter output = null;
		Scanner in = new Scanner(System.in);
		Scanner inFile = null;
		System.out.println("supply filename for input:");
		while(true) {
			try {
				inputFileName = in.nextLine();
				inputFile = new File(inputFileName);
				inFile = new Scanner(inputFile);
				break;
			} catch (IOException e) {
				System.err.println("IOException: " + e.getMessage() + "not found");
			}
		}
		System.out.println("supply filename for output:");
		while(true) {
			try {
				outputFileName = in.nextLine();
				if (!outputFileName.contains(".")) {
					if (htmlmode) {
						outputFileName = outputFileName + ".html";
					} else {
						outputFileName = outputFileName + ".txt";
					}
				}
				output = new PrintWriter(outputFileName);
				break;
			} catch (FileNotFoundException e) {
				System.err.println("FileNotFoundException: " + e.getMessage() + " not openable");
				System.exit(0);
			}
		}
		if (htmlmode) {
			output.println("<html><head><title> Output </title></head><body><table><tr><th>Name</th><th>Date</th></tr>");
		}
		ArrayList<String> inputnames = new ArrayList<String>();
		while (inFile.hasNextLine()) {
			String received = inFile.nextLine();
			inputnames.add(received);
			String[] splitname = received.split(" ");
			String finals = "";
			String date = "";
			if (htmlmode) {
				output.print("<tr><td>");
			}
			for (String x : splitname) {
				if (x.matches("\\d.*")) {
					date = x.substring(0, 2) + "/" + x.substring(2, 4) + "/" + x.substring(4);
					if (htmlmode) {
						date = "</td><td>" + date + "</td>";
					}
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
			finals = String.format("%-30s%s", finals, date);
			output.println(finals);
		}
		if (htmlmode) {
			output.print("</body>");
		}
		output.close();

	} // main

}
// FormatNamesm