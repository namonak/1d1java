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

public class No10757Test {
    static class 큰_수_A_더하기_B_테스트케이스 {
        String given;
        String want;

        public 큰_수_A_더하기_B_테스트케이스(String given, String want) {
            this.given = given;
            this.want = want;
        }
    }

    @Test
    @DisplayName("큰 수 A+B 테스트")
    void 큰_수_A_더하기_B_테스트() throws IOException {
        System.out.println("큰 수 A+B : https://www.acmicpc.net/problem/10757");

        큰_수_A_더하기_B_테스트케이스[] testCase = {
                new 큰_수_A_더하기_B_테스트케이스("9223372036854775807 9223372036854775808", "18446744073709551615"),
        };

        for (큰_수_A_더하기_B_테스트케이스 tc : testCase) {
            BufferedReader br_given = new BufferedReader(new StringReader(tc.given));
            StringWriter sw = new StringWriter();
            BufferedWriter bw_got = new BufferedWriter(sw);

            No10757.solve(br_given, bw_got);

            bw_got.close();

            BufferedReader br_got = new BufferedReader(new StringReader(sw.getBuffer().toString()));

            String got = br_got.lines().collect(Collectors.joining());

            assertEquals(tc.want, Integer.parseInt(got));
        }
    }
}
