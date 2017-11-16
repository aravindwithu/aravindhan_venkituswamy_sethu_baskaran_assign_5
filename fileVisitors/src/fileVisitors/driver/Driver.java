package fileVisitors.driver;

//Header to import supporting classes.
import fileVisitors.store.Results;
import fileVisitors.util.FileProcessor;
import fileVisitors.util.MyLogger;

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

				String arg2 = "01234";// validates logger value is between 0 and 4.
				if(args[2].equals("${arg4}") || args[2].equals("") || args[2].length() != 1 || (!arg2.contains(args[2]))){
					throw new Exception("Logger value is incorrect");
				}
				else{
					try{
						MyLogger.setDebugValue(Integer.parseInt(args[2]));
					}
					catch(Exception e){
						e.printStackTrace();
						System.exit(0);
					}					
				}
		    }
		    else{
		    	throw new Exception("Please pass exactly 3 arguments 1.input-file 2.output-file 3.Debug-value");
		    }

		    // Object intialized for FileProcessor with respective input file.
			file = new FileProcessor(inputFile);
			// defines result object
			results = new Results(outputFile);
			String line;
		    // while ((line = file.readLine(true)) != null)
		    // {
		    	
		    // }
		    // closes the file resader.
		    file.readLine(false);
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
	    }
	}
}