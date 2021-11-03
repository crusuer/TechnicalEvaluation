package org.example.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceServiceTest {

    private final PriceService underTest = new PriceService();

    @ParameterizedTest
    @MethodSource("generateData")
    void test(BigDecimal expected, String[] input) {
        // WHEN
        final BigDecimal result = underTest.getPrice(input);

        // THEN
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("cornerData")
    void cornerCases(BigDecimal expected, String[] input) {
        // WHEN
        final BigDecimal result = underTest.getPrice(input);

        // THEN
        assertEquals(expected, result);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(BigDecimal.valueOf(3.11), new String[]{"GR1"}),
                Arguments.of(BigDecimal.valueOf(3.11), new String[]{"GR1", "GR1"}),
                Arguments.of(BigDecimal.valueOf(6.22), new String[]{"GR1", "GR1", "GR1"}),
                Arguments.of(BigDecimal.valueOf(6.22), new String[]{"GR1", "GR1", "GR1", "GR1"}),
                Arguments.of(BigDecimal.valueOf(22.46), new String[]{"CF1", "CF1"}),
                Arguments.of(BigDecimal.valueOf(22.45), new String[]{"GR1", "SR1", "GR1", "GR1", "CF1"}),
                Arguments.of(BigDecimal.valueOf(16.61), new String[]{"SR1", "SR1", "GR1", "SR1"}),
                Arguments.of(BigDecimal.valueOf(30.57), new String[]{"GR1", "CF1", "SR1", "CF1", "CF1"})
        );
    }

    static Stream<Arguments> cornerData() {
        return Stream.of(
                Arguments.of(new BigDecimal("0.00"), null),
                Arguments.of(new BigDecimal("0.00"), new String[]{}),
                Arguments.of(new BigDecimal("0.00"), new String[]{""})
        );
    }
}
