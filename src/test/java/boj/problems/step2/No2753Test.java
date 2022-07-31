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

public class No2753Test {
    static class 윤년_테스트케이스 {
        int given;
        int want;

        public 윤년_테스트케이스(int given, int want) {
            this.given = given;
            this.want = want;
        }
    }


    @Test
    @DisplayName("윤년 테스트")
    void 윤년_테스트() throws IOException {
        System.out.println("윤년 : https://www.acmicpc.net/problem/2753");

        윤년_테스트케이스[] testCase = {
                new 윤년_테스트케이스(2000, 1),
                new 윤년_테스트케이스(1999, 0),
                new 윤년_테스트케이스(1900, 0)
        };

        for (윤년_테스트케이스 tc : testCase) {
            BufferedReader br_given = new BufferedReader(new StringReader(String.valueOf(tc.given)));
            StringWriter sw = new StringWriter();
            BufferedWriter bw_got = new BufferedWriter(sw);

            No2753.solve(br_given, bw_got);

            bw_got.close();

            BufferedReader br_got = new BufferedReader(new StringReader(sw.getBuffer().toString()));

            String got = br_got.lines().collect(Collectors.joining());

            assertEquals(tc.want, Integer.parseInt(got));
        }
    }
}
