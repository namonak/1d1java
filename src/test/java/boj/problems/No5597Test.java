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

class No5597Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("곱셈 : https://www.acmicpc.net/problem/5597")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No5597.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "3\n" +
                        "1\n" +
                        "4\n" +
                        "5\n" +
                        "7\n" +
                        "9\n" +
                        "6\n" +
                        "10\n" +
                        "11\n" +
                        "12\n" +
                        "13\n" +
                        "14\n" +
                        "15\n" +
                        "16\n" +
                        "17\n" +
                        "18\n" +
                        "19\n" +
                        "20\n" +
                        "21\n" +
                        "22\n" +
                        "23\n" +
                        "24\n" +
                        "25\n" +
                        "26\n" +
                        "27\n" +
                        "28\n" +
                        "29\n" +
                        "30",
                        "2\n" +
                        "8"
                ),
                arguments(
                        "9\n" +
                        "30\n" +
                        "6\n" +
                        "12\n" +
                        "10\n" +
                        "20\n" +
                        "21\n" +
                        "11\n" +
                        "7\n" +
                        "5\n" +
                        "28\n" +
                        "4\n" +
                        "18\n" +
                        "29\n" +
                        "17\n" +
                        "19\n" +
                        "27\n" +
                        "13\n" +
                        "16\n" +
                        "26\n" +
                        "14\n" +
                        "23\n" +
                        "22\n" +
                        "15\n" +
                        "3\n" +
                        "1\n" +
                        "24\n" +
                        "25",
                        "2\n" +
                        "8"
                )
        );
    }
    // spotless:on
}
