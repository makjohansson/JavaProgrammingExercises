package mj223vn_assign1;
import java.util.Arrays;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
/**
 * This program counts the initial amount of words and then the unique amount of words in a text file.
 * @author marcus
 *
 */
public class WarAndPeace {
	
	public static void main(String[] args) throws IOException {
		long firstCounter = Files.lines(Paths.get("War and Peace.txt")).map(line -> line.split("\\s")).flatMap(Arrays::stream).count();
		System.out.println("Initial word count: " + firstCounter);
		long counter = Files.lines(Paths.get("War and Peace.txt")).map(line -> line.split("\\W")).flatMap(Arrays::stream)
				.distinct().map(line -> line.split("\\d")).flatMap(Arrays::stream).count();
		System.out.println("Number of unique words: " + counter);
	
	}
}
