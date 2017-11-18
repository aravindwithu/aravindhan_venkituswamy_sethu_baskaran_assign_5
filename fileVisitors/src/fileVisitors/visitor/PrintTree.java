package fileVisitors.visitor;

import fileVisitors.util.MyLogger;
import fileVisitors.util.FileProcessor;
import fileVisitors.myTree.TreeBuilder;
import fileVisitors.myTree.Node;
/**
* PrintTree class.
* Created for cs542 - Design patterns, Assignment 5.
*/
public class PrintTree implements VisitorI{

	public PrintTree(){
		MyLogger.writeMessage("Inside PrintTree constructor",MyLogger.DebugLevel.CONSTRUCTOR);
	}

	private void printTree(Node node){
		if(node == null){
			return;
		}
		printTree(node.getLeftChild());
		System.out.println(node.getWord());
		printTree(node.getRightChild());
	}

	public void visit(TreeBuilder tree){
		// System.out.println("Priting within visitor +===");
		printTree(tree.getRoot());
	}
}