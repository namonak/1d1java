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

class SWEA7465Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("7465. 창용 마을 무리의 개수 [D4]")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = SWEA7465.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "2\n" +
                        "6 5\n" +
                        "1 2\n" +
                        "2 5\n" +
                        "5 1\n" +
                        "3 4\n" +
                        "4 6\n" +
                        "6 8\n" +
                        "1 2\n" +
                        "2 5\n" +
                        "5 1\n" +
                        "3 4\n" +
                        "4 6\n" +
                        "5 4\n" +
                        "2 4\n" +
                        "2 3",
                        "#1 2\n" +
                        "#2 1"
                )
        );
    }
    // spotless:on
}
