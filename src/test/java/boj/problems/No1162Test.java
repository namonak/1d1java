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

class No1162Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("도로포장 : https://www.acmicpc.net/problem/1162")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No1162.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "4 4 1\n" +
                        "1 2 10\n" +
                        "2 4 10\n" +
                        "1 3 1\n" +
                        "3 4 100",
                        "1"
                ),
                arguments(
                        "5 5 1\n" +
                        "1 2 100\n" +
                        "2 5 100\n" +
                        "1 3 1\n" +
                        "3 4 1\n" +
                        "4 5 100",
                        "2"
                ),
                arguments(
                        "3 2 2\n" +
                        "1 2 5\n" +
                        "2 3 7",
                        "0"
                ),
                arguments(
                        createLongDistanceCase(),
                        "2999000000"
                )
        );
    }
    // spotless:on

    private static String createLongDistanceCase() {
        StringBuilder sb = new StringBuilder();
        sb.append("3001 3000 1\n");
        for (int i = 1; i <= 3000; i++) {
            sb.append(i).append(' ').append(i + 1).append(" 1000000\n");
        }
        return sb.toString();
    }
}
