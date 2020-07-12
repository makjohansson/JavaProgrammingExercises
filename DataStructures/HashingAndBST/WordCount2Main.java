package mj223vn_assign3.count_words;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/**
 * A program using the HashWordSet and TreeWordSet to print size and content sorted.
 * @author marcus
 *
 */
public class WordCount2Main {
	
	public static void main(String[] args) throws IOException {
		
		HashWordSet hashSet = new HashWordSet();
		TreeWordSet treeSet = new TreeWordSet();
		
		File words = new File("words.txt");
		FileReader fileReader = new FileReader(words);
		Scanner reader = new Scanner(fileReader);
		while(reader.hasNext()) {
			Word word = new Word(reader.next());
			hashSet.add(word);
			treeSet.add(word);
		}
		System.out.println("HashSet size: " + hashSet.size());
		System.out.println("TreeSet size: " + treeSet.size());
		treeSet.forEach(System.out::println);
		reader.close();
	}

}
