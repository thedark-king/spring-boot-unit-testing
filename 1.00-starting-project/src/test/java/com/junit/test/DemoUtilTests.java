package com.junit.test;


import com.luv2code.junitdemo.DemoUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

//@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class) //It removes the (), replaces _ with spaces and generate the Displayname for the test cases Eg: Test Equals and Not Equals
//@DisplayNameGeneration(DisplayNameGenerator.Simple.class) //It removes the (), replaces _ with spaces and generate the Displayname for the test cases Eg: Test Equals and Not Equals
//@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class) //It generates setence based on test class and test method name eg: DemoUtilsTest, testNullAndNotNull() Syntax: <testclassname>, <testmethodname>
class DemoUtilTests {

    DemoUtils demoUtils;

    @BeforeAll
    static void setupBeaeforeAll() {
        System.out.println("@BeforeAll execute only once before all test methods execution in the class");
    }

    @AfterAll
    static void setupAftereAll() {
        System.out.println("@AfterAll execute only once before all test methods execution in the class");
    }

    @BeforeEach
    void setupBeforeEach() {
        demoUtils = new DemoUtils();
        System.out.println("@BeforeEach executes before the execution of each test method");
    }

    @DisplayName("Same and Not Same")
    @Test
    void testSameAndNotSame() {

        String str = "luv2code";

        assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate(), "Objects should refer to same object");
        assertNotSame(str, demoUtils.getAcademy(), "Objects should not refer to same object");
    }

    @DisplayName("True and False")
    @Test
    @Order(30)
    void testTrueFalse() {
        int gradeOne = 10;
        int gradeTwo = 5;

        assertTrue(demoUtils.isGreater(gradeOne, gradeTwo), "This should return true");
        assertFalse(demoUtils.isGreater(gradeTwo, gradeOne), "This should return false");

    }

    @AfterEach
    void setupAfterEach() {
        demoUtils = new DemoUtils();
        System.out.println("@AfterEach executes before the execution of each test method");
    }

    @Test
    @DisplayName("Equals and Not Equals")
    void testEqualsAndNotEquals() {
        System.out.println("Running test: testEqualsAndNotEquals");

        DemoUtils demoUtilTests = new DemoUtils();
        assertEquals(6, demoUtilTests.add(2, 4), "2+4 must be 6");
        assertNotEquals(6, demoUtilTests.add(2, 9), "2+4 must be 6");
    }

    @Test
    @DisplayName("Null and Not Null")
    void testNullAndNotNull() {
        System.out.println("Running test: testNullAndNotNull");

        DemoUtils demoUtils = new DemoUtils();
        String str1 = null;
        String str2 = "love2code";
        assertNull(demoUtils.checkNull(str1), "Object should be null");
        assertNotNull(demoUtils.checkNull(str2), "Object should not be null");
    }

    @DisplayName("Array Equals")
    @Test
    void testArrayEquals() {
        String[] stringArray = {"A", "B", "C"};

        assertArrayEquals(stringArray, demoUtils.getFirstThreeLettersOfAlphabet());
    }


    @DisplayName("Iterable equals")
    @Test
    void testIterableEquals() {
        List<String> theList = List.of("luv", "2", "code");
        assertLinesMatch(theList, demoUtils.getAcademyInList());
    }

    @DisplayName("Throws nd Does not Throws")
    @Test
    void testThrowsAndDoesNotException() {
        assertThrows(Exception.class, () -> demoUtils.throwException(-1));
        assertDoesNotThrow(() -> demoUtils.throwException(2));
    }

    @DisplayName("Timeout")
    @Test
    void testTimeout() {

        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> demoUtils.checkTimeout());
//        assertTimeoutPreemptively(Duration.ofSeconds(1), ()-> demoUtils.checkTimeout()); //Fails
    }

    @DisplayName("Multiply")
    @Test
    void testsMultiply() {
        assertEquals(6, demoUtils.multiply(2, 3));
        assertNotEquals(7, demoUtils.multiply(2, 3));
    }
}
