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

class No11021Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("A+B - 7 : https://www.acmicpc.net/problem/11021")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No11021.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "5\n" +
                        "1 1\n" +
                        "2 3\n" +
                        "3 4\n" +
                        "9 8\n" +
                        "5 2",
                        "Case #1: 2\n" +
                        "Case #2: 5\n" +
                        "Case #3: 7\n" +
                        "Case #4: 17\n" +
                        "Case #5: 7"
                )
        );
    }
    // spotless:on
}
