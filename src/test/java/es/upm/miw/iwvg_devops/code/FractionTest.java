package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FractionTest {

    private Fraction fraction;

    @BeforeEach
    void setUp() {
        this.fraction = new Fraction(1,2);
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

}
