package edu.grinnell.csc207.util;

import java.util.ArrayList;
import java.util.List;

/**
 * BaseCalculator will provides the basic parsing and evaluating operations.
 *
 * @author Khanh Do
 */
public class BaseCalculator {
  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * Field to match the operator in an operation.
   */
  private enum Operator {
    /**
     * Addition operator.
     */
    ADD,

    /**
     * Subtraction operator.
     */
    SUBTRACT,

    /**
     * Multiplication operator.
     */
    MULTIPLY,

    /**
     * Division operator.
     */
    DIVIDE;
  } // enum Operator

  /**
   * Field to hold the calculator object.
   */
  private final BFCalculator calculator;

  /**
   * Field to hold the register object.
   */
  private final BFRegisterSet registers;

  /**
   * Field to hold the first error message.
   */
  private final List<String> errorMessages;

  /**
   * Field to check if QUIT has been called.
   */
  private boolean isRunning;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Default constructor. Setting firstArgument and secondArgument to 0.
   */
  public BaseCalculator() {
    this.calculator = new BFCalculator();
    this.registers = new BFRegisterSet();
    this.errorMessages = new ArrayList<>();
    this.isRunning = true;
  } // BaseCalculator()

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get the recorded error message.
   *
   * @return the error message
   */
  public String errorMessage() {
    return this.errorMessages.get(this.errorMessages.size() - 1);
  } // errorMessage()

  /**
   * Check if the calculator is running.
   *
   * @return true if the calculator is running
   */
  public boolean isRunning() {
    return this.isRunning;
  } // isRunning()

  /**
   * Parses an operand, which could either be a fraction (e.g., "2/3") or a stored register (e.g.,
   * "a").
   *
   * @param input the operand to parse
   * @return the BigFraction representation of the operand
   */
  private BigFraction parseOperand(String input) {
    if (input.matches("[a-zA-Z]")) {
      // If it's a single letter, fetch the value from the register
      char register = input.charAt(0);
      return this.registers.get(register);
    } else if (input.contains("/")) {
      // It's a fraction
      String[] parts = input.split("/");
      int numerator = Integer.parseInt(parts[0]);
      int denominator = Integer.parseInt(parts[1]);
      return new BigFraction(numerator, denominator);
    } else {
      // It's a whole number
      return new BigFraction(Integer.parseInt(input), 1);
    } // if
  } // parseOperand(String)

  /**
   * Parses a user input command and performs the corresponding action.
   *
   * @param userInput the command to parse
   * @return the result of the command
   */
  public String parseCommand(String userInput) {
    String[] splitInput = userInput.split(" ");

    if (splitInput.length == 0) {
      this.errorMessages.add("Error: Empty input.");
      return "";
    } // if

    // Check if input is a special command (QUIT or STORE)
    String command = splitInput[0].toUpperCase();

    if (command.equals("QUIT")) {
      this.isRunning = false;
      return "QUIT";
    } // if

    if (command.equals("STORE")) {
      if (splitInput.length != 2) {
        this.errorMessages.add("Error: Store command requires a register.");
        return "";
      } // if
      if (splitInput[1].length() != 1 || !Character.isLetter(splitInput[1].charAt(0))) {
        this.errorMessages.add("Error: Register must be a single letter.");
        return "";
      } // if
      char register = splitInput[1].charAt(0);
      this.registers.store(register, this.calculator.get());
      return "STORED";
    } // if

    // Otherwise, treat it as an arithmetic expression (e.g., a + b)
    try {
      BigFraction result = evaluateExpression(splitInput);
      this.calculator.set(result);
      return BigFraction.formatOutput(result);
    } catch (Exception e) {
      this.errorMessages.add("Error: Invalid expression (" + e.getMessage() + ")");
      return "";
    } // try
  } // parseCommand(String)

  /**
   * Evaluates an arithmetic expression, supporting both fractions and stored variables.
   *
   * @param tokens the arguments in the expression
   * @return the result of the expression
   */
  private BigFraction evaluateExpression(String[] tokens) throws Exception {
    if (tokens.length % 2 == 0) {
      this.errorMessages
          .add("Error: Must have an odd number of tokens in an arithmetic expression.");
      return null;
    } // if

    // Start with the first operand (which could be a fraction or a stored variable)
    BigFraction currentResult = parseOperand(tokens[0]);

    // Loop through the tokens, processing operator-operand pairs
    for (int i = 1; i < tokens.length; i += 2) {
      Operator operator = getOperator(tokens[i]);
      BigFraction nextOperand = parseOperand(tokens[i + 1]);

      // Apply the operator to the current result and the next operand
      currentResult = calculate(currentResult, nextOperand, operator);
    } // for

    return currentResult;
  } // parseCommand(String)

  private Operator getOperator(String operator) {
    switch (operator) {
      case "+":
        return Operator.ADD;
      case "-":
        return Operator.SUBTRACT;
      case "*":
        return Operator.MULTIPLY;
      case "/":
        return Operator.DIVIDE;
      default:
        return null;
    } // switch
  } // getOperator(String)

  private BigFraction calculate(BigFraction firstArgument, BigFraction secondArgument,
      Operator operator) {
    switch (operator) {
      case ADD:
        return firstArgument.add(secondArgument);
      case SUBTRACT:
        return firstArgument.subtract(secondArgument);
      case MULTIPLY:
        return firstArgument.multiply(secondArgument);
      case DIVIDE:
        return firstArgument.divide(secondArgument);
      default:
        this.errorMessages.add("Error: Invalid operator.");
        return null;
    } // switch
  } // calculate(BigFraction, BigFraction, Operator)
} // class BaseCalculator
