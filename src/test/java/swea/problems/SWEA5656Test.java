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

class SWEA5656Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("5656. [모의 SW 역량테스트] 벽돌 깨기")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = SWEA5656.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "5\n" +
                        "3 10 10\n" +
                        "0 0 0 0 0 0 0 0 0 0\n" +
                        "1 0 1 0 1 0 0 0 0 0\n" +
                        "1 0 3 0 1 1 0 0 0 1\n" +
                        "1 1 1 0 1 2 0 0 0 9\n" +
                        "1 1 4 0 1 1 0 0 1 1\n" +
                        "1 1 4 1 1 1 2 1 1 1\n" +
                        "1 1 5 1 1 1 1 2 1 1\n" +
                        "1 1 6 1 1 1 1 1 2 1\n" +
                        "1 1 1 1 1 1 1 1 1 5\n" +
                        "1 1 7 1 1 1 1 1 1 1\n" +
                        "2 9 10\n" +
                        "0 0 0 0 0 0 0 0 0\n" +
                        "0 0 0 0 0 0 0 0 0\n" +
                        "0 1 0 0 0 0 0 0 0\n" +
                        "0 1 0 0 0 0 0 0 0\n" +
                        "1 1 0 0 1 0 0 0 0\n" +
                        "1 1 0 1 1 1 0 1 0\n" +
                        "1 1 0 1 1 1 0 1 0\n" +
                        "1 1 1 1 1 1 1 1 0\n" +
                        "1 1 3 1 6 1 1 1 1\n" +
                        "1 1 1 1 1 1 1 1 1\n" +
                        "3 6 7\n" +
                        "1 1 0 0 0 0\n" +
                        "1 1 0 0 1 0\n" +
                        "1 1 0 0 4 0\n" +
                        "4 1 0 0 1 0\n" +
                        "1 5 1 0 1 6\n" +
                        "1 2 8 1 1 6\n" +
                        "1 1 1 9 2 1\n" +
                        "4 4 15\n" +
                        "0 0 0 0 \n" +
                        "0 0 0 0 \n" +
                        "0 0 0 0 \n" +
                        "1 0 0 0 \n" +
                        "1 0 0 0 \n" +
                        "1 0 0 0 \n" +
                        "1 0 0 0 \n" +
                        "1 0 5 0 \n" +
                        "1 1 1 0 \n" +
                        "1 1 1 9 \n" +
                        "1 1 1 1 \n" +
                        "1 6 1 2 \n" +
                        "1 1 1 5 \n" +
                        "1 1 1 1 \n" +
                        "2 1 1 2 \n" +
                        "4 12 15\n" +
                        "9 9 9 9 9 9 9 9 9 9 9 9\n" +
                        "9 9 9 9 9 9 9 9 9 9 9 9\n" +
                        "9 9 9 9 9 9 9 9 9 9 9 9\n" +
                        "9 9 9 9 9 9 9 9 9 9 9 9\n" +
                        "9 9 9 9 9 9 9 9 9 9 9 9\n" +
                        "9 9 9 9 9 9 9 9 9 9 9 9\n" +
                        "9 9 9 9 9 9 9 9 9 9 9 9\n" +
                        "9 9 9 9 9 9 9 9 9 9 9 9\n" +
                        "9 9 9 9 9 9 9 9 9 9 9 9\n" +
                        "9 9 9 9 9 9 9 9 9 9 9 9\n" +
                        "9 9 9 9 9 9 9 9 9 9 9 9\n" +
                        "9 9 9 9 9 9 9 9 9 9 9 9\n" +
                        "9 9 9 9 9 9 9 9 9 9 9 9\n" +
                        "9 9 9 9 9 9 9 9 9 9 9 9\n" +
                        "9 9 9 9 9 9 9 9 9 9 9 9",
                        "#1 12\n" +
                        "#2 27\n" +
                        "#3 4\n" +
                        "#4 8\n" +
                        "#5 0"
                )
        );
    }
    // spotless:on
}
