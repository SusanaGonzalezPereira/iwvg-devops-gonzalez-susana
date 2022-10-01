package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchesTest {

    private final int NAN_INT = 0;

    @Test
    void testFindFractionAdditionByUserId() {
        assertEquals(new Fraction(3, 1), new Searches().findFractionAdditionByUserId("1"));
        assertEquals(new Fraction(109, 30), new Searches().findFractionAdditionByUserId("2"));
        assertEquals(new Fraction(6, 5), new Searches().findFractionAdditionByUserId("3"));
        assertEquals(new Fraction(2, 1), new Searches().findFractionAdditionByUserId("4"));
        assertEquals(new Fraction(0, 1), new Searches().findFractionAdditionByUserId("5"));
        assertEquals(new Fraction(NAN_INT, NAN_INT), new Searches().findFractionAdditionByUserId("6"));
    }

    @Test
    void testFindFirstProperFractionByUserId() {
        assertEquals(new Fraction(0, 1), new Searches().findFirstProperFractionByUserId("1"));
        assertEquals(new Fraction(-1, 5), new Searches().findFirstProperFractionByUserId("2"));
        assertEquals(new Fraction(1, 5), new Searches().findFirstProperFractionByUserId("3"));
        assertEquals(new Fraction(NAN_INT, NAN_INT), new Searches().findFirstProperFractionByUserId("4"));
        assertEquals(new Fraction(0, 1), new Searches().findFirstProperFractionByUserId("5"));
        assertEquals(new Fraction(NAN_INT, NAN_INT), new Searches().findFirstProperFractionByUserId("6"));
    }

    @Test
    void testFindUserFamilyNameByAllNegativeSignFractionDistinct() {
        assertEquals(0, new Searches().findUserFamilyNameByAllNegativeSignFractionDistinct().count());
    }
}