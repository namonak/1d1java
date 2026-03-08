package boj.problems;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class No3190Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("뱀 : https://www.acmicpc.net/problem/3190")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No3190.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "6\n" +
                        "3\n" +
                        "3 4\n" +
                        "2 5\n" +
                        "5 3\n" +
                        "3\n" +
                        "3 D\n" +
                        "15 L\n" +
                        "17 D",
                        "9"),
                arguments(
                        "10\n" +
                        "4\n" +
                        "1 2\n" +
                        "1 3\n" +
                        "1 4\n" +
                        "1 5\n" +
                        "4\n" +
                        "8 D\n" +
                        "10 D\n" +
                        "11 D\n" +
                        "13 L,",
                        "21"),
                arguments(
                        "10\n" +
                        "5\n" +
                        "1 5\n" +
                        "1 3\n" +
                        "1 2\n" +
                        "1 6\n" +
                        "1 7\n" +
                        "4\n" +
                        "8 D\n" +
                        "10 D\n" +
                        "11 D\n" +
                        "13 L",
                        "13")
        );
    }
    // spotless:on
}
