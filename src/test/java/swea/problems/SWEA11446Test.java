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

class SWEA11446Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("11446. 사탕 가방 [D4]")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = SWEA11446.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "4\n" +
                        "1 100\n" +
                        "1\n" +
                        "3 3\n" +
                        "5 6 7\n" +
                        "1 9\n" +
                        "100\n" +
                        "4 10\n" +
                        "6894 3441 4999 2771",
                        "#1 0\n" +
                        "#2 5\n" +
                        "#3 11\n" +
                        "#4 1666"
                )
        );
    }
    // spotless:on
}
