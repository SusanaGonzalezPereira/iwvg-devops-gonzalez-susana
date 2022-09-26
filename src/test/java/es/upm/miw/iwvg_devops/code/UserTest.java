package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    private User user;

    @BeforeEach
    public void setUp(){
        this.user = new User("userId", "UserName", "FamilyName", new ArrayList<>());
    }

    @Test
    public void testUserEmptyConstructor(){
        User other = new User();
        assertEquals( new ArrayList<>(), other.getFractions());
    }

    @Test
    public void testGetId(){
        assertEquals("userId", this.user.getId());
    }

    @Test
    public void testGetName(){
        assertEquals("UserName", this.user.getName());
    }

    @Test
    public void testGetFamilyName(){
        assertEquals("FamilyName", this.user.getFamilyName());
    }

    @Test
    public void testGetFractions(){
        assertEquals(new ArrayList(){} , this.user.getFractions());
    }

    @Test
    public void testSetName(){
        String newName = "newName";
        this.user.setName(newName);
        assertEquals(newName, this.user.getName());
    }

    @Test
    public void testSetFamilyName(){
        String newFamilyNameName = "NewFamilyName";
        this.user.setFamilyName(newFamilyNameName);
        assertEquals(newFamilyNameName, this.user.getFamilyName());
    }

    @Test
    public void testSetFractions(){
        Fraction fraction = new Fraction();
        List<Fraction> fractions = new ArrayList();
        fractions.add(fraction);
        this.user.setFractions(fractions);
        assertEquals(fractions , this.user.getFractions());
    }

    @Test
    public void testFullName(){
        assertEquals("UserName FamilyName", this.user.fullName());
    }

    @Test void testAddFraction(){
        this.user.addFraction(new Fraction());
        assertEquals(1, this.user.getFractions().size());
        this.user.addFraction(new Fraction());
        assertEquals(2, this.user.getFractions().size());
    }

    @Test
    public void testInitials(){
        assertEquals("U.F.", this.user.initials());
    }

    @Test
    public void testToString(){
        String toString = "User{id='userId', name='UserName', familyName='FamilyName', fractions=[]}";
        assertEquals(toString, this.user.toString());
    }
}
