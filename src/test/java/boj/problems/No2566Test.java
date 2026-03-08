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

class No2566Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("최댓값 : https://www.acmicpc.net/problem/2566")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No2566.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "3 23 85 34 17 74 25 52 65\n" +
                        "10 7 39 42 88 52 14 72 63\n" +
                        "87 42 18 78 53 45 18 84 53\n" +
                        "34 28 64 85 12 16 75 36 55\n" +
                        "21 77 45 35 28 75 90 76 1\n" +
                        "25 87 65 15 28 11 37 28 74\n" +
                        "65 27 75 41 7 89 78 64 39\n" +
                        "47 47 70 45 23 65 3 41 44\n" +
                        "87 13 82 38 31 12 29 29 80",
                        "90\n" +
                        "5 7"
                )
        );
    }
    // spotless:on
}
