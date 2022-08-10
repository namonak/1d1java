package boj.problems.step7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No2292Test {
    static class 벌집_테스트케이스 {
        int given;
        int want;

        public 벌집_테스트케이스(int given, int want) {
            this.given = given;
            this.want = want;
        }
    }

    @Test
    @DisplayName("벌집 테스트")
    void 벌집_테스트() throws IOException {
        System.out.println("벌집 : https://www.acmicpc.net/problem/2292");

        벌집_테스트케이스[] testCase = {
                new 벌집_테스트케이스(13, 3),
                new 벌집_테스트케이스(1, 1),
                new 벌집_테스트케이스(2, 2),
                new 벌집_테스트케이스(7, 2),
                new 벌집_테스트케이스(5, 2),
                new 벌집_테스트케이스(37, 4),
                new 벌집_테스트케이스(38, 5),
                new 벌집_테스트케이스(64, 6)
        };

        for (벌집_테스트케이스 tc : testCase) {
            BufferedReader br_given = new BufferedReader(new StringReader(String.valueOf(tc.given)));
            StringWriter sw = new StringWriter();
            BufferedWriter bw_got = new BufferedWriter(sw);

            No2292.solve(br_given, bw_got);

            bw_got.close();

            BufferedReader br_got = new BufferedReader(new StringReader(sw.getBuffer().toString()));

            String got = br_got.lines().collect(Collectors.joining());

            assertEquals(tc.want, Integer.parseInt(got));
        }
    }
}
