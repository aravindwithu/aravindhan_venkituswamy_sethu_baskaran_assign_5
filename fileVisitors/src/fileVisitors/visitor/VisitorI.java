package fileVisitors.visitor;

import fileVisitors.myTree.TreeBuilder;

/**
* VisitorI interface.
* Created for cs542 - Design patterns, Assignment 5.
*/
public interface VisitorI{
	public void visit(TreeBuilder tree);
}