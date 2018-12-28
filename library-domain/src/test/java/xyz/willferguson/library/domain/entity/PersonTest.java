package xyz.willferguson.library.domain.entity;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testAddFineGivesCorrectResult() {
        Person person = new Person("");
        person.addFine(BigDecimal.TEN);
        person.addFine(BigDecimal.ONE);
        assertEquals(BigDecimal.valueOf(11), person.getOutstandindFines(), "Outstanding fines should be 11");

    }
}