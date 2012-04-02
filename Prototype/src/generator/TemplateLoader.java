package generator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;

import logger.GLogger;

public class TemplateLoader {
	private String fileContent;
	
	public TemplateLoader(File f) {
		try {
	        StringBuffer fileData = new StringBuffer(1000);
	        BufferedReader reader = new BufferedReader(
	                new FileReader(f));
	        char[] buf = new char[1024];
	        int numRead=0;
	        while((numRead=reader.read(buf)) != -1){
	            String readData = String.valueOf(buf, 0, numRead);
	            fileData.append(readData);
	            buf = new char[1024];
	        }
	        reader.close();
	        this.fileContent = fileData.toString();
	        GLogger.log(Level.INFO, "Template for business rule succesfully loaded");
		} catch (FileNotFoundException e) {
			GLogger.log(Level.SEVERE, "Template file not found on filepath:");
			GLogger.log(Level.SEVERE, f.getPath());
		} catch (IOException ie) {
			GLogger.log(Level.SEVERE, "Error reading in template on filepath:");
			GLogger.log(Level.SEVERE, f.getPath());
		}
	}
	
	public void bindParam(String nm, String val) {
		fileContent = fileContent.replace("{" + nm + "}", val);
	}

	public void bindParam(String nm, int val) {
		fileContent = fileContent.replace("{" + nm + "}", Integer.toString(val));
	}
	
	public String getString() {
		return fileContent;
	}
}