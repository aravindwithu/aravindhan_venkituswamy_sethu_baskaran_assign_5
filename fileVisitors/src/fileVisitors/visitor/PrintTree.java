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

	private TreeBuilder tree;

	public PrintTree(TreeBuilder treeIn){
		tree = treeIn;
		MyLogger.writeMessage("Inside PrintTree constructor",MyLogger.DebugLevel.CONSTRUCTOR);
	}

	private void printTree(Node node){
		if(node == null){
			return;
		}
		printTree(node.getLeftChild());
		System.out.println("Word is ="+node.getWord());
		printTree(node.getRightChild());
	}

	public Object visit(FileProcessor file){
		System.out.println("Priting within   visitor +===");
		printTree(tree.getRoot());
		return tree;
	}
}