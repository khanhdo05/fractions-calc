package edu.grinnell.csc207.util;

/**
 * BFCalculator is the primary workhorse. This class should have a field that stores the last value
 * calculated and provide the following methods.
 *
 * get(), add(BigFraction), subtract(BigFraction), multiply(BigFraction) divide(BigFraction),
 * clear()
 */
public class BFCalculator {
  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+

  /** The last calculated BigFraction value. */
  private BigFraction lastCalculatedValue;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Default constructor. Setting lastCalculatedValue to 0.
   */
  public BFCalculator() {
    this.lastCalculatedValue = new BigFraction(0, 1);
  } // BFCalculator()

  /**
   * Default constructor. Setting lastCalculatedValue to val.
   *
   * @param val
   */
  public BFCalculator(BigFraction val) {
    this.lastCalculatedValue = val;
  } // BFCalculator(BigFraction)

  // +------------------+--------------------------------------------
  // | Accessor Methods |
  // +------------------+

  /**
   * Get the numerator of the fraction.
   *
   * @return last calculated BigFraction value
   */
  public BigFraction get() {
    return this.lastCalculatedValue;
  } // get()

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Adds val to the last computed value.
   *
   * @param val
   */
  public void add(BigFraction val) {
    this.lastCalculatedValue = this.lastCalculatedValue.add(val);
  } // add(BigFraction)

  /**
   * Substract val from the last computed value.
   *
   * @param val
   */
  public void subtract(BigFraction val) {
    this.lastCalculatedValue = this.lastCalculatedValue.subtract(val);
  } // substract(BigFraction)

  /**
   * Multiply val with the last computed value.
   *
   * @param val
   */
  public void multiply(BigFraction val) {
    this.lastCalculatedValue = this.lastCalculatedValue.multiply(val);
  } // multiply(BigFraction)

  /**
   * Divide val from the last computed value.
   *
   * @param val
   */
  public void divide(BigFraction val) {
    this.lastCalculatedValue = this.lastCalculatedValue.divide(val);
  } // divide(BigFraction)

  /**
   * Clear the last computed value. Set last calculated value to 0.
   */
  public void clear() {
    this.lastCalculatedValue = new BigFraction(0, 1);
  } // clear()
} // class BFCalculator
