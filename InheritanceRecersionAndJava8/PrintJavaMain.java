package mj223vn_assign1;
/**
 * a program finding java files and counting lines in the file.
 * @author Marcus
 */

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PrintJavaMain {
	
	public static void main(String[] args) throws IOException {
		
		File directory = new File("/Users/marcus/Lnu/1DV506/java_kurser/Big Java");
		printAllJavaFiles(directory);
		
	}
	
	
	public static void printAllJavaFiles(File directory) throws IOException {
		
		if(directory.isDirectory()) {
		File[] subs = directory.listFiles();
			for(File f : subs)
				printAllJavaFiles(f);
		}
		else if(directory.isFile()) {
			if(directory.getName().contains("java")) {
				System.out.print("Name: " + directory.getName());
				Path path = Paths.get(directory.getPath());
				System.out.println(" " + Files.lines(path).count());
			}
		}
		
		
		
	}
	
}
