package mj223vn_assign3.count_words;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class HashWordSet implements WordSet {
	private int size;
	private Node[] buckets = new Node[100];

	public HashWordSet() {
	}

	@Override
	public Iterator<Word> iterator() {
		return new WordIterator();
	}

	@Override
	public void add(Word word) {
		int pos = getBucketNumber(word);
		Node node = buckets[pos];
		while (node != null) {
			if (node.value.equals(word))
				return;
			else
				node = node.next;
		}

		node = new Node(word);
		node.next = buckets[pos];
		buckets[pos] = node;
		size++;
		if (size == buckets.length)
			rehash();

	}

	@Override
	public boolean contains(Word word) {
		int pos = getBucketNumber(word);
		Node node = buckets[pos];
		while (node != null) {
			if (node.value.equals(word))
				return true;
			else
				node = node.next;
		}
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	private int getBucketNumber(Word word) {
		int hc = word.hashCode();
		if (hc < 0)
			hc = -hc;
		return hc % buckets.length;
	}

	private void rehash() {
		Node[] temp = buckets;
		buckets = new Node[2 * temp.length];
		size = 0;
		for (Node n : temp) {
			if (n == null)
				continue;
			while (n != null) {
				add(n.value);
				n = n.next;
			}

		}
	}
	
	public String toString() {
		Node currentWord;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < buckets.length; i++) {
			if(buckets[i] != null) {
				currentWord = buckets[i];
				sb.append(" " + currentWord.value.toString());
				while(currentWord.next != null) {
					currentWord = currentWord.next;
					sb.append(" " + currentWord.value.toString());
				}
				sb.append("\n");
			}
		}
		return sb.toString();
	}

	private class WordIterator implements Iterator<Word> {
		int currentBucket;
		Node currentWord;

		public WordIterator() {
			currentBucket = -1;
			currentWord = null;
			

		}

		@Override
		public boolean hasNext() {
			if (currentWord != null && currentWord.next != null)
				return true;
			for (int index = currentBucket + 1; index < buckets.length; index++) {
				if (buckets[index] != null)
					return true;
			}
			return false;
		}

		@Override
		public Word next() {

			if (currentWord == null || currentWord.next == null) {
				currentBucket++;
				while (currentBucket < buckets.length && buckets[currentBucket] == null)
					currentBucket++;
				if (currentBucket < buckets.length)
					currentWord = buckets[currentBucket];
				else
					throw new NoSuchElementException();
			}
			else
				currentWord = currentWord.next;
			
			return currentWord.value;
		}

	}

	private class Node {
		Word value;
		Node next = null;

		public Node(Word word) {
			this.value = word;
		}

		public String toString() {
			return value.toString();
		}
	}

}
