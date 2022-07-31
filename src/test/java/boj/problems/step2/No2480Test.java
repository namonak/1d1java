package boj.problems.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No2480Test {
    static class 주사위_세개_테스트케이스{
        String given;
        String want;

        public 주사위_세개_테스트케이스(String given, String want) {
            this.given = given;
            this.want = want;
        }
    }

    @Test
    @DisplayName("주사위 세개 테스트")
    void 주사위_세개_테스트() throws IOException {
        System.out.println("주사위 세게 : https://www.acmicpc.net/problem/2480");

        주사위_세개_테스트케이스[] testCase = {
                new 주사위_세개_테스트케이스("3 3 6", "1300"),
                new 주사위_세개_테스트케이스("2 2 2", "12000"),
                new 주사위_세개_테스트케이스("6 2 5", "600"),
        };

        for (int i = 0; i < testCase.length; i++) {
            BufferedReader br_given = new BufferedReader(new StringReader(testCase[i].given));
            BufferedReader br_want = new BufferedReader(new StringReader(testCase[i].want));
            StringWriter sw = new StringWriter();
            BufferedWriter bw_got = new BufferedWriter(sw);

            No2480.solve(br_given, bw_got);

            bw_got.close();

            BufferedReader br_got = new BufferedReader(new StringReader(sw.getBuffer().toString()));

            String got = br_got.lines().collect(Collectors.joining());
            String want = br_want.lines().collect(Collectors.joining());

            assertEquals(want, got);
        }
    }
}
