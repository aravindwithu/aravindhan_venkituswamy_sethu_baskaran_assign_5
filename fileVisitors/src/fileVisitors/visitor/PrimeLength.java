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

	public PrimeLength(){
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
			String primeString = node.getWord() + "-PRIME";
			node.setWord(primeString);
		}
		primedTree(node.getRightChild());
	}

	public void visit(TreeBuilder tree){
    	primedTree(tree.getRoot());
	}

}