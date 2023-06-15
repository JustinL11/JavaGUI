/**
 * Controller for the GUI
 */

import java.io.File;
import java.io.*;
import java.util.*;

import java.awt.event.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * File Chooser Object
 * Listens to what file object user wants before running the program
 */
public class controller implements ActionListener { 
    
    @Override
    public void actionPerformed( ActionEvent ae) {
        
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter( new FileNameExtensionFilter( "Text Files", "txt", "text"));
        int chooserSuccess = chooser.showOpenDialog(null);
        if( chooserSuccess == JFileChooser.APPROVE_OPTION ) {
            File chosenFile = chooser.getSelectedFile();

            //Call the logic for HASH 
            //Write to file

            Hash readFile = new Hash();
            readFile.readToFile(chosenFile);

            readFile.parseTo();
            readFile.cleanUp();
            readFile.freqs();
            
            // Creates a new file instance and runs the function
        File file = new File("outfile.txt");

        try {
            file.createNewFile();
            System.out.println("Results created!");
        } catch (Exception e) {
            System.out.println("Output file already exist!");
        }

        
        BufferedWriter bf = null;
  
        try {
  
            // create new BufferedWriter for the output file
            bf = new BufferedWriter(new FileWriter(file));
  
            // iterate map entries
            for (Map.Entry<String, Integer> entry :
                 readFile.counts.entrySet()) {
  
                // put key and value separated by a colon
                bf.write(entry.getKey() + ":"
                         + entry.getValue());
  
                // new line
                bf.newLine();
            }
  
            bf.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
  
            try {
  
                // Close the writer
                bf.close();
            }
            catch (Exception e) {
            }
        }


        }
        else {
            System.out.println("The user must have cancelled");
        }
    }
}