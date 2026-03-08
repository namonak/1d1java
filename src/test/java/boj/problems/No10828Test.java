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

class No10828Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("스택 : https://www.acmicpc.net/problem/10828")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No10828.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "14\n" +
                        "push 1\n" +
                        "push 2\n" +
                        "top\n" +
                        "size\n" +
                        "empty\n" +
                        "pop\n" +
                        "pop\n" +
                        "pop\n" +
                        "size\n" +
                        "empty\n" +
                        "pop\n" +
                        "push 3\n" +
                        "empty\n" +
                        "top",
                        "2\n" +
                        "2\n" +
                        "0\n" +
                        "2\n" +
                        "1\n" +
                        "-1\n" +
                        "0\n" +
                        "1\n" +
                        "-1\n" +
                        "0\n" +
                        "3"
                ),
                arguments(
                        "7\n" +
                        "pop\n" +
                        "top\n" +
                        "push 123\n" +
                        "top\n" +
                        "pop\n" +
                        "top\n" +
                        "pop",
                        "-1\n" +
                        "-1\n" +
                        "123\n" +
                        "123\n" +
                        "-1\n" +
                        "-1"
                )
        );
    }
    // spotless:on
}
