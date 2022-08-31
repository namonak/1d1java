package boj.problems.step11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No1427Test {
    static class 소트인사이드_테스트케이스{
        int given;
        int want;

        public 소트인사이드_테스트케이스(int given, int want) {
            this.given = given;
            this.want = want;
        }
    }

    @Test
    @DisplayName("소트인사이드 테스트")
    void 소트인사이드_테스트() throws IOException {
        System.out.println("소트인사이드 : https://www.acmicpc.net/problem/1427");

        소트인사이드_테스트케이스[] testCase = {
                new 소트인사이드_테스트케이스(2143, 4321),
                new 소트인사이드_테스트케이스(999998999, 999999998),
                new 소트인사이드_테스트케이스(61423, 64321),
                new 소트인사이드_테스트케이스(500613009, 965310000)
        };

        for (int i = 0; i < testCase.length; i++) {
            BufferedReader br_given = new BufferedReader(new StringReader(String.valueOf(testCase[i].given)));
            BufferedReader br_want = new BufferedReader(new StringReader(String.valueOf(testCase[i].want)));
            StringWriter sw = new StringWriter();
            BufferedWriter bw_got = new BufferedWriter(sw);

            No1427.solve(br_given, bw_got);

            bw_got.close();

            BufferedReader br_got = new BufferedReader(new StringReader(sw.getBuffer().toString()));

            String got = br_got.lines().collect(Collectors.joining());
            String want = br_want.lines().collect(Collectors.joining());

            assertEquals(want, got);
        }
    }
}
