package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import java.util.Scanner;

import edu.grinnell.csc207.util.BaseCalculator;

/**
 * InteractiveCalculator takes user input expressions or commands, evaluates them, and prints the
 * results.
 *
 * @author Khanh Do
 */
public class InteractiveCalculator {

  /**
   * Main method for the InteractiveCalculator that takes user input and evaluates it.
   *
   * Will continue to prompt the user for input until the user types "QUIT".
   *
   * @param args command-line arguments
   */
  public static void main(String[] args) {
    // Initialize the base calculator
    BaseCalculator calculator = new BaseCalculator();

    PrintWriter pen = new PrintWriter(System.out, true);
    PrintWriter err = new PrintWriter(System.err, true);
    Scanner sc = new Scanner(System.in);

    pen.println("Interactive Calculator: Enter expressions or commands (type QUIT to exit)");

    while (calculator.isRunning()) {
      // Prompt the user for input
      System.out.print("> ");
      String userInput = sc.nextLine();

      // Parse and evaluate the user's input
      String result = calculator.parseCommand(userInput);

      if (result.startsWith("STORED") || userInput.toUpperCase().equals("QUIT")) {
        continue;
      } else if (result.equals("")) {
        err.println(calculator.errorMessage());
      } else {
        pen.println(result);
      } // if
    } // while

    // Close the scanner when quitting
    sc.close();
  } // main(String[])
} // class InteractiveCalculator
