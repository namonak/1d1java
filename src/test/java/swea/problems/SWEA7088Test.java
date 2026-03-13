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

class SWEA7088Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("7088. 은기의 송아지 세기 [D4]")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = SWEA7088.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "1\n" +
                        "6 3\n" +
                        "2\n" +
                        "1\n" +
                        "1\n" +
                        "3\n" +
                        "2\n" +
                        "1\n" +
                        "1 6\n" +
                        "3 3\n" +
                        "2 4",
                        "#1\n" +
                        "3 2 1\n" +
                        "1 0 0\n" +
                        "2 0 1"
                )
        );
    }
    // spotless:on
}
