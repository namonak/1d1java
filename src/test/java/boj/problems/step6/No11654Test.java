package boj.problems.step6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No11654Test {
    static class 아스키_코드_테스트케이스 {
        String given;
        int want;

        public 아스키_코드_테스트케이스(String given, int want) {
            this.given = given;
            this.want = want;
        }
    }

    @Test
    @DisplayName("아스키 코드 테스트")
    void No11654_테스트() throws IOException {
        System.out.println("아스키 코드 : https://www.acmicpc.net/problem/11654");

        아스키_코드_테스트케이스[] testCase = {
                new 아스키_코드_테스트케이스("A", 65),
                new 아스키_코드_테스트케이스("C", 67),
                new 아스키_코드_테스트케이스("0", 48),
                new 아스키_코드_테스트케이스("9", 57),
                new 아스키_코드_테스트케이스("a", 97),
                new 아스키_코드_테스트케이스("z", 122),
        };

        for (아스키_코드_테스트케이스 tc : testCase) {
            BufferedReader br_given = new BufferedReader(new StringReader(tc.given));
            StringWriter sw = new StringWriter();
            BufferedWriter bw_got = new BufferedWriter(sw);

            No11654.solve(br_given, bw_got);

            bw_got.close();

            BufferedReader br_got = new BufferedReader(new StringReader(sw.getBuffer().toString()));

            String got = br_got.lines().collect(Collectors.joining());

            assertEquals(tc.want, Integer.parseInt(got));
        }
    }
}
