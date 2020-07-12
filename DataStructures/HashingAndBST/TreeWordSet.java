package mj223vn_assign3.count_words;

import java.util.Iterator;

public class TreeWordSet implements WordSet {
	private BST root = null;
	private int size;
	Word[] words;

	public TreeWordSet() {
	}

	@Override
	public Iterator<Word> iterator() {
		return new WordIterator();
	}

	@Override
	public void add(Word word) {
		if (root == null)
			root = new BST(word);
		else
			root.add(word);
	}

	@Override
	public boolean contains(Word word) {
		return root.contains(word);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public String toString() {
		return visit(root);
	}

	private String visit(BST root) {
		String str = "";
		if (root == null)
			return "";
		else {
			str += visit(root.left);
			str += root.value.toString() + "\n";
			str += visit(root.right);
		}
		return str;
	}

	private class WordIterator implements Iterator<Word> {
		Word[] words;
		int index;

		public WordIterator() {
			words = new Word[size];
			index = 0;
			visitAll(root);
			index = 0;
		}

		private void visitAll(BST root) {
			if (root.left != null)
				visitAll(root.left);
			words[index++] = root.value;
			if (root.right != null)
				visitAll(root.right);
		}

		@Override
		public boolean hasNext() {
			if (index < words.length)
				return true;
			else
				return false;
		}

		@Override
		public Word next() {

			return words[index++];
		}

	}

	private class BST {
		Word value;
		BST left = null;
		BST right = null;

		BST(Word val) {
			value = val;
			size++;
		}

		void add(Word word) {
			if (word.compareTo(value) < 0) {
				if (left == null)
					left = new BST(word);
				else
					left.add(word);
			} else if (word.compareTo(value) > 0) {
				if (right == null)
					right = new BST(word);
				else
					right.add(word);
			}
		}

		boolean contains(Word word) {
			if (value.compareTo(word) < 0) {
				if (left == null)
					return false;
				else
					return left.contains(word);
			} else if (value.compareTo(word) > 0) {
				if (right == null)
					return false;
				else
					return right.contains(word);

			}
			return true;
		}

	}

}
