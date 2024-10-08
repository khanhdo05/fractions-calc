package edu.grinnell.csc207.main;

import java.io.PrintWriter;

import edu.grinnell.csc207.util.BaseCalculator;

/**
 * QuickCalculator provides a simple calculator that supports the following operations.
 *
 * @author Khanh Do
 */
public class QuickCalculator {
  /**
   * Main method.
   *
   * @param args
   */
  public static void main(String[] args) {
    // Initialize the base calculator
    BaseCalculator calculator = new BaseCalculator();

    PrintWriter pen = new PrintWriter(System.out, true);
    PrintWriter err = new PrintWriter(System.err, true);

    // Loop through all the command-line arguments (expressions or commands)
    for (String expression : args) {
      // Evaluate the expression using the base calculator's parseCommand method
      String result = calculator.parseCommand(expression);

      if (result.startsWith("STORED")) {
        continue;
      } else if (result.startsWith("QUIT")) {
        break;
      } else if (result.equals("")) {
        err.println(calculator.errorMessage());
      } else {
        pen.println(expression + " = " + result);
      } // if
    } // main(String[])
  } // main(String[])
} // class QuickCalculator
