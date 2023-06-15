import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Author @Justin Lee
 */

public class Hash {

    // HashMap that will be appended and parsed
    protected HashMap<String, Integer> counts = new HashMap<>();
    protected ArrayList<String> strList = new ArrayList<String>();;
    File inFile;


    /**
     * Function to test whether or not there IS a file to be read from before the program goes forward.
     * 
     * TODO: GUI Implementation
     * 
     * @param input File that is read from
     * @param inFile Saves contents from input to be read into our arrays.
     * @return true if file is found within directory
     * @return false if there is no file given name
     */
    public boolean readToFile(File input) {
        try {
        Scanner scanner = new Scanner(input);
        inFile = input;

        // File inFile = new File("input.txt"); //For testing purposes
        
        return true;
        }

        catch (FileNotFoundException e) {
            System.out.println("File not found/File is Nill: " + e.getMessage());
            return false;
        }

    }

    /**
     * For now, Reads our text file and appends all the lines into an Arraylist unfiltered
     * 
     * 
     * @param inFile File that we are reading from line to line
     * @param scanner Used to read infile
     * @param word String value we are grabbing from inFile
     * @param strList ArrayList that we are appending into
     * @return Error if no file found, otherwise, no return value.
     */
    public void parseTo() {
        try {
            // File inFile = new File("input.txt"); //For testing purposes
            Scanner scanner = new Scanner(inFile);
            while (scanner.hasNext()) {
                String word = scanner.next();
                //adding it all to our array 
                strList.add(word);
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Nothing to read from: " + e.getMessage());
            return;
        }
    }

    /**
     * Function that cleans up the instance ArrayList
     * Removing all puncuations and non-letter characters 
     * 
     * @param strList The ArrayList we are iterating through and cleaning up
     * @param word String value that is copied from element i of strList
     * @return No return value available. 
     */
    public void cleanUp() {
        for(int i = 0; i < strList.size(); i++) {
            String word = strList.get(i);
            word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
            strList.set(i, word);

        }
    }
    
    /**
     * 
     * Takes Arraylist of Strings and seperates the reoccuring words into a HashMap
     * Counts each word and if its already in the Hash, increment the Integer
     * 
     * @param strList The ArrayList we are appending into our HashMap
     * @param word String containing the current word being read from strList
     * @param counts The HashMap we are putting words and counting for reoccuring words
     * @return Void. File Not Found Exception if there is no input.txt... For now
     */
     void freqs() {
            for(String word : strList) {

                if (word.length() > 0) {
                    // update the word frequency count
                    if (counts.containsKey(word)) {
                        counts.put(word, this.counts.get(word) + 1);
                    } else {
                        counts.put(word, 1);
                    }
                }
            }
    }


    /**
     *  Function prints HashMap's word and frequencies by iterating through with a for loop.
     * 
     * @param counts HashMap being iterated through.
     * @param word Index being printed out.
     * @return Void. But prints the Word and Counts to output.
     */
    public void printHash() {
        for (String word : counts.keySet()) {
            System.out.println(word + ": " + counts.get(word));
        }
    }
}