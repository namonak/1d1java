package boj.problems.step9;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No10872Test {
    static class 팩토리얼_테스트케이스 {
        int given;
        int want;

        public 팩토리얼_테스트케이스(int given, int want) {
            this.given = given;
            this.want = want;
        }
    }

    @Test
    @DisplayName("팩토리얼 테스트")
    void 팩토리얼_테스트() throws IOException {
        System.out.println("팩토리얼 : https://www.acmicpc.net/problem/10872");

        팩토리얼_테스트케이스[] testCase = {
                new 팩토리얼_테스트케이스(10, 3628800),
                new 팩토리얼_테스트케이스(0, 1)
        };

        for (팩토리얼_테스트케이스 tc : testCase) {
            BufferedReader br_given = new BufferedReader(new StringReader(String.valueOf(tc.given)));
            StringWriter sw = new StringWriter();
            BufferedWriter bw_got = new BufferedWriter(sw);

            No10872.solve(br_given, bw_got);

            bw_got.close();

            BufferedReader br_got = new BufferedReader(new StringReader(sw.getBuffer().toString()));

            String got = br_got.lines().collect(Collectors.joining());

            assertEquals(tc.want, Integer.parseInt(got));
        }
    }
}
