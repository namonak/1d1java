package boj.problems;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class No1546Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("평균  : https://www.acmicpc.net/problem/1546")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No1546.solve(reader);
        assertThat(Double.parseDouble(result))
                .isCloseTo(Double.parseDouble(expected), within(1e-2));
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "3\n" +
                        "40 80 60",
                        "75.0"
                ),
                arguments(
                        "3\n" +
                        "10 20 30",
                        "66.666664"
                ),
                arguments(
                        "4\n" +
                        "1 100 100 100",
                        "75.25"
                ),
                arguments(
                        "5\n" +
                        "1 2 4 8 16",
                        "38.75"
                ),
                arguments(
                        "2\n" +
                        "3 10",
                        "65.0"
                ),
                arguments(
                        "4\n" +
                        "10 20 0 100",
                        "32.5"
                ),
                arguments(
                        "1\n" +
                        "50",
                        "100.0"
                ),
                arguments(
                        "9\n" +
                        "10 20 30 40 50 60 70 80 90",
                        "55.555557"
                )
        );
    }
    // spotless:on
}
