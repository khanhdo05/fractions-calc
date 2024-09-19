package edu.grinnell.csc207.util;

import java.math.BigInteger;

/**
 * BigFraction is an extended version of the Fraction class we worked in lab. A simple
 * implementation of arbitrary-precision Fractions.
 *
 * Acknowledgements: BigFraction was inspired by the BigFraction class in the Designing your own
 * class lab. Some code was taken like method add, doubleValue, multiply, toString, fractional
 */
public class BigFraction {
  // +------------------+---------------------------------------------
  // | Design Decisions |
  // +------------------+

  /*
   * (1) Denominators are always positive. Therefore, negative fractions are represented with a
   * negative numerator. Similarly, if a fraction has a negative numerator, it is negative.
   *
   * (2) Fractions are simplified.
   *
   * (3) Methods: add, subtract, multiply, divide, simplify, fractional, doubleValue and toString
   *
   * (4) Accessor methods: getNumerator, getDenominator
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
   * Build a new fraction with BigInteger type numerator and BigInteger type denominator.
   *
   * @param numerator The numerator of the fraction.
   * @param denominator The denominator of the fraction.
   */
  public BigFraction(BigInteger numerator, BigInteger denominator) {
    this.num = numerator;
    this.denom = denominator;
    simplifyAndEnsurePositive();
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
    simplifyAndEnsurePositive();
  } // BigFraction(int, int)

  /**
   * Parsing a string to build a fraction.
   *
   * @param fraction
   *
   */
  public BigFraction(String fraction) {
    String[] splitStr = fraction.split("/");

    // In case of a whole number
    switch (splitStr.length) {
      case 1:
        this.num = new BigInteger(splitStr[0]);
        this.denom = BigInteger.ONE;
        break;
      case 2:
        this.num = new BigInteger(splitStr[0]);
        this.denom = new BigInteger(splitStr[1]);
        break;
      default:
        throw new IllegalArgumentException("Invalid fraction format");
    } // switch

    simplifyAndEnsurePositive();
  } // BigFraction(String)

  // +------------------+--------------------------------------------
  // | Accessor Methods |
  // +------------------+

  /**
   * Get the numerator of the fraction.
   *
   * @return numerator
   */
  public BigInteger numerator() {
    return this.num;
  } // getNumerator()

  /**
   * Get the denominator of the fraction.
   *
   * @return denominator
   */
  public BigInteger denominator() {
    return this.denom;
  } // getDenominator()

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Ensure that the denominator is positive. If the denominator is negative, adjust both the
   * numerator and denominator to keep the fraction equivalent.
   */
  private void ensurePositiveDenominator() {
    if (this.denom.compareTo(BigInteger.ZERO) < 0) {
      this.num = this.num.negate();
      this.denom = this.denom.negate();
    } // if
  } // ensurePositiveDenominator()

  /**
   * Convert this fraction to a string for ease of printing.
   *
   * @return a string that represents the fraction.
   */
  @Override
  public String toString() {
    // Special case: It's zero
    if (this.num.equals(BigInteger.ZERO)) {
      return "0";
    } // if it's zero

    // Simplify to whole number
    if (this.denom.equals(BigInteger.ONE)) {
      return this.num.toString();
    } // if

    // Lump together the string represention of the numerator,
    // a slash, and the string representation of the denominator
    // return this.num.toString().concat("/").concat(this.denom.toString());
    return this.num + "/" + this.denom;
  } // toString()

  /**
   * Simplify the current fraction.
   */
  private void simplify() {
    BigInteger ndGcd = this.num.gcd(this.denom);
    this.num = this.num.divide(ndGcd);
    this.denom = this.denom.divide(ndGcd);
  } // simplify()

  /**
   * Simplify the current fraction and ensure that the denominator is positive.
   */
  private void simplifyAndEnsurePositive() {
    simplify();
    ensurePositiveDenominator();
  } // simplifyAndEnsurePositive()

  /**
   * Express this fraction as a double.
   *
   * @return the fraction approxiamted as a double.
   */
  public double doubleValue() {
    return this.num.doubleValue() / this.denom.doubleValue();
  } // doubleValue()

  /**
   * Express this fraction as a fraction.
   *
   * @return the fractional part of the fraction.
   */
  public BigFraction fractional() {
    return createSimplifyAndEnsurePositiveDenom(this.num.mod(this.denom), this.denom);
  } // fractional()

  /**
   * Add another faction to this fraction.
   *
   * @param addend The fraction to add.
   *
   * @return the result of the addition.
   */
  public BigFraction add(BigFraction addend) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the product of this object's
    // denominator and addend's denominator
    resultDenominator = this.denom.multiply(addend.denom);
    // The numerator is more complicated
    resultNumerator = (this.num.multiply(addend.denom)).add(addend.num.multiply(this.denom));

    return createSimplifyAndEnsurePositiveDenom(resultNumerator, resultDenominator);
  } // add(BigFraction)

  /**
   * Multiply another fraction to this fraction.
   *
   * @param frac The fraction to multiply.
   *
   * @return the result of the multiplication.
   */
  public BigFraction multiply(BigFraction frac) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the product of this object's
    // denominator and num's denominator
    resultDenominator = this.denom.multiply(frac.denom);
    // The numerator is more complicated
    resultNumerator = this.num.multiply(frac.num);

    return createSimplifyAndEnsurePositiveDenom(resultNumerator, resultDenominator);
  } // add(BigFraction)

  /**
   * Subtract another fraction from this fraction.
   *
   * @param frac
   * @return the result of the subtraction
   */
  public BigFraction subtract(BigFraction frac) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the product of this object's
    // denominator and addend's denominator
    resultDenominator = this.denom.multiply(frac.denom);
    // The numerator is more complicated
    resultNumerator = (this.num.multiply(frac.denom)).subtract(frac.num.multiply(this.denom));

    return createSimplifyAndEnsurePositiveDenom(resultNumerator, resultDenominator);
  } // substract(BigFraction)

  /**
   * Divide this fraction by another fraction.
   *
   * @param frac
   * @return the result of the division
   */
  public BigFraction divide(BigFraction frac) {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the product of this object's
    // denominator and num's denominator
    resultDenominator = this.denom.multiply(frac.num);
    // The numerator is more complicated
    resultNumerator = this.num.multiply(frac.denom);

    return createSimplifyAndEnsurePositiveDenom(resultNumerator, resultDenominator);
  } // divide(BigFraction)

  /**
   * Create a BigFraction fraction and simplify it.
   *
   * @param numerator
   * @param denominator
   * @return the simplified fraction
   */
  private BigFraction createSimplifyAndEnsurePositiveDenom(BigInteger numerator,
      BigInteger denominator) {
    BigFraction result = new BigFraction(numerator, denominator);
    result.simplifyAndEnsurePositive();
    return result;
  } // createAndSimplify(BigInteger, BigInteger)
} // class BigFraction
