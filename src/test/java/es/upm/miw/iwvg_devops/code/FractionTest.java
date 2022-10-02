package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {

    private Fraction fraction;

    @BeforeEach
    void setUp() {
        this.fraction = new Fraction(1, 2);
    }

    @Test
    void testFractionEmptyConstructor() {
        Fraction defaultFraction = new Fraction();
        assertEquals(1, defaultFraction.getNumerator());
        assertEquals(1, defaultFraction.getDenominator());
    }

    @Test
    void testGetNumerator() {
        assertEquals(1, this.fraction.getNumerator());
    }

    @Test
    void testSetNumerator() {
        this.fraction.setNumerator(5);
        assertEquals(5, this.fraction.getNumerator());
    }

    @Test
    void testGetDenominator() {
        assertEquals(2, this.fraction.getDenominator());
    }

    @Test
    void testSetDenominator() {
        this.fraction.setDenominator(8);
        assertEquals(8, this.fraction.getDenominator());
    }

    @Test
    void testDecimal() {
        assertEquals(0.5, this.fraction.decimal(), 0.001);
    }

    @Test
    void testToString() {
        String toString = "Fraction{numerator=1, denominator=2}";
        assertEquals(toString, this.fraction.toString());
    }

    @Test
    void testFractionIsProper() {
        assertTrue(this.fraction.isProper());
    }

    @Test
    void testFractionIsNotProper() {
        Fraction f = new Fraction(2, 1);
        assertFalse(f.isProper());
    }

    @Test
    void testIsImproper() {
        Fraction f = new Fraction(2, 1);
        assertTrue(f.isImproper());
    }

    @Test
    void testIsNotImproper() {
        assertFalse(this.fraction.isImproper());
    }

    @Test
    void testIsEquivalent() {
        Fraction equivalent = new Fraction(10, 20);
        assertTrue(this.fraction.isEquivalent(equivalent));
    }

    @Test
    void testAddFraction() {
        Fraction addFraction = new Fraction(1, 4);
        assertEquals(new Fraction(3, 4), this.fraction.add(addFraction));
    }

    @Test
    void testMultiply() {
        Fraction addFraction = new Fraction(2, 4);
        assertEquals(new Fraction(1, 4), this.fraction.multiply(addFraction));
    }

    @Test
    void testDivide() {
        Fraction addFraction = new Fraction(10, 20);
        assertEquals(new Fraction(1, 1), this.fraction.divide(addFraction));
    }

    @Test
    void testHashCode() {
        Fraction equalHashcode = new Fraction(1, 2);
        assertEquals(equalHashcode.hashCode(), this.fraction.hashCode());
    }

}
