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

class No3190Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("뱀 : https://www.acmicpc.net/problem/3190")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = String.valueOf(No3190.solve(reader));
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        String.join(
                                "\n", "6", "3", "3 4", "2 5", "5 3", "3", "3 D", "15 L", "17 D"),
                        "9"),
                arguments(
                        String.join(
                                "\n", "10", "4", "1 2", "1 3", "1 4", "1 5", "4", "8 D", "10 D",
                                "11 D", "13 L"),
                        "21"),
                arguments(
                        String.join(
                                "\n", "10", "5", "1 5", "1 3", "1 2", "1 6", "1 7", "4", "8 D",
                                "10 D", "11 D", "13 L"),
                        "13"));
    }
}
