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

	private Iterator iter;

	public PalindromeHighlight(Iterator iterIn){
		iter = iterIn;
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

	public void visit(TreeBuilder tree){
		// System.out.println("Inside PalindromeHighlight");
		// System.out.println("Printing tree===");
    	// tree.printTree(tree.getRoot());
		while(iter.hasNext()){
			String string = (String) iter.next();
			// System.out.println("Strin is "+string);
			if(checkPalindrome(string)){
				// Capitalize
				System.out.println("Plaindrom is == "+ string);
				Node node = tree.getNode(string);
				if(node != null){
					System.out.println("Node is "+node.getWord());
					node.setWord(string.toUpperCase());	
				}
				// System.out.println("++++left is "+node.getLeftChild().getWord());
			}
		}
		// return tree;
	}

}