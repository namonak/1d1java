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

class No2261Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("가장 가까운 두 점 : https://www.acmicpc.net/problem/2261")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No2261.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "4\n" +
                        "0 0\n" +
                        "10 10\n" +
                        "0 10\n" +
                        "10 0",
                        "100"
                ),
                arguments(
                        "3\n" +
                        "1 1\n" +
                        "2 3\n" +
                        "1 1",
                        "0"
                ),
                arguments(
                        "5\n" +
                        "-3 -4\n" +
                        "4 5\n" +
                        "-1 -1\n" +
                        "2 2\n" +
                        "3 3",
                        "2"
                ),
                arguments(
                        "6\n" +
                        "0 0\n" +
                        "0 3\n" +
                        "0 10\n" +
                        "5 5\n" +
                        "2 2\n" +
                        "2 3",
                        "1"
                ),
                arguments(
                        "2\n" +
                        "-10000 -10000\n" +
                        "10000 10000",
                        "800000000"
                )
        );
    }
    // spotless:on
}
