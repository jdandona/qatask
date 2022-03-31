package com.friday.qatask.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/*/
 * Reads the spec file which contains page locator strategy and its value.
 */
public class ObjectFileReader {

	static String tier;
	public static String platform;
	public static Map<String, String> config;
	static String filepath = "src" + File.separator + "test" + File.separator + "resources" + File.separator
			+ "PageObjectRepository" + File.separator;

	public static String[] getELementFromFile(String pageName,
			String elementName) {
		
		try {
			FileReader specFile = new FileReader(filepath + pageName + ".spec");
			return getElement(specFile, elementName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
}
	
	
	private static String[] getElement(FileReader specFile, String elementName)
			throws Exception {
		
		String[] elementLineSplit;
		ArrayList<String> elementLines = getSpecSection(specFile);
		
		for (String elementLine : elementLines) {
			elementLineSplit = elementLine.split(" ");
			
			if (elementLineSplit[0].trim().equalsIgnoreCase(elementName)) {
				return elementLine.split(" ", 3);
			} else {
				continue;
			}
		}
		throw new Exception();
	}
	
	private static ArrayList<String> getSpecSection(FileReader specfile) {
		String readBuff = null;
		ArrayList<String> elementLines = new ArrayList<String>();

		try {
			BufferedReader buff = new BufferedReader(specfile);
			try {
				boolean flag = false;
				readBuff = buff.readLine();
				while ((readBuff = buff.readLine()) != null) {
					if (readBuff.startsWith("========")) {
						flag = !flag;
					}
					if (flag) {
						elementLines.add(readBuff.trim().replaceAll("[ \t]+",
								" "));
					}
					if (!elementLines.isEmpty() && !flag) {
						break;
					}
				}
			} finally {
				buff.close();
				if (elementLines.get(0).startsWith("========")) {
					elementLines.remove(0);
				}
			}
		} catch (FileNotFoundException e) {
			System.out
					.println("Spec File not found at location :- " + filepath);
		} catch (IOException e) {
			System.out.println("exceptional case");
		}
		return elementLines;
	}
	


}
