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

class No34073Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("DORO : https://www.acmicpc.net/problem/34073")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No34073.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "13\n" +
                        "you can get badge and background if you solve at least one problem",
                        "youDORO canDORO getDORO badgeDORO andDORO backgroundDORO ifDORO youDORO solveDORO atDORO leastDORO oneDORO problemDORO "
                ),
                arguments(
                        "2\n" +
                        "blue archive",
                        "blueDORO archiveDORO "
                ),
                arguments(
                        "3\n" +
                        "i love you",
                        "iDORO loveDORO youDORO "
                )
        );
    }
    // spotless:on
}
