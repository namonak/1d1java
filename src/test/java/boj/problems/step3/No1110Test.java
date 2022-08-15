package boj.problems.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No1110Test {
    static class 더하기_사이클_테스트케이스 {
        int given;
        int want;

        public 더하기_사이클_테스트케이스(int given, int want) {
            this.given = given;
            this.want = want;
        }
    }

    @Test
    @DisplayName("더하기 사이클 테스트")
    void 더하기_사이클_테스트() throws IOException {
        System.out.println("더하기 사이클 : https://www.acmicpc.net/problem/1110");

        더하기_사이클_테스트케이스[] testCase = {
                new 더하기_사이클_테스트케이스(26, 4),
                new 더하기_사이클_테스트케이스(55, 3),
                new 더하기_사이클_테스트케이스(1, 60),
                new 더하기_사이클_테스트케이스(0, 1),
                new 더하기_사이클_테스트케이스(71, 12)
        };

        for (더하기_사이클_테스트케이스 tc : testCase) {
            BufferedReader br_given = new BufferedReader(new StringReader(String.valueOf(tc.given)));
            StringWriter sw = new StringWriter();
            BufferedWriter bw_got = new BufferedWriter(sw);

            No1110.solve(br_given, bw_got);

            bw_got.close();

            BufferedReader br_got = new BufferedReader(new StringReader(sw.getBuffer().toString()));

            String got = br_got.lines().collect(Collectors.joining());

            assertEquals(tc.want, Integer.parseInt(got));
        }
    }
}
