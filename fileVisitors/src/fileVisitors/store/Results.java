package fileVisitors.store;

//Header to import supporting classes.
import java.util.ArrayList;
import java.util.Iterator;
import java.io.PrintWriter;
import fileVisitors.util.MyLogger;
import fileVisitors.util.FileDisplayInterface;
import fileVisitors.util.StdoutDisplayInterface;

/**
* Results class.
* Created for cs542 - Design patterns.
* Results class to process results of the test case.
* Implements FileDisplayInterface and StdoutDisplayInterface interfaces.
*/
public class Results implements FileDisplayInterface, StdoutDisplayInterface{
	private ArrayList<String> resultArray = new ArrayList<String>();// string array to store results.
	private PrintWriter writer;// writer object to write to file.
	/**
	* Results constructor to intialize Results class.
	* Calls intializeArray.
	*/
	public Results(String outputFile){
		try{
			MyLogger.writeMessage("Inside Results constructor",MyLogger.DebugLevel.CONSTRUCTOR);
			// Object for PrintWriter is intialized with respective output file name and encoding format.
			// To write original Tree to the output file.
			writer = new PrintWriter(outputFile, "UTF-8");
			intializeArray();
		}catch(Exception ex){
	    	System.err.println(ex.getMessage());// prints the error message.
	    	ex.printStackTrace();// prints stack trace.
	    	System.exit(0);
	    }
	}
	/**
	* intializeArray method.
	* intializes resultArray with empty string.
	*/
	private void intializeArray(){
		for(int i=0; i < resultArray.size(); i++){
			resultArray.set(i, "");
		}
	}
	/**
	* storeNewResult method.
	* Stores the given value in given index.
	* @param value of string to be stored.
	*/
	public void storeNewResult(String value){
		resultArray.add(value);
	}

	/**
	* getIterator method.
	* @return Iterator (iter)
	*/
	public Iterator getIterator(){
		 Iterator iter = resultArray.iterator();
		 return iter;
	}
	/**
	* closeWriter method.
	*/
	public void closeWriter(){
		try{
			writer.close();
		}catch(Exception ex){
	    	System.err.println(ex.getMessage());// prints the error message.
	    	ex.printStackTrace();// prints stack trace.
	    	System.exit(0);
	    }
	    finally{// Clears all the objects created.
		    writer = null;
	    }
	}

	/**
	* printAll method.
	* prints all the values in resultArray to command line.
	*/
	public void printAll(){
		for(int i = 0; i < resultArray.size(); i++){
			writeToScreen(resultArray.get(i));
		}
	}

	/**
	* writeAll method.
	* writes all the values in resultArray to output file.
	*/
	public void writeAll(){
		try{
			for(int i = 0; i < resultArray.size(); i++){
				writeSchedulesToFile(resultArray.get(i));
			}
			writer.close();
		}catch(Exception ex){
	    	System.err.println(ex.getMessage());// prints the error message.
	    	ex.printStackTrace();// prints stack trace.
	    	System.exit(0);
	    }
	    finally{// Clears all the objects created.
		    writer = null;
	    }
	}
	/**
	* writeToScreen method.
	* Implements StdoutDisplayInterface writeToScreen method.
	* gets String s as argument.
	* prints the given string to command line.
	* @param s to print the same to output command line.
	*/
	public void writeToScreen(String s){
		//System.out.println(s);
		MyLogger.writeMessage("Result debuging - "+s,MyLogger.DebugLevel.FILE_WRITE);
	}
	/**
	* writeToFile method.
	* Implements FileDisplayInterface writeToFile method.
	* gets String s as argument.
	* writes the given string to output file.
	* @param s to be writtern to the writer object. 
	*/
	public void writeSchedulesToFile(String s){
		writer.println(s);
	}
}