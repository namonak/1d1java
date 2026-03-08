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

class No18258Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("큐 2 : https://www.acmicpc.net/problem/18258")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No18258.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "15\n" +
                        "push 1\n" +
                        "push 2\n" +
                        "front\n" +
                        "back\n" +
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
                        "front",
                        "1\n" +
                        "2\n" +
                        "2\n" +
                        "0\n" +
                        "1\n" +
                        "2\n" +
                        "-1\n" +
                        "0\n" +
                        "1\n" +
                        "-1\n" +
                        "0\n" +
                        "3"
                )
        );
    }
    // spotless:on
}
