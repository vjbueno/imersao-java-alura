// Java Program to Print Colored Text in Console
  
// Importing required classes
import java.io.*;
import javax.swing.JColorChooser;
  
// Main class
class teste {
  
    // Declaring ANSI_RESET so that we can reset the color
    public static final String ANSI_RESET = "\u001B[0m";
    // Declaring the background color
    public static final String ANSI_RED_BACKGROUND
        = "\u001B[41m";
  
    // Main driver method
    public static void main(String[] args)
    {
        // Now add the particular background color
        System.out.println(ANSI_RED_BACKGROUND
                           + "The background color is red"
                           + ANSI_RESET);
    }
}