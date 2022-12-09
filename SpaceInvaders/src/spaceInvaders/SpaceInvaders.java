package spaceInvaders;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;

/**
 * @author Katherine Watkins
 * SDEV 301
 * This program takes a file with 64 lines of integers and converts them to binary
 * then into a string output
 */


public class SpaceInvaders {
    public static final int lineCount = 8;
    public Alien[] alienArray = new Alien[64];

    /**
     *
     * @param fileName this is a file of 64 integers to convert
     * file is converted to array of Alien objects
     */
    public SpaceInvaders(String fileName) {
        try (Scanner s = new Scanner(new File(fileName))) {
            while (s.hasNextShort()) {
//  add numbers into array line by line
                for (int i = 0; i < alienArray.length; i++) {
                    alienArray[i] = new Alien(s.nextShort());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }

    /**
     * This method takes no parameters, but instead increments through our array and
     * calls Alien toString() on each object to convert to String picture output
     * Also adds extra line between each 8 line alien picture
     */
    private void printEachLine() {
        int count = 0;
        for (int i = 0; i < alienArray.length; i++) {
            System.out.println(alienArray[i].transformShort());
            count++;
            if(count == lineCount){
                System.out.println();
                count =0;
            }
        }
    }

    /**
     * This method will take the transformed Strings and store them to the
     * included save.txt file
     */
    private void writeToFile(){
        try {
            FileWriter myWriter = new FileWriter("src/spaceInvaders/save.txt");
            int count = 0;
            for (int i = 0; i < alienArray.length; i++) {
                myWriter.write(alienArray[i].transformShort());
                myWriter.write(System.lineSeparator());
                count++;
                if(count == lineCount){
                    myWriter.write(System.lineSeparator());
                    myWriter.write(System.lineSeparator());
                    count =0;
                }
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        SpaceInvaders test = new SpaceInvaders("src/spaceInvaders/spaceinvaders.txt");
        test.printEachLine();
        test.writeToFile();
    }
}
