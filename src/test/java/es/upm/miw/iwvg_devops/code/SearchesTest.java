package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchesTest {

    @Test
    void testFindFractionAdditionByUserId() {
        assertEquals(new Fraction(3, 1), new Searches().findFractionAdditionByUserId("1"));
        assertEquals(new Fraction(109, 30), new Searches().findFractionAdditionByUserId("2"));
        assertEquals(new Fraction(6, 5), new Searches().findFractionAdditionByUserId("3"));
        assertEquals(new Fraction(2, 1), new Searches().findFractionAdditionByUserId("4"));
        assertEquals(new Fraction(0, 1), new Searches().findFractionAdditionByUserId("5"));
    }

    @Test
    void findFirstProperFractionByUserId() {
        assertEquals(new Fraction(0, 1), new Searches().findFirstProperFractionByUserId("1"));
        assertEquals(new Fraction(-1, 5), new Searches().findFirstProperFractionByUserId("2"));
        assertEquals(new Fraction(1, 5), new Searches().findFirstProperFractionByUserId("3"));
        assertEquals(new Fraction(0, 1), new Searches().findFirstProperFractionByUserId("4"));
        assertEquals(new Fraction(0, 1), new Searches().findFirstProperFractionByUserId("5"));
    }
}