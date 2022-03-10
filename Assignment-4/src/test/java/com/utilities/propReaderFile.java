package com.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class propReaderFile {

	public Properties prop;
	public propReaderFile() {
		// TODO Auto-generated constructor stub
		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream("src\\test\\java\\com\\configuration\\config.properties");
			prop.load(file);
			} catch(IOException e) {
				e.toString();
			}
	}
	public String setBrowser() {
		// TODO Auto-generated method stub
		String browsers=prop.getProperty("browser");
		return browsers;
	}
	public String setUrl() {
		String url = prop.getProperty("baseUrl");
		return url;
	}
	public String setCar1(){
		String car1 = prop.getProperty("car1");
		return car1;
	}
	public String setCar2(){
		String car2 = prop.getProperty("car2");
		return car2;
	}
	public String setCar3(){
		String car3 = prop.getProperty("car3");
		return car3;
	}
	public String setFruit1() {
		String fruit1 = prop.getProperty("fruit1");
		return fruit1;
	}
}
