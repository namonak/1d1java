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

class No16933Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("벽 부수고 이동하기 3 : https://www.acmicpc.net/problem/16933")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No16933.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "1 4 1\n" +
                        "0010",
                        "5"
                ),
                arguments(
                        "1 4 1\n" +
                        "0100",
                        "4"
                ),
                arguments(
                		"6 4 1\n" +
                		"0100\n" +
                		"1110\n" +
                		"1000\n" +
                		"0000\n" +
                		"0111\n" +
                		"0000",
                        "15"
                ),
                arguments(
						"6 4 2\n" +
						"0100\n" +
						"1110\n" +
						"1000\n" +
						"0000\n" +
						"0111\n" +
						"0000",
						"9"
				)
        );
    }
    // spotless:on
}
