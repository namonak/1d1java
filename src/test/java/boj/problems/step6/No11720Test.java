package boj.problems.step6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No11720Test {
    static class 숫자의_합_테스트케이스{
        String given;
        String want;

        public 숫자의_합_테스트케이스(String given, String want) {
            this.given = given;
            this.want = want;
        }
    }

    @Test
    @DisplayName("숫자의 합 테스트")
    void 숫자의_합_테스트() throws IOException {
        System.out.println("숫자의 합 : https://www.acmicpc.net/problem/11720");

        숫자의_합_테스트케이스[] testCase = {
                new 숫자의_합_테스트케이스("1" + System.lineSeparator() + "1" + System.lineSeparator(), "1"),
                new 숫자의_합_테스트케이스("5" + System.lineSeparator() + "54321" + System.lineSeparator(), "15"),
                new 숫자의_합_테스트케이스("25" + System.lineSeparator() + "7000000000000000000000000" + System.lineSeparator(), "7"),
                new 숫자의_합_테스트케이스("11" + System.lineSeparator() + "10987654321" + System.lineSeparator(), "46")
        };

        for (int i = 0; i < testCase.length; i++) {
            BufferedReader br_given = new BufferedReader(new StringReader(testCase[i].given));
            BufferedReader br_want = new BufferedReader(new StringReader(testCase[i].want));
            StringWriter sw = new StringWriter();
            BufferedWriter bw_got = new BufferedWriter(sw);

            No11720.solve(br_given, bw_got);

            bw_got.close();

            BufferedReader br_got = new BufferedReader(new StringReader(sw.getBuffer().toString()));

            String got = br_got.lines().collect(Collectors.joining());
            String want = br_want.lines().collect(Collectors.joining());

            assertEquals(want, got);
        }
    }
}
