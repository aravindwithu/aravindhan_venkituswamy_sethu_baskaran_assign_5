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

	private FileProcessor file;
	private ArrayList<String> wordsGte3Chars;

	public PopulateVisitor(){
		wordsGte3Chars = new ArrayList<String>();
		MyLogger.writeMessage("Inside PopulateVisitor constructor",MyLogger.DebugLevel.CONSTRUCTOR);
	}

	public void setFile(FileProcessor fileIn){
		file = fileIn;
	}

	public void visit(TreeBuilder tree){
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
	}

	public Iterator getList(){
		Iterator iter = wordsGte3Chars.iterator();
		return iter;
	}
	
}