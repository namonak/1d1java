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

public class No1712Test {
    static class 손익분기점_테스트케이스{
        String given;
        String want;

        public 손익분기점_테스트케이스(String given, String want) {
            this.given = given;
            this.want = want;
        }
    }

    @Test
    @DisplayName("손익분기점 테스트")
    void 손익분기점_테스트() throws IOException {
        System.out.println("손익분기점 : https://www.acmicpc.net/problem/1712");

        손익분기점_테스트케이스[] testCase = {
                new 손익분기점_테스트케이스("1000 70 170", "11"),
                new 손익분기점_테스트케이스("3 2 1", "-1"),
                new 손익분기점_테스트케이스("2100000000 9 10", "2100000001"),
        };

        for (int i = 0; i < testCase.length; i++) {
            BufferedReader br_given = new BufferedReader(new StringReader(testCase[i].given));
            BufferedReader br_want = new BufferedReader(new StringReader(testCase[i].want));
            StringWriter sw = new StringWriter();
            BufferedWriter bw_got = new BufferedWriter(sw);

            No1712.solve(br_given, bw_got);

            bw_got.close();

            BufferedReader br_got = new BufferedReader(new StringReader(sw.getBuffer().toString()));

            String got = br_got.lines().collect(Collectors.joining());
            String want = br_want.lines().collect(Collectors.joining());

            assertEquals(want, got);
        }
    }
}
