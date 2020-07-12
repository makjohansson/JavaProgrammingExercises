package mj223vn_assign3.count_words;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 * This program readers the text file "History of programming.txt" and write all alphabetical characters and whitespace's
 * to the file "words.txt"
 * @author marcus
 *
 */
public class IdentyfyWordsMain {
	
	public static void main(String[] args) throws IOException{
		File history = new File("History of programming.txt");
		FileReader fileReader = new FileReader(history);
		Scanner reader = new Scanner(fileReader);
		String text = "";
		String temp = "";
		String temp1 = "";
		while(reader.hasNext()) {
			temp = reader.nextLine();
			temp1 = temp.replaceAll("[^A-Za-z\\s]", "");
			text += temp1 +"\n" ;
		}
		
		
		File wordsfile = new File("words.txt");
		wordsfile.createNewFile();
		
		FileWriter writer = new FileWriter(wordsfile);
		
		writer.write(text);
		
		reader.close();
		writer.close();
		
	}

}
