package fileVisitors.visitor;

import fileVisitors.util.MyLogger;
import fileVisitors.util.FileProcessor;
import fileVisitors.myTree.TreeBuilder;
import fileVisitors.myTree.Node;
import java.util.Iterator;

/**
* PalindromeHighlight class.
* Created for cs542 - Design patterns, Assignment 5.
*/
public class PalindromeHighlight implements VisitorI{

	public PalindromeHighlight(){
		MyLogger.writeMessage("Inside PalindromeHighlight constructor",MyLogger.DebugLevel.CONSTRUCTOR);
	}

	private boolean checkPalindrome(String word){
		int start = 0;
		int end = word.length()-1;
		while(start < end){
			if(word.charAt(start) != word.charAt(end)){
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	public void highlightPalindrome(Node currentNode){
		if(currentNode != null){
			highlightPalindrome(currentNode.getLeftChild());
			String word = currentNode.getWord();
			if(checkPalindrome(word)){
				// Capitalize
				System.out.println("Plaindrom is == "+ word);
				currentNode.setWord(word.toUpperCase());
				System.out.println("Capitalized to "+ currentNode.getWord());
			}
			highlightPalindrome(currentNode.getRightChild());
		}
	}

	public void visit(TreeBuilder tree){
		highlightPalindrome(tree.getRoot());
	}
}