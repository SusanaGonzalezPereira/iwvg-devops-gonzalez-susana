package es.upm.miw.iwvg_devops.code;

import java.util.Objects;

/**
 * Conceptos: Las fracciones propias son aquellas cuyo numerador es menor que el denominador
 * <p>
 * Las fracciones impropias son aquellas cuyo numerador es mayor que el denominador
 * <p>
 * Dos fracciones son equivalentes cuando el producto de extremos (numerador de la primera por denominador de la segunda) es igual al
 * producto de medios (denominador de la primera por el numerador de la segunda)
 * <p>
 * Las fracciones irreducibles son aquellas que no se pueden simplificar, esto sucede cuando el numerador y el denominador son primos entre
 * sí
 * <p>
 * Reducir varias fracciones a común denominador consiste en convertirlas en otras equivalentes que tengan el mismo denominador
 * <p>
 * Comparar fracciones
 * <p>
 * Suma fracciones: En primer lugar se reducen los denominadores a común denominador, y se suman o se restan los numeradores de las
 * fracciones equivalentes obtenidas
 * <p>
 * Multiplicación: La multiplicación de dos fracciones es otra fracción que tiene: Por numerador el producto de los numeradores. Por
 * denominador el producto de los denominadores.
 * <p>
 * La división de dos fracciones es otra fracción que tiene: Por numerador el producto de los extremos. Por denominador el producto de los
 * medios. Invertir fraccion
 */
public class Fraction {

    private int numerator;

    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction() {
        this(1, 1);
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public double decimal() {
        return (double) numerator / denominator;
    }

    public boolean isProper() {
        return this.numerator < this.denominator;
    }

    public boolean isImproper() {
        return this.numerator > this.denominator;
    }

    public boolean isEquivalent(Fraction f) {
        return this.numerator * f.denominator == f.numerator * this.denominator;
    }

    public Fraction add(Fraction f) {
        int newNumerator = (this.numerator * f.denominator) + (f.numerator * this.denominator);
        int newDenominator = this.denominator * f.denominator;
        return this.reduce(new Fraction(newNumerator, newDenominator));
    }

    private Fraction reduce(Fraction f) {
        int greaterCommonDenominator = greaterCommonDenominator(f.numerator, f.denominator);
        if (f.denominator == 0) {
            final int NAN_INT = 0;
            return new Fraction(NAN_INT, NAN_INT);
        }
        int newNumerator = f.numerator / greaterCommonDenominator;
        int newDenominator = f.denominator / greaterCommonDenominator;
        return new Fraction(newNumerator, newDenominator);
    }

    private int greaterCommonDenominator(int a, int b) {
        if (b == 0) return a;
        return greaterCommonDenominator(b, a % b);
    }

    public Fraction multiply(Fraction f) {
        int newNumerator = this.numerator * f.numerator;
        int newDenominator = this.denominator * f.denominator;
        return this.reduce(new Fraction(newNumerator, newDenominator));
    }

    public Fraction divide(Fraction f) {
        int newNumerator = this.numerator * f.denominator;
        int newDenominator = this.denominator * f.numerator;
        return this.reduce(new Fraction(newNumerator, newDenominator));
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + this.numerator +
                ", denominator=" + this.denominator +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Fraction && equals((Fraction) obj);
    }

    public boolean equals(Fraction f) {
        return this.numerator == f.numerator && this.denominator == f.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }
}