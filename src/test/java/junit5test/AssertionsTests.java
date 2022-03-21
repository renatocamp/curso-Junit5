package junit5test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssertionsTests {

    @Test
    void assertEqualsTests(){
        Assertions.assertEquals("Primeira String", "Segunda String" +
                "As Strings não são iguais");
    }

    @Test
    void assertEqualListTests(){
        List<String> expectedValues = Arrays.asList("Primeira string",
                "Segunda String", "Terceira String");

        List<String> actualValues = Arrays.asList("Primeira string",
                "Segunda String", "Terceira String");

        Assertions.assertEquals(expectedValues, actualValues);
    }
    @Test
    void assertArraysEqualTests(){
        int [] expectedValues = {1,2,3,4};
        int [] actualValues = {1,2,3,4};

        assertArrayEquals(expectedValues, actualValues);
    }
    @Test
    void assertTrueTest(){
        assertTrue(false, "Este teste é falso não valida true");
    }
}
