package com.test;

import java.util.Arrays;
import java.util.List;

import com.utilities.YamlReaderFile;

public class Test {

	static YamlReaderFile read = new YamlReaderFile();
	public static void main(String[] args) throws Exception {
		String str1 = "Apple,Orange,Mango";
		List<String> fruit1 = Arrays.asList(str1.split(","));
		System.out.println(fruit1);
		String[] fruit = str1.split(",");
		System.out.println(fruit[0]+" "+fruit[1]);
		System.out.println(read.getData("cars.car1"));
	}
}
