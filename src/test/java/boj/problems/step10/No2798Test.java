package boj.problems.step10;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No2798Test {
    static class 블랙잭_테스트케이스{
        String given;
        String want;

        public 블랙잭_테스트케이스(String given, String want) {
            this.given = given;
            this.want = want;
        }
    }

    @Test
    @DisplayName("블랙잭 테스트")
    void 블랙잭_테스트() throws IOException {
        System.out.println("블랙잭 : https://www.acmicpc.net/problem/2798");

        블랙잭_테스트케이스[] testCase = {
                new 블랙잭_테스트케이스("5 21" + System.lineSeparator() + "5 6 7 8 9", "21"),
                new 블랙잭_테스트케이스("10 500" + System.lineSeparator() + "93 181 245 214 315 36 185 138 216 295", "497")
        };

        for (No2798Test.블랙잭_테스트케이스 블랙잭_테스트케이스 : testCase) {
            BufferedReader br_given = new BufferedReader(new StringReader(블랙잭_테스트케이스.given));
            BufferedReader br_want = new BufferedReader(new StringReader(블랙잭_테스트케이스.want));
            StringWriter sw = new StringWriter();
            BufferedWriter bw_got = new BufferedWriter(sw);

            No2798.solve(br_given, bw_got);

            bw_got.close();

            BufferedReader br_got = new BufferedReader(new StringReader(sw.getBuffer().toString()));

            String got = br_got.lines().collect(Collectors.joining());
            String want = br_want.lines().collect(Collectors.joining());

            assertEquals(want, got);
        }
    }
}
