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

public class No9498Test {
    static class 시험_성적_테스트케이스 {
        int given;
        String want;

        public 시험_성적_테스트케이스(int given, String want) {
            this.given = given;
            this.want = want;
        }
    }


    @Test
    @DisplayName("시험 성적 테스트")
    void 시험_성적_테스트() throws IOException {
        System.out.println("시험 성적 : https://www.acmicpc.net/problem/9498");

        시험_성적_테스트케이스[] testCase = {
                new 시험_성적_테스트케이스(100, "A"),
                new 시험_성적_테스트케이스(89, "B"),
                new 시험_성적_테스트케이스(79, "C"),
                new 시험_성적_테스트케이스(69, "D"),
                new 시험_성적_테스트케이스(50, "F")
        };

        for (시험_성적_테스트케이스 tc : testCase) {
            BufferedReader br_given = new BufferedReader(new StringReader(String.valueOf(tc.given)));
            StringWriter sw = new StringWriter();
            BufferedWriter bw_got = new BufferedWriter(sw);

            No9498.solve(br_given, bw_got);

            bw_got.close();

            BufferedReader br_got = new BufferedReader(new StringReader(sw.getBuffer().toString()));

            String got = br_got.lines().collect(Collectors.joining());

            assertEquals(tc.want, got);
        }
    }
}
