package boj.problems.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No1546Test {
    static class 평균_테스트케이스{
        String given;
        float want;

        public 평균_테스트케이스(String given, float want) {
            this.given = given;
            this.want = want;
        }
    }

    @Test
    @DisplayName("평균 테스트")
    void 평균_테스트() throws IOException {
        System.out.println("평균 : https://www.acmicpc.net/problem/1546");

        평균_테스트케이스[] testCase = {
                new 평균_테스트케이스("3" + System.lineSeparator() + "40 80 60", (float)75.0),
                new 평균_테스트케이스("3" + System.lineSeparator() + "10 20 30", (float)66.666667),
                new 평균_테스트케이스("4" + System.lineSeparator() + "1 100 100 100", (float)75.25),
                new 평균_테스트케이스("5" + System.lineSeparator() + "1 2 4 8 16", (float)38.75),
                new 평균_테스트케이스("2" + System.lineSeparator() + "3 10", (float)65.0),
                new 평균_테스트케이스("4" + System.lineSeparator() + "10 20 0 100", (float)32.5),
                new 평균_테스트케이스("1" + System.lineSeparator() + "50", (float)100.0),
                new 평균_테스트케이스("9" + System.lineSeparator() + "10 20 30 40 50 60 70 80 90", (float)55.55555555555556)
        };

        for (int i = 0; i < testCase.length; i++) {
            BufferedReader br_given = new BufferedReader(new StringReader(testCase[i].given));
            BufferedReader br_want = new BufferedReader(new StringReader(testCase[i].want + "\n"));
            StringWriter sw = new StringWriter();
            BufferedWriter bw_got = new BufferedWriter(sw);

            No1546.solve(br_given, bw_got);

            bw_got.close();

            BufferedReader br_got = new BufferedReader(new StringReader(sw.getBuffer().toString()));

            String got = br_got.lines().collect(Collectors.joining());
            String want = br_want.lines().collect(Collectors.joining());

            assertEquals(want, got);
        }
    }
}
