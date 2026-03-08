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

class No1620Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("나는야 포켓몬 마스터 이다솜 : https://www.acmicpc.net/problem/1620")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No1620.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "26 5\n" +
                        "Bulbasaur\n" +
                        "Ivysaur\n" +
                        "Venusaur\n" +
                        "Charmander\n" +
                        "Charmeleon\n" +
                        "Charizard\n" +
                        "Squirtle\n" +
                        "Wartortle\n" +
                        "Blastoise\n" +
                        "Caterpie\n" +
                        "Metapod\n" +
                        "Butterfree\n" +
                        "Weedle\n" +
                        "Kakuna\n" +
                        "Beedrill\n" +
                        "Pidgey\n" +
                        "Pidgeotto\n" +
                        "Pidgeot\n" +
                        "Rattata\n" +
                        "Raticate\n" +
                        "Spearow\n" +
                        "Fearow\n" +
                        "Ekans\n" +
                        "Arbok\n" +
                        "Pikachu\n" +
                        "Raichu\n" +
                        "25\n" +
                        "Raichu\n" +
                        "3\n" +
                        "Pidgey\n" +
                        "Kakuna",
                        "Pikachu\n" +
                        "26\n" +
                        "Venusaur\n" +
                        "16\n" +
                        "14"
                )
        );
    }
    // spotless:on
}
