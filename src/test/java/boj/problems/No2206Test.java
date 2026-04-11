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

class No2206Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("벽 부수고 이동하기 : https://www.acmicpc.net/problem/2206")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No2206.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "6 4\n" +
                        "0100\n" +
                        "1110\n" +
                        "1000\n" +
                        "0000\n" +
                        "0111\n" +
                        "0000",
                        "15"
                ),
                arguments(
                        "4 4\n" +
                        "0111\n" +
                        "1111\n" +
                        "1111\n" +
                        "1110",
                        "-1"
                )
        );
    }
    // spotless:on
}
