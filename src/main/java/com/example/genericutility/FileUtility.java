package com.example.genericutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
public String getPropertyKeyValue (String key) throws IOException {
File file = new File("./src/test/resources/trellodata.properties");
FileInputStream fis = new FileInputStream(file);
Properties pobj = new Properties();
pobj.load(fis);
String value = pobj.getProperty(key);
return value;
   }
}
