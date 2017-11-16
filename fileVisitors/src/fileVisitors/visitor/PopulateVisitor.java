package fileVisitors.visitor;

import fileVisitors.util.MyLogger;
import fileVisitors.util.FileProcessor;
import fileVisitors.myTree.TreeBuilder;
import fileVisitors.myTree.Node;
import java.util.ArrayList;
import java.util.Iterator;

/**
* PopulateVisitor class.
* Created for cs542 - Design patterns, Assignment 5.
*/
public class PopulateVisitor implements VisitorI{
	private TreeBuilder tree;
	private ArrayList<String> wordsGte3Chars;

	public PopulateVisitor(){
		tree = new TreeBuilder();
		wordsGte3Chars = new ArrayList<String>();
		MyLogger.writeMessage("Inside PopulateVisitor constructor",MyLogger.DebugLevel.CONSTRUCTOR);
	}

	public Object visit(FileProcessor file){
		String line;
		while ((line = file.readLine(true)) != null)
	    {		    
    		String[] words = line.split(" ");
    		for(String word : words){
    			if(!word.equals("")){
    				if(word.length() > 3){
    					wordsGte3Chars.add(word);
    				}
    				tree.insertNode(word);
    			}
    		}
    	}
    	// System.out.println("Printing tree===");
    	// tree.printTree(tree.getRoot());
		return tree;
	}

	public Iterator getList(){
		Iterator iter = wordsGte3Chars.iterator();
		return iter;
	}
	
}