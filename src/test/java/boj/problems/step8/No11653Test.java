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

public class No11653Test {
    static class 소인수분해_테스트케이스{
        int given;
        String want;

        public 소인수분해_테스트케이스(int given, String want) {
            this.given = given;
            this.want = want;
        }
    }

    @Test
    @DisplayName("소인수분해 테스트")
    void 소인수분해_테스트() throws IOException {
        System.out.println("소인수분해 : https://www.acmicpc.net/problem/11653");

        소인수분해_테스트케이스[] testCase = {
                new 소인수분해_테스트케이스(72,
                        "2" + System.lineSeparator() + "2" + System.lineSeparator() + "2" + System.lineSeparator() + "3"  + System.lineSeparator() + "3"),
                new 소인수분해_테스트케이스(3,
                        "3" + System.lineSeparator()),
                new 소인수분해_테스트케이스(6,
                        "2" + System.lineSeparator() + "3"),
                new 소인수분해_테스트케이스(2,
                        "2" + System.lineSeparator()),
                new 소인수분해_테스트케이스(9991,
                        "97" + System.lineSeparator() + "103"  + System.lineSeparator()),
        };

        for (소인수분해_테스트케이스 tc : testCase) {
            BufferedReader br_given = new BufferedReader(new StringReader(String.valueOf(tc.given)));
            BufferedReader br_want = new BufferedReader(new StringReader(tc.want));
            StringWriter sw = new StringWriter();
            BufferedWriter bw_got = new BufferedWriter(sw);

            No11653.solve(br_given, bw_got);

            bw_got.close();

            BufferedReader br_got = new BufferedReader(new StringReader(sw.getBuffer().toString()));

            String got = br_got.lines().collect(Collectors.joining());
            String want = br_want.lines().collect(Collectors.joining());

            assertEquals(want, got);
        }
    }
}
