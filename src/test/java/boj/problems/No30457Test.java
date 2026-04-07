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

class No30457Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("단체줄넘기 : https://www.acmicpc.net/problem/30457")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No30457.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "5\n" +
                        "1 2 3 4 5",
                        "5"
                ),
                arguments(
                        "10\n" +
                        "1 3 2 4 2 4 4 3 2 7",
                        "8"
                ),
                arguments(
                        "5\n" +
                        "10 10 10 10 10",
                        "2"
                )
        );
    }
    // spotless:on
}
