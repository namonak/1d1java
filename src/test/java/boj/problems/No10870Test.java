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

public class No10870Test {
    static class 피보나치_수_5_테스트케이스 {
        int given;
        int want;

        public 피보나치_수_5_테스트케이스(int given, int want) {
            this.given = given;
            this.want = want;
        }
    }


    @Test
    @DisplayName("피보나치 수 5 테스트")
    void 피보나치_수_5_테스트() throws IOException {
        System.out.println("피보나치 수 5 : https://www.acmicpc.net/problem/10870");

        피보나치_수_5_테스트케이스[] testCase = {
                new 피보나치_수_5_테스트케이스(10, 55),
        };

        for (피보나치_수_5_테스트케이스 tc : testCase) {
            BufferedReader br_given = new BufferedReader(new StringReader(String.valueOf(tc.given)));
            StringWriter sw = new StringWriter();
            BufferedWriter bw_got = new BufferedWriter(sw);

            No10870.solve(br_given, bw_got);

            bw_got.close();

            BufferedReader br_got = new BufferedReader(new StringReader(sw.getBuffer().toString()));

            String got = br_got.lines().collect(Collectors.joining());

            assertEquals(tc.want, Integer.parseInt(got));
        }
    }
}
