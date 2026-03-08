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

class No14425Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("곱셈 : https://www.acmicpc.net/problem/14425")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No14425.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "5 11\n" +
                        "baekjoononlinejudge\n" +
                        "startlink\n" +
                        "codeplus\n" +
                        "sundaycoding\n" +
                        "codingsh\n" +
                        "baekjoon\n" +
                        "codeplus\n" +
                        "codeminus\n" +
                        "startlink\n" +
                        "starlink\n" +
                        "sundaycoding\n" +
                        "codingsh\n" +
                        "codinghs\n" +
                        "sondaycoding\n" +
                        "startrink\n" +
                        "icerink",
                        "4"
                )
        );
    }
    // spotless:on
}
