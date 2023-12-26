package com.luv2code.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FizzBuzzTest {

    // If number is divisible by 3, print Fizz
    // If number is divisible by 5, print Buzz
    // If number is divisible by 3 and 5, print FizzBuzz
    // If number is NOT divisible by 3 and 5, print Number

    @Test
    @DisplayName("Divisible by Three")
    void testForDivisibleByThree() {
        String expected = "Fizz";

        assertEquals(expected, FizzBuzz.compute(3));
    }

    @Test
    @DisplayName("Divisible by Five")
    void testForDivisibleByFive() {
        String expected = "Buzz";

        assertEquals(expected, FizzBuzz.compute(50));
    }

    @Test
    @DisplayName("Divisible by Three and Five")
    void testForDivisibleByThreeAndFive() {
        String expected = "FizzBuzz";

        assertEquals(expected, FizzBuzz.compute(15));
    }

    @Test
    @DisplayName("Not Divisible by Three or Five")
    void testForNotDivisibleByThreeOrFive() {
        String expected = "1";

        assertEquals(expected, FizzBuzz.compute(1));
    }

    @DisplayName("Testing with small data file")
    @ParameterizedTest(name = "value={0}, expected={1}")
    @CsvFileSource(resources = "/small-test-data.csv")
    @Order(5)
    void testSmallDataFile(int value, String expected) {

        assertEquals(expected, FizzBuzz.compute(value));
    }

    @DisplayName("Testing with small data file")
    @ParameterizedTest(name = "value={0}, expected={1}")
    @CsvFileSource(resources = "/medium-test-data.csv")
    @Order(5)
    void testMediumDataFile(int value, String expected) {

        assertEquals(expected, FizzBuzz.compute(value));
    }

    @DisplayName("Testing with small data file")
    @ParameterizedTest(name = "value={0}, expected={1}")
    @CsvFileSource(resources = "/large-test-data.csv")
    @Order(5)
    void testLargeDataFile(int value, String expected) {

        assertEquals(expected, FizzBuzz.compute(value));
    }

}






