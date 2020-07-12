package mj223vn_assign3.count_words;
/**
 * This class reprecents a word in the words.txt file
 * @author marcus
 *
 */
public class Word implements Comparable<Word> {
	   private String word;

	   public Word(String str) {
		   word = str;
	   }
	   public String toString() { return word; }

	   /* Override Object methods */
	   public int hashCode() {
		   int a = 0;
		   for(int i = 0; i < word.length(); i++) {
			   char ch = word.charAt(i);
			   a += Character.getNumericValue(ch);
		   }
		   return a;
	   }
	   public boolean equals(Object other) { 
		   if(other instanceof Word) {
			   Word otherWord = (Word) other;
			   return hashCode() == otherWord.hashCode() && compareTo(otherWord) == 0;
		   }
		   return false;
	   }

	   /* Implement Comparable */
	   public int compareTo(Word w) {
		   
		   return word.compareToIgnoreCase(w.word);
	   }
	}
