package boj.problems.step3;

import boj.problems.step3.No8393;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No8393Test {
    static class 합_테스트케이스 {
        int given;
        int want;

        public 합_테스트케이스(int given, int want) {
            this.given = given;
            this.want = want;
        }
    }

    @Test
    @DisplayName("합 테스트")
    void 합_테스트() throws IOException {
        System.out.println("합 : https://www.acmicpc.net/problem/8393");

        합_테스트케이스[] testCase = {
                new 합_테스트케이스(3, 6)
        };

        for (합_테스트케이스 tc : testCase) {
            BufferedReader br_given = new BufferedReader(new StringReader(String.valueOf(tc.given)));
            StringWriter sw = new StringWriter();
            BufferedWriter bw_got = new BufferedWriter(sw);

            No8393.solve(br_given, bw_got);

            bw_got.close();

            BufferedReader br_got = new BufferedReader(new StringReader(sw.getBuffer().toString()));

            String got = br_got.lines().collect(Collectors.joining());

            assertEquals(tc.want, Integer.parseInt(got));
        }
    }
}
