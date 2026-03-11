package swea.problems;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SWEA2112Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("2112. [모의 SW 역량테스트] 보호 필름")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = SWEA2112.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "10\n" +
                        "6 8 3\n" +
                        "0 0 1 0 1 0 0 1\n" +
                        "0 1 0 0 0 1 1 1\n" +
                        "0 1 1 1 0 0 0 0\n" +
                        "1 1 1 1 0 0 0 1\n" +
                        "0 1 1 0 1 0 0 1\n" +
                        "1 0 1 0 1 1 0 1\n" +
                        "6 8 3\n" +
                        "1 1 1 1 0 0 1 0\n" +
                        "0 0 1 1 0 1 0 1\n" +
                        "1 1 1 1 0 0 1 0\n" +
                        "1 1 1 0 0 1 1 0\n" +
                        "1 1 0 1 1 1 1 0\n" +
                        "1 1 1 0 0 1 1 0\n" +
                        "6 8 4\n" +
                        "1 1 0 0 0 1 1 0\n" +
                        "1 0 1 0 0 1 1 1\n" +
                        "0 1 0 0 1 1 0 0\n" +
                        "1 0 1 0 0 0 0 0\n" +
                        "1 1 0 0 0 0 0 0\n" +
                        "1 0 0 0 1 1 1 1\n" +
                        "6 4 4\n" +
                        "1 1 0 0\n" +
                        "0 1 0 1\n" +
                        "0 0 0 1\n" +
                        "1 1 1 1\n" +
                        "1 1 0 1\n" +
                        "1 0 1 0\n" +
                        "6 10 3\n" +
                        "0 1 0 0 0 1 0 0 1 1\n" +
                        "0 1 1 0 0 1 0 0 1 0\n" +
                        "0 1 0 0 1 0 1 1 1 1\n" +
                        "0 0 0 0 0 1 1 1 1 0\n" +
                        "0 1 0 0 1 1 1 1 1 1\n" +
                        "1 0 0 0 1 1 0 0 1 1\n" +
                        "6 6 5\n" +
                        "0 0 0 0 0 0\n" +
                        "0 0 0 0 0 0\n" +
                        "0 0 0 0 0 0\n" +
                        "0 0 0 0 0 0\n" +
                        "0 0 0 0 0 0\n" +
                        "0 0 0 0 0 0\n" +
                        "6 6 4\n" +
                        "1 1 1 1 1 1\n" +
                        "0 0 0 0 0 1\n" +
                        "0 1 1 1 0 1\n" +
                        "0 1 0 1 0 1\n" +
                        "0 1 0 0 0 1\n" +
                        "0 1 1 1 1 1\n" +
                        "8 15 3\n" +
                        "0 1 1 0 0 1 1 0 1 1 0 0 0 0 0\n" +
                        "1 0 0 0 1 1 0 0 0 0 0 1 0 1 1\n" +
                        "1 1 0 1 0 1 0 1 0 1 0 1 0 0 0\n" +
                        "0 1 1 1 0 0 1 0 0 0 0 1 0 0 0\n" +
                        "0 0 0 0 0 0 1 0 0 0 1 1 0 0 1\n" +
                        "1 0 1 0 0 1 0 1 1 1 1 0 1 1 1\n" +
                        "0 0 0 0 0 1 1 1 0 0 0 0 0 1 0\n" +
                        "0 0 1 0 1 1 0 1 1 0 0 0 1 0 0\n" +
                        "10 20 4\n" +
                        "1 0 1 1 1 1 1 1 1 1 0 0 1 1 1 0 1 1 0 1\n" +
                        "1 1 0 1 1 1 0 0 1 0 0 0 1 1 1 1 0 0 1 0\n" +
                        "1 1 0 1 1 0 0 0 1 1 1 1 1 0 0 1 1 0 1 0\n" +
                        "0 0 0 1 1 0 0 0 0 1 0 0 1 0 1 1 1 0 1 0\n" +
                        "0 1 1 0 1 0 1 0 1 0 0 1 0 0 0 0 1 1 1 1\n" +
                        "1 0 1 0 1 0 1 1 0 0 0 0 1 1 1 0 0 0 0 0\n" +
                        "0 1 0 0 1 1 0 0 0 0 0 1 1 0 0 1 1 0 1 1\n" +
                        "1 0 0 0 0 1 0 1 1 0 1 1 0 1 0 0 1 1 1 0\n" +
                        "0 1 1 0 0 1 0 1 0 0 0 0 0 0 0 1 1 1 0 1\n" +
                        "0 0 0 0 0 0 1 1 0 0 1 1 0 0 0 0 0 0 1 0\n" +
                        "13 20 5\n" +
                        "1 1 0 1 0 0 0 1 1 1 1 0 0 0 1 1 1 0 0 0\n" +
                        "1 1 1 1 0 1 0 1 0 0 0 0 1 0 0 0 0 1 0 0\n" +
                        "1 0 1 0 1 1 0 1 0 1 1 0 0 0 0 1 1 0 1 0\n" +
                        "0 0 1 1 0 1 1 0 1 0 0 1 1 0 0 0 1 1 1 1\n" +
                        "0 0 1 0 0 1 0 0 1 0 0 0 0 1 0 0 0 0 1 1\n" +
                        "0 0 1 0 0 0 0 0 0 0 0 0 1 1 1 0 0 1 0 1\n" +
                        "0 0 0 1 0 0 0 0 0 0 1 1 0 0 0 1 0 0 1 0\n" +
                        "1 1 1 0 0 0 1 0 0 1 1 1 0 1 0 1 0 0 1 1\n" +
                        "0 1 1 1 1 0 0 0 1 1 0 1 0 0 0 0 1 0 0 1\n" +
                        "0 0 0 0 1 0 1 0 0 0 1 0 0 0 0 1 1 1 1 1\n" +
                        "0 1 0 0 1 1 0 0 1 0 0 0 0 1 0 1 0 0 1 0\n" +
                        "0 0 1 1 0 0 1 0 0 0 1 0 1 1 0 1 1 1 0 0\n" +
                        "0 0 0 1 0 0 1 0 0 0 1 0 1 1 0 0 1 0 1 0",
                        "#1 2\n" +
                        "#2 0\n" +
                        "#3 4\n" +
                        "#4 2\n" +
                        "#5 2\n" +
                        "#6 0\n" +
                        "#7 3\n" +
                        "#8 2\n" +
                        "#9 3\n" +
                        "#10 4"
                )
        );
    }
    // spotless:on
}
