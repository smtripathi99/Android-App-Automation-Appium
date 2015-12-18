package test.java.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ReadUIProperties {

	private static ReadUIProperties instance = null;

	private Properties props = null;

	private ReadUIProperties() {
		// Here you could read the file into props object
		File file = new File("src/test/resources/UIElements.properties");

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			this.props=new Properties();
			this.props.load(fileInput);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static synchronized ReadUIProperties getInstance() {
		if (instance == null) instance = new ReadUIProperties();
		return instance;
	}

	public String getValue(String propKey) {

		return this.props.getProperty(propKey);

	}
}
