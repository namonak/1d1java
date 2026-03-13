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

class No11438Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("LCA 2 : https://www.acmicpc.net/problem/11438")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No11438.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "15\n" +
                        "1 2\n" +
                        "1 3\n" +
                        "2 4\n" +
                        "3 7\n" +
                        "6 2\n" +
                        "3 8\n" +
                        "4 9\n" +
                        "2 5\n" +
                        "5 11\n" +
                        "7 13\n" +
                        "10 4\n" +
                        "11 15\n" +
                        "12 5\n" +
                        "14 7\n" +
                        "6\n" +
                        "6 11\n" +
                        "10 9\n" +
                        "2 6\n" +
                        "7 6\n" +
                        "8 13\n" +
                        "8 15",
                        "2\n" +
                        "4\n" +
                        "2\n" +
                        "1\n" +
                        "3\n" +
                        "1"
                )
        );
    }
    // spotless:on
}
