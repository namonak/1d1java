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

class No2162Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("선분 그룹 : https://www.acmicpc.net/problem/2162")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No2162.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "3\n" +
                        "1 1 2 3\n" +
                        "2 1 0 0\n" +
                        "1 0 1 1",
                        "1\n3"
                ),
                arguments(
                        "3\n" +
                        "-1 -1 1 1\n" +
                        "-2 -2 2 2\n" +
                        "0 1 -1 0",
                        "2\n2"
                ),
                arguments(
                        "1\n" +
                        "0 0 1 1",
                        "1\n1"
                ),
                arguments(
                        "4\n" +
                        "0 0 4 0\n" +
                        "4 0 8 0\n" +
                        "2 -1 2 1\n" +
                        "10 0 11 0",
                        "2\n3"
                ),
                arguments(
                        "5\n" +
                        "0 0 1 1\n" +
                        "2 2 3 3\n" +
                        "0 3 3 0\n" +
                        "5 5 6 6\n" +
                        "6 6 7 7",
                        "4\n2"
                ),
                arguments(
                        "5\n" +
                        "0 0 10 10\n" +
                        "10 0 0 10\n" +
                        "3 3 8 8\n" +
                        "20 20 25 25\n" +
                        "30 30 35 35",
                        "3\n3"
                )
        );
    }
    // spotless:on
}
