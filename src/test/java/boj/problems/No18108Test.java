package boj.problems;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No18108Test {
    static class No18108_테스트케이스 {
        int given;
        int want;

        public No18108_테스트케이스(int given, int want) {
            this.given = given;
            this.want = want;
        }
    }

    @Test
    @DisplayName("1998년생인 내가 태국에서는 2541년생?! 테스트")
    void No18108_테스트() throws IOException {
        System.out.println("1998년생인 내가 태국에서는 2541년생?! : https://www.acmicpc.net/problem/18108");

        No18108_테스트케이스[] testCase = {
                new No18108_테스트케이스(2541, 1998)
        };

        for (No18108_테스트케이스 tc : testCase) {
            BufferedReader br_given = new BufferedReader(new StringReader(String.valueOf(tc.given)));
            StringWriter sw = new StringWriter();
            BufferedWriter bw_got = new BufferedWriter(sw);

            No18108.solve(br_given, bw_got);

            bw_got.close();

            BufferedReader br_got = new BufferedReader(new StringReader(sw.getBuffer().toString()));

            String got = br_got.lines().collect(Collectors.joining());

            assertEquals(tc.want, Integer.parseInt(got));
        }
    }
}
