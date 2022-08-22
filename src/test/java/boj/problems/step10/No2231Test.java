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

public class No2231Test {
    static class 분해합_테스트케이스{
        int given;
        int want;

        public 분해합_테스트케이스(int given, int want) {
            this.given = given;
            this.want = want;
        }
    }

    @Test
    @DisplayName("분해합 테스트")
    void 분해합_테스트() throws IOException {
        System.out.println("분해합 : https://www.acmicpc.net/problem/2231");

        분해합_테스트케이스[] testCase = {
                new 분해합_테스트케이스(216, 198)
        };

        for (분해합_테스트케이스 tc : testCase) {
            BufferedReader br_given = new BufferedReader(new StringReader(String.valueOf(tc.given)));
            BufferedReader br_want = new BufferedReader(new StringReader(String.valueOf(tc.want)));
            StringWriter sw = new StringWriter();
            BufferedWriter bw_got = new BufferedWriter(sw);

            No2231.solve(br_given, bw_got);

            bw_got.close();

            BufferedReader br_got = new BufferedReader(new StringReader(sw.getBuffer().toString()));

            String got = br_got.lines().collect(Collectors.joining());
            String want = br_want.lines().collect(Collectors.joining());

            assertEquals(want, got);
        }
    }
}
