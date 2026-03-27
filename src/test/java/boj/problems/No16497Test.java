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

class No16497Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("대출 요청 : https://www.acmicpc.net/problem/16497")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No16497.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "3\n" +
                        "1 2\n" +
                        "3 6\n" +
                        "5 8\n" +
                        "1",
                        "0"
                ),
                arguments(
                        "3\n" +
                        "1 2\n" +
                        "3 4\n" +
                        "5 8\n" +
                        "1",
                        "1"
                ),
                arguments(
                        "3\n" +
                        "1 2\n" +
                        "3 6\n" +
                        "5 8\n" +
                        "2",
                        "1"
                )
        );
    }
    // spotless:on
}
