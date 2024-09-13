package edu.grinnell.csc207.util;

import java.math.BigInteger;

/**
 * BigFraction is an extended version of the Fraction class we worked in lab. A
 * simple
 * implementation of arbitrary-precision Fractions.
 *
 */
public class BigFraction {
  // +------------------+---------------------------------------------
  // | Design Decisions |
  // +------------------+

  /*
   * (1) Denominators are always positive. Therefore, negative fractions are
   * represented with a
   * negative numerator. Similarly, if a fraction has a negative numerator, it is
   * negative.
   *
   * (2) Fractions are simplified.
   *
   * (3) Methods: add, subtract, multiply, divide, simplify, fractional and
   * toString
   *
   * (4) Methods: numerator, denominator
   */

  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+

  /** The numerator of the fraction. Can be positive, zero or negative. */
  private BigInteger num;

  /** The denominator of the fraction. Must be non-negative. */
  private BigInteger denom;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new fraction with BigInteger type numerator and BigInteger type
   * denominator.
   *
   * @param numerator   The numerator of the fraction.
   * @param denominator The denominator of the fraction.
   */
  public BigFraction(BigInteger numerator, BigInteger denominator) {
    this.num = numerator;
    this.denom = denominator;
  } // BigFraction(BigInteger, BigInteger)

  /**
   * Build a new fraction with int type numerator and int type denomominator.
   *
   * @param numerator
   * @param denominator
   */
  public BigFraction(int numerator, int denominator) {
    this.num = BigInteger.valueOf(numerator);
    this.denom = BigInteger.valueOf(denominator);
  } // BigFraction(int, int)

  /**
   * Parsing a string to build a fraction.
   *
   * @param fraction
   *
   */
  public BigFraction(String fraction) {
    String[] splitStr = fraction.split("/");
    this.num = new BigInteger(splitStr[0]);
    this.denom = new BigInteger(splitStr[1]);
  } // BigFraction(String)

  // +------------------+--------------------------------------------
  // | Accessor Methods |
  // +------------------+

  /**
   * Get the numerator of the fraction.
   *
   * @return numerator
   */
  public BigInteger getNumerator() {
    return this.num;
  } // getNumerator()

  /**
   * Get the denominator of the fraction.
   *
   * @return denominator
   */
  public BigInteger getDenominator() {
    return this.denom;
  } // getDenominator()

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+

} // BigFraction
