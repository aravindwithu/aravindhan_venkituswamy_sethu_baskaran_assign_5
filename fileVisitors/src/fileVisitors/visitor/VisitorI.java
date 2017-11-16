package fileVisitors.visitor;

import fileVisitors.util.FileProcessor;

/**
* VisitorI interface.
* Created for cs542 - Design patterns, Assignment 5.
*/
public interface VisitorI{
	public Object visit(FileProcessor file);
}