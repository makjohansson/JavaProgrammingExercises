package mj223vn_assign3.count_words;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.TreeSet;
/**
 * A program using java's  to create a HashSet and a TreeSet 
 * @author marcus
 *
 */
public class WordCount1Main {
	
	public static void main(String[] args) throws IOException {
		
		HashSet<Word> hashSet = new HashSet<>();
		TreeSet<Word> treeSet = new TreeSet<>();
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
