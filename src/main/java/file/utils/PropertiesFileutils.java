package file.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileutils {
	
	public static String readPropertiesFile(String sFilePath, String sKey) throws IOException {
		String sValue = "";
		FileInputStream fis = new FileInputStream(new File(sFilePath));
		Properties p = new Properties();
		p.load(fis);
		sValue = p.getProperty(sKey);
		return sValue;
	}
	
	

}
