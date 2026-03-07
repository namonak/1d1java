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

class No16236Test {	
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("아기 상어 : https://www.acmicpc.net/problem/16236")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = String.valueOf(No16236.solve(reader));
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(String.join("\n", "3", "0 0 0", "0 0 0", "0 9 0"), "0"),
                arguments(String.join("\n", "3", "0 0 1", "0 0 0", "0 9 0"), "3"),
                arguments(String.join("\n", "4", "4 3 2 1", "0 0 0 0", "0 0 9 0", "1 2 3 4"), "14"),
                arguments(
                        String.join(
                                "\n",
                                "6",
                                "5 4 3 2 3 4",
                                "4 3 2 3 4 5",
                                "3 2 9 5 6 6",
                                "2 1 2 3 4 5",
                                "3 2 1 6 5 4",
                                "6 6 6 6 6 6"),
                        "60"),
                arguments(
                        String.join(
                                "\n",
                                "6",
                                "6 0 6 0 6 1",
                                "0 0 0 0 0 2",
                                "2 3 4 5 6 6",
                                "0 0 0 0 0 2",
                                "0 2 0 0 0 0",
                                "3 9 3 0 0 1"),
                        "48"),
                arguments(
                        String.join(
                                "\n",
                                "6",
                                "1 1 1 1 1 1",
                                "2 2 6 2 2 3",
                                "2 2 5 2 2 3",
                                "2 2 2 4 6 3",
                                "0 0 0 0 0 6",
                                "0 0 0 0 0 9"),
                        "39"));
    }
}
