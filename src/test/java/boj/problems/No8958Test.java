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

class No8958Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("OX퀴즈 : https://www.acmicpc.net/problem/8958")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No8958.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "5\n" +
                        "OOXXOXXOOO\n" +
                        "OOXXOOXXOO\n" +
                        "OXOXOXOXOXOXOX\n" +
                        "OOOOOOOOOO\n" +
                        "OOOOXOOOOXOOOOX",
                        "10\n" +
                        "9\n" +
                        "7\n" +
                        "55\n" +
                        "30"
                )
        );
    }
    // spotless:on
}
