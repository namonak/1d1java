package boj.problems.step8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No1929Test {
    static class 소수_구하기_테스트케이스{
        String given;
        String want;

        public 소수_구하기_테스트케이스(String given, String want) {
            this.given = given;
            this.want = want;
        }
    }

    @Test
    @DisplayName("소수 구하기 테스트")
    void 소수_구하기_() throws IOException {
        System.out.println("소수 구하기 : https://www.acmicpc.net/problem/1929");

        소수_구하기_테스트케이스[] testCase = {
                new 소수_구하기_테스트케이스("3 16",
                        "3" + System.lineSeparator() + "5" + System.lineSeparator() + "7" + System.lineSeparator() + "11" + System.lineSeparator() + "13")
        };

        for (소수_구하기_테스트케이스 소수_구하기_테스트케이스 : testCase) {
            BufferedReader br_given = new BufferedReader(new StringReader(소수_구하기_테스트케이스.given));
            BufferedReader br_want = new BufferedReader(new StringReader(소수_구하기_테스트케이스.want));
            StringWriter sw = new StringWriter();
            BufferedWriter bw_got = new BufferedWriter(sw);

            No1929.solve(br_given, bw_got);

            bw_got.close();

            BufferedReader br_got = new BufferedReader(new StringReader(sw.getBuffer().toString()));

            String got = br_got.lines().collect(Collectors.joining());
            String want = br_want.lines().collect(Collectors.joining());

            assertEquals(want, got);
        }
    }
}
