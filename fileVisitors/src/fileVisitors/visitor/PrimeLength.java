package fileVisitors.visitor;

import fileVisitors.util.MyLogger;
import fileVisitors.util.FileProcessor;
import fileVisitors.myTree.TreeBuilder;
import fileVisitors.myTree.Node;

/**
* PrimeLength class.
* Created for cs542 - Design patterns, Assignment 5.
*/
public class PrimeLength implements VisitorI{
	private TreeBuilder tree;

	public PrimeLength(TreeBuilder treeIn){
		tree = treeIn;
		MyLogger.writeMessage("Inside PrimeLength constructor",MyLogger.DebugLevel.CONSTRUCTOR);
	}

	private boolean checkPrimelength(String word){
		int length = word.length();
		if(length < 2){
			return false;
		}
		for(int i = 2; i < length; i++){
			if(length % i == 0){
				return false;
			}
		}
		return true;
	}

	private void primedTree(Node node){
		if(node == null){
			return;
		}
		primedTree(node.getLeftChild());
		if(checkPrimelength(node.getWord())){
			// System.out.println("Prim word is="+node.getWord());
			String primeString = node.getWord() + "-PRIME";
			node.setWord(primeString);
		}
		primedTree(node.getRightChild());
	}

	public Object visit(FileProcessor file){
		// System.out.println("Printing tree===");
    	// tree.printTree(tree.getRoot());
    	primedTree(tree.getRoot());
		return tree;
	}

}