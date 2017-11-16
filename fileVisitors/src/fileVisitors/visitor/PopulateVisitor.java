package fileVisitors.visitor;

import fileVisitors.util.MyLogger;
import fileVisitors.util.FileProcessor;
import fileVisitors.myTree.TreeBuilder;

/**
* PopulateVisitor class.
* Created for cs542 - Design patterns, Assignment 5.
*/
public class PopulateVisitor implements VisitorI{
	private TreeBuilder tree;

	public PopulateVisitor(){
		tree = new TreeBuilder();
		MyLogger.writeMessage("Inside PopulateVisitor constructor",MyLogger.DebugLevel.CONSTRUCTOR);
	}

	public Object visit(FileProcessor file){
		String line;
		while ((line = file.readLine(true)) != null)
	    {		    
    		String[] words = line.split(" ");
    		for(String word : words){
    			if(!word.equals("")){
    				tree.insertNode(word);
    			}
    		}
    	}
    	// System.out.println("Printing tree===");
    	// tree.printTree(tree.getRoot());
		return tree;
	}
}