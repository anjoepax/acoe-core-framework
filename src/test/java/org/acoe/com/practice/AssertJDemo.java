package org.acoe.com.practice;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.assertj.core.data.Percentage;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class AssertJDemo {

    @Test(enabled = false)
    public void stringTest() {
        String temp = "Hello World";

        Assertions.assertThat(temp)
                .isNotNull()
                .as("String is empty actually").isNotEmpty()
                .isNotBlank()
                .isEqualTo("Hello World")
                .contains("Hello")
                .doesNotContain("Hi")
                .containsWhitespaces()
                .containsIgnoringCase("world")
                .matches("\\w.*" + " World")
                .doesNotContainPattern("\\d.*")
                .hasSize(11)
                .hasSizeGreaterThan(10)
                .hasSizeLessThan(20)
                .hasSizeBetween(10, 20)
                .endsWith("World")
                .isInstanceOf(String.class);
    }

    @Test(enabled = false)
    public void numberTest() {
        int a = 10;

        Assertions.assertThat(a)
                .isEqualTo(10)
                .isCloseTo(14, Offset.offset(5))
                .isInstanceOf(Integer.class)
                .isBetween(3, 15)
                .isCloseTo(12, Percentage.withPercentage(30))
                .isNotCloseTo(15, Percentage.withPercentage(30))
                .isPositive()
                .isEven()
                .isGreaterThanOrEqualTo(5)
                .isLessThanOrEqualTo(20);
    }

    @Test
    public void listTest() {
        List<String> list = Arrays.asList("Testing", "Mini", "Bytes");
        List<String> list2 = Arrays.asList("Testing", "Mini");
        List<String> list3 = Arrays.asList("Automation", "selenium");

        Assertions.assertThat(list)
                .hasSize(3)
                .hasSizeBetween(2, 15)
                .hasAtLeastOneElementOfType(String.class)
                .isNotEmpty()
                .contains("Testing")
                .doesNotContain("Automation")
                .startsWith("Testing")
                .containsExactlyInAnyOrder("Mini", "Testing", "Bytes")
                .withFailMessage(() -> "String is not having size less than 3").allMatch(s -> s.length() < 3)
                .containsAll(list2)
                .doesNotContainAnyElementsOf(list3);
    }
}
