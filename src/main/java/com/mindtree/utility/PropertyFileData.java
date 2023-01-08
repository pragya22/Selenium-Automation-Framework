package com.mindtree.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/*

 * PropertyFileData is a class which is used to read data from PropertyFil
 */
public class PropertyFileData {

	public Properties takeDataFromProperty() throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream("config.properties"));
		return prop;
	}

}
