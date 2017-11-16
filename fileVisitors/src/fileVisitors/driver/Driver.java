package fileVisitors.driver;

//Header to import supporting classes.
import fileVisitors.util.Results;
import fileVisitors.util.FileProcessor;
import fileVisitors.util.MyLogger;
import java.io.PrintWriter;

/**
* Driver class contains main method.
* Created for cs542 - Design patterns, Assignment 5.
*/
public class Driver 
{
	public static void main(String[] args) 
	{
	    // Object declared for Results class (Original).
	    Results results;
	    // Object declared for FileProcessor class.
	    FileProcessor file;
	    // Object declared for PrintWriter class.
	    PrintWriter writer;
	    // Object declared for MyLogger class.
	    MyLogger myLogger;

	    try{
	    	// command line validation for input file and output file respectively.
	    	String inputFile = "",outputFile = "";
		    if(3 == args.length){// validates given arguments array length to 5.
		    	if(!args[0].equals("${arg0}") && !args[0].equals("")){// validates 1st input file argument value.
		    		inputFile = args[0];
		    	}
		    	else{
		    		throw new Exception("Please provide input file.");
		    	}

		    	if(!args[1].equals("${arg1}") && !args[1].equals("")){// validates 2nd output file argument value.
					outputFile = args[1];
		    	}
		    	else{
		    		throw new Exception("Please provide output file.");
		    	}

				String arg4 = "01234";// validates logger value is between 0 and 4.
				if(args[4].equals("${arg4}") || args[4].equals("") || args[4].length() != 1 || (!arg4.contains(args[4]))){
					throw new Exception("Logger value is incorrect");
				}
				else{
					try{
						MyLogger.setDebugValue(Integer.parseInt(args[4]));
					}
					catch(Exception e){
						e.printStackTrace();
						System.exit(0);
					}
					
				}
		    }
		    else{
		    	throw new Exception("Please pass exactly 2 arguments one for input and another for output files.");
		    }

		    // Object intialized for FileProcessor with respective input file.
			file = new FileProcessor(inputFile);
			// The input values are read from file and stored treeBuilder object in BST format.
			
			// defines result object
			results = new Results();
			// defines myLogger object
			myLogger = new MyLogger();
			// intializes airportSecurity object
			// AirportSecurity airportSecurity = new AirportSecurity();
			String line;
		    while ((line = file.readLine(true)) != null)
		    {
		    	// context class - tightenOrLoosenSecurity method is called.
		    	// airportSecurity.tightenOrLoosenSecurity(line);
		    	// context class - operate method is called.
		    	// String result = airportSecurity.operate();
		    	// Logger for result sring returned from operate method.
		    	// myLogger.writeMessage(result, MyLogger.DebugLevel.RESULTS_OUTPUT);
		    	// The return operation string is stored in result object
		    	// results.storeNewResult(result);
		    }
		    // closes the file resader.
		    file.readLine(false);

		   	// Object for PrintWriter is intialized with respective output file name and encoding format.
		   	// To write original Tree to the output file.
		   	writer = new PrintWriter(outputFile, "UTF-8");
		    // writeAll method from Results class is called with writer object to write the test case results to the output file.
		    results.writeAll(writer);
		    // writer object is closed.
		    writer.close();

		    System.out.println("Output files generated successfully.");
	    }
	    catch(Exception ex){
	    	System.err.println(ex.getMessage());// prints the error message.
	    	ex.printStackTrace();// prints stack trace.
	    	System.exit(0);
	    }
	    finally{// Clears all the objects created.
		    results = null;
		    file = null;
		    writer = null;
		    myLogger = null;
	    }
	}
}