package boj.problems.step12;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No11478Test {
    static class 서로_다른_부분_문자열의_개수_테스트케이스{
        String given;
        int want;

        public 서로_다른_부분_문자열의_개수_테스트케이스(String given, int want) {
            this.given = given;
            this.want = want;
        }
    }

    @Test
    @DisplayName("서로 다른 부분 문자열의 개수 테스트")
    void 서로_다른_부분_문자열의_개수_테스트() throws IOException {
        System.out.println("서로 다른 부분 문자열의 개수 : https://www.acmicpc.net/problem/11478");

        서로_다른_부분_문자열의_개수_테스트케이스[] testCase = {
                new 서로_다른_부분_문자열의_개수_테스트케이스("ababc", 12)
        };

        for (int i = 0; i < testCase.length; i++) {
            BufferedReader br_given = new BufferedReader(new StringReader(testCase[i].given));
            StringWriter sw = new StringWriter();
            BufferedWriter bw_got = new BufferedWriter(sw);

            //No11478.solve(br_given, bw_got);

            bw_got.close();

            BufferedReader br_got = new BufferedReader(new StringReader(sw.getBuffer().toString()));

            String got = br_got.lines().collect(Collectors.joining());

            assertEquals(testCase[i].want, Integer.parseInt(got));
        }
    }
}
