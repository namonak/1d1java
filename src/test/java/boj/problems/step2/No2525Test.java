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

public class No2525Test {
    static class 오븐_시계_테스트케이스{
        String given;
        String want;

        public 오븐_시계_테스트케이스(String given, String want) {
            this.given = given;
            this.want = want;
        }
    }

    @Test
    @DisplayName("오븐 시계 테스트")
    void 오븐_시계_테스트() throws IOException {
        System.out.println("오븐 시계 : https://www.acmicpc.net/problem/2525");

        오븐_시계_테스트케이스[] testCase = {
                new 오븐_시계_테스트케이스("14 30" + System.lineSeparator() + "20", "14 50"),
                new 오븐_시계_테스트케이스("17 40" + System.lineSeparator() + "80", "19 0"),
                new 오븐_시계_테스트케이스("23 48" + System.lineSeparator() + "25", "0 13"),
        };

        for (int i = 0; i < testCase.length; i++) {
            BufferedReader br_given = new BufferedReader(new StringReader(testCase[i].given));
            BufferedReader br_want = new BufferedReader(new StringReader(testCase[i].want));
            StringWriter sw = new StringWriter();
            BufferedWriter bw_got = new BufferedWriter(sw);

            No2525.solve(br_given, bw_got);

            bw_got.close();

            BufferedReader br_got = new BufferedReader(new StringReader(sw.getBuffer().toString()));

            String got = br_got.lines().collect(Collectors.joining());
            String want = br_want.lines().collect(Collectors.joining());

            assertEquals(want, got);
        }
    }
}
