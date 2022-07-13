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

public class No1152Test {
    static class 단어의_개수_테스트케이스 {
        String given;
        int want;

        public 단어의_개수_테스트케이스(String given, int want) {
            this.given = given;
            this.want = want;
        }
    }

    @Test
    @DisplayName("단어의 개수 테스트")
    void 단어의_개수_테스트() throws IOException {
        System.out.println("단어의 개수 : https://www.acmicpc.net/problem/1152");

        단어의_개수_테스트케이스[] testCase = {
                new 단어의_개수_테스트케이스("The Curious Case of Benjamin Button", 6),
                new 단어의_개수_테스트케이스("The first character is a blank", 6),
                new 단어의_개수_테스트케이스("The last character is a blank", 6)
        };

        for (단어의_개수_테스트케이스 tc : testCase) {
            BufferedReader br_given = new BufferedReader(new StringReader(String.valueOf(tc.given)));
            StringWriter sw = new StringWriter();
            BufferedWriter bw_got = new BufferedWriter(sw);

            No1152.solve(br_given, bw_got);

            bw_got.close();

            BufferedReader br_got = new BufferedReader(new StringReader(sw.getBuffer().toString()));

            String got = br_got.lines().collect(Collectors.joining());

            assertEquals(tc.want, Integer.parseInt(got));
        }
    }
}
