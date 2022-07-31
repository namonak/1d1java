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

public class No14681Test {
    static class 사분면_고르기_테스트케이스{
        String given;
        String want;

        public 사분면_고르기_테스트케이스(String given, String want) {
            this.given = given;
            this.want = want;
        }
    }

    @Test
    @DisplayName("사분면 고르기 테스트")
    void 사분면_고르기_테스트() throws IOException {
        System.out.println("사분면 고르기 : https://www.acmicpc.net/problem/14681");

        사분면_고르기_테스트케이스[] testCase = {
                new 사분면_고르기_테스트케이스("12" + System.lineSeparator() + "5" + System.lineSeparator(), "1"),
                new 사분면_고르기_테스트케이스("9" + System.lineSeparator() + "-13" + System.lineSeparator(), "4")
        };

        for (int i = 0; i < testCase.length; i++) {
            BufferedReader br_given = new BufferedReader(new StringReader(testCase[i].given));
            BufferedReader br_want = new BufferedReader(new StringReader(testCase[i].want));
            StringWriter sw = new StringWriter();
            BufferedWriter bw_got = new BufferedWriter(sw);

            No14681.solve(br_given, bw_got);

            bw_got.close();

            BufferedReader br_got = new BufferedReader(new StringReader(sw.getBuffer().toString()));

            String got = br_got.lines().collect(Collectors.joining());
            String want = br_want.lines().collect(Collectors.joining());

            assertEquals(want, got);
        }
    }
}
