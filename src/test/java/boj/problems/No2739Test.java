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

class No2739Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("구구단 : https://www.acmicpc.net/problem/2739")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No2739.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "2",
                        "2 * 1 = 2\n" +
                        "2 * 2 = 4\n" +
                        "2 * 3 = 6\n" +
                        "2 * 4 = 8\n" +
                        "2 * 5 = 10\n" +
                        "2 * 6 = 12\n" +
                        "2 * 7 = 14\n" +
                        "2 * 8 = 16\n" +
                        "2 * 9 = 18"
                )
        );
    }
    // spotless:on
}
