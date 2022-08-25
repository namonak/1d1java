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

public class No2869Test {
    static class 달팽이는_올라가고_싶다_테스트케이스 {
        String given;
        int want;

        public 달팽이는_올라가고_싶다_테스트케이스(String given, int want) {
            this.given = given;
            this.want = want;
        }
    }

    @Test
    @DisplayName("달팽이는 올라가고 싶다 테스트")
    void 달팽이는_올라가고_싶다_테스트() throws IOException {
        System.out.println("달팽이는 올라가고 싶다 : https://www.acmicpc.net/problem/2869");

        달팽이는_올라가고_싶다_테스트케이스[] testCase = {
                new 달팽이는_올라가고_싶다_테스트케이스("2 1 5", 4),
                new 달팽이는_올라가고_싶다_테스트케이스("5 1 6", 2),
                new 달팽이는_올라가고_싶다_테스트케이스("100 99 1000000000", 999999901),
        };

        for (달팽이는_올라가고_싶다_테스트케이스 tc : testCase) {
            BufferedReader br_given = new BufferedReader(new StringReader(tc.given));
            StringWriter sw = new StringWriter();
            BufferedWriter bw_got = new BufferedWriter(sw);

            No2869.solve(br_given, bw_got);

            bw_got.close();

            BufferedReader br_got = new BufferedReader(new StringReader(sw.getBuffer().toString()));

            String got = br_got.lines().collect(Collectors.joining());

            assertEquals(tc.want, Integer.parseInt(got));
        }
    }
}
