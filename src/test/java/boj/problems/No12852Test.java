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

class No12852Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("1로 만들기 2 : https://www.acmicpc.net/problem/12852")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No12852.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "2",
                        "1\n" +
                        "2 1 "
                ),
                arguments(
                        "10",
                        "3\n" +
                        "10 9 3 1 "
                )
        );
    }
    // spotless:on
}
