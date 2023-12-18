package com.junit.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

public class ConditionalTest {

    @Test
    @Disabled("Don't run the test until JIRA #123 is resolved")
    void basicTest() {
        //execute method and perform asserts
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testForWindowsOsOnly() {
        //execute method and perform asserts
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void testForMacOsOnly() {
        //execute method and perform asserts
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void testForLinuxOsOnly() {
        //execute method and perform asserts
    }

    @Test
    @EnabledOnOs({OS.MAC, OS.WINDOWS})
    void testForWindowsAndMacOsOnly() {
        //execute method and perform asserts
    }

    @Test
    @EnabledOnJre(JRE.JAVA_17)
    void testForOnlyForJava17() {
        //execute method and perform asserts
    }

    @Test
    @EnabledOnJre(JRE.JAVA_13)
    void testForOnlyForJava13() {
        //execute method and perform asserts
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_13, max = JRE.JAVA_21)
    void testForOnlyForJavaRange() {
        //execute method and perform asserts
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_13)
    void testForOnlyJavaRangeMin13() {
        //execute method and perform asserts
    }
    @Test
    @EnabledIfEnvironmentVariable(named = "LUV2CODE_ENV", matches = "DEV")
    void testForOnlyForDevEnvironment() {
        //execute method and perform asserts
    }

    @Test
    @EnabledIfSystemProperty(named="LUV2CODE_SYS_PROP)", matches="CI_CD_DEPLOY")
    void testForOnlyForSystemProperty() {
        //execute method and perform asserts
    }

}
