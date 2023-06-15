import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @Author Justin Lee
 */

public class HashTest {

    @BeforeAll
    public static void setUpClass() {
        System.out.println("Running BeforeAll");
    }
    
    @AfterAll
    public static void tearDownClass() {
        System.out.println("Running AfterAll");
    }
    
    @BeforeEach
    public void setUp() {
        System.out.println("Running BeforeEach");
    }
    
    @AfterEach
    public void tearDown() {
        System.out.println("Running AfterEach");
    }

      /**
      * Test of the readToFile() function from Hash.java
      *
      * @param instance Creating a Hash object to test its functions
      * @param testFile arbitrary file object used to check is readToFile() can detect there is a file object present
      * @return true if there if file object matches with the correct file, meaning, file is present
      * @return false if file is not actually present within directory
      */
      @Test
     public void testReadToFile() {

        Hash instance = new Hash();
        
        File testFile = new File("test.txt");

        instance.readToFile(testFile);

        assertEquals(true, instance.readToFile(testFile));
     }

    /**
     * Testing ParseTo Hash Functions
     * 
     * @param instance Creating a Hash object to test its functions
     * @param test File object that takes "test.txt" and appends its contents into an arraylist
     * @param expected ArrayList that will have what SHOULD HAVE been parced into the arraylist
     */
    @Test
     public void testParseTo() {
        System.out.println("Running parseTo() test");
        Hash instance = new Hash();

        File test = new File("test.txt");
        instance.inFile = test;

        instance.parseTo();

        ArrayList<String> expected = new ArrayList<String>();

        expected.add("soup");
        expected.add("milk");
        expected.add("soupmilk");

        assertEquals(expected, instance.strList);

     }

      /**
      * Test of the cleanUp() function from Hash.java
      *
      * @param instance Creating a Hash object to test its functions
      * @param expected ArrayList that will have what SHOULD HAVE been parced into the arraylist
      */
      @Test
     public void testCleanUp() {
        System.out.println("Running cleanUp() test");
        Hash instance = new Hash();
        instance.strList.add("Soup");
        instance.strList.add("Milk");
        instance.strList.add("Soup.Milk.");

        instance.cleanUp();

        ArrayList<String> expected = new ArrayList<String>();

        expected.add("soup");
        expected.add("milk");
        expected.add("soupmilk");

        assertEquals(expected, instance.strList);
     }

      /**
      * Test of the freqs() function from Hash.java
      *
      * @param instance Creating a Hash object to test its functions
      * @param expected HashMap that will have what SHOULD HAVE been parced into the HashMap
      */
      @Test
     public void testFreqs() {

        System.out.println("Running freqs() test");
        Hash instance = new Hash();
        instance.strList.add("Soup");
        instance.strList.add("Soup");
        instance.strList.add("Milk");
        instance.strList.add("Soup.Milk.");

        instance.freqs();

        HashMap<String, Integer> expected = new HashMap<>();
        //Create HashMap Here
        expected.put("Soup", 2);
        expected.put("Milk", 1);
        expected.put("Soup.Milk.", 1);


        assertEquals(expected, instance.counts);
     }
}