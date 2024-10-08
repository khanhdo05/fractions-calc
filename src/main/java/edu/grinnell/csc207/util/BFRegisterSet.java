package edu.grinnell.csc207.util;

/**
 * BFRegisterSet provides a set of registers for the BFCalculator. A set of registers corresponding
 * to the letters ‘a’ through ‘z’.
 *
 * @author Khanh Do
 */
public class BFRegisterSet {
  // +-----------+-------------------------------------------------
  // | Constants |
  // +-----------+

  /** The number of registers equal to alphabet size. */
  private static final int REGISTER_COUNT = 26;

  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+

  /** The set of registers for the BFCalculator. */
  private final BigFraction[] registers;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Default constructor. Setting lastCalculatedValue to 0.
   */
  public BFRegisterSet() {
    this.registers = new BigFraction[REGISTER_COUNT];
  } // BFCalculator()

  // +------------------+--------------------------------------------
  // | Accessor Methods |
  // +------------------+

  /**
   * Get the fraction at registered char.
   *
   * @param register
   * @return the fraction registered at char.
   */
  public BigFraction get(char register) {
    return this.registers[getRegisterIndex(register)];
  } // get(char)

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Stores val at register char.
   *
   * @param register
   * @param val
   */
  public void store(char register, BigFraction val) {
    java.io.PrintWriter pen = new java.io.PrintWriter(System.out, true);
    if (Character.isAlphabetic(register) && Character.isLowerCase(register)) {
      this.registers[getRegisterIndex(register)] = val;
      pen.println("STORED");
      return;
    } // if
    System.err.println("Error: Register must be a lowercase alphabetical letter.");
  } // store(char, BigFraction)

  /**
   * Get the index of register char.
   *
   * @param register
   * @return the index of register
   */
  private int getRegisterIndex(char register) {
    return register - 'a';
  } // getRegisterIndex(char)
} // class BFRegisterSet
