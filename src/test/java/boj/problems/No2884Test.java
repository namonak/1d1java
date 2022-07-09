package boj.problems;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No2884Test {
    static class 알람_시계_테스트케이스{
        String given;
        String want;

        public 알람_시계_테스트케이스(String given, String want) {
            this.given = given;
            this.want = want;
        }
    }

    @Test
    @DisplayName("알람 시계 테스트")
    void 알람_시계_테스트() throws IOException {
        System.out.println("알람 시계 : https://www.acmicpc.net/problem/2884");

        알람_시계_테스트케이스[] testCase = {
                new 알람_시계_테스트케이스("10 10", "9 25"),
                new 알람_시계_테스트케이스("0 30", "23 45"),
                new 알람_시계_테스트케이스("23 40", "22 55")
        };

        for (int i = 0; i < testCase.length; i++) {
            BufferedReader br_given = new BufferedReader(new StringReader(testCase[i].given));
            BufferedReader br_want = new BufferedReader(new StringReader(testCase[i].want));
            StringWriter sw = new StringWriter();
            BufferedWriter bw_got = new BufferedWriter(sw);

            No2884.solve(br_given, bw_got);

            bw_got.close();

            BufferedReader br_got = new BufferedReader(new StringReader(sw.getBuffer().toString()));

            String got = br_got.lines().collect(Collectors.joining());
            String want = br_want.lines().collect(Collectors.joining());

            assertEquals(want, got);
        }
    }
}
