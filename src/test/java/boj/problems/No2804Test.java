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

class No2804Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("크로스워드 만들기 : https://www.acmicpc.net/problem/2804")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No2804.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "BANANA PIDZAMA",
                        ".P....\n" +
                        ".I....\n" +
                        ".D....\n" +
                        ".Z....\n" +
                        "BANANA\n" +
                        ".M....\n" +
                        ".A...."
                ),
                arguments(
                        "MAMA TATA",
                        ".T..\n" +
                        "MAMA\n" +
                        ".T..\n" +
                        ".A.."
                ),
                arguments(
                        "REPUBLIKA HRVATSKA",
                        "H........\n" +
                        "REPUBLIKA\n" +
                        "V........\n" +
                        "A........\n" +
                        "T........\n" +
                        "S........\n" +
                        "K........\n" +
                        "A........"
                )
        );
    }
    // spotless:on
}
