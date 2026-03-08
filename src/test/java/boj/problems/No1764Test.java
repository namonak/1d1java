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

class No1764Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("듣보잡 : https://www.acmicpc.net/problem/1764")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No1764.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "3 4\n" +
                        "ohhenrie\n" +
                        "charlie\n" +
                        "baesangwook\n" +
                        "obama\n" +
                        "baesangwook\n" +
                        "ohhenrie\n" +
                        "clinton",
                        "2\n" +
                        "baesangwook\n" +
                        "ohhenrie"
                )
        );
    }
    // spotless:on
}
