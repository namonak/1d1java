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

public class No1157Test {
    static class 단어_공부_테스트케이스 {
        String given;
        String want;

        public 단어_공부_테스트케이스(String given, String want) {
            this.given = given;
            this.want = want;
        }
    }

    @Test
    @DisplayName("단어 공부 테스트")
    void 단어_공부_테스트() throws IOException {
        System.out.println("단어 공부 : https://www.acmicpc.net/problem/1157");

        단어_공부_테스트케이스[] testCase = {
                new 단어_공부_테스트케이스("Mississipi", "?"),
                new 단어_공부_테스트케이스("zZa", "Z"),
                new 단어_공부_테스트케이스("z", "Z"),
                new 단어_공부_테스트케이스("baaa", "A")
        };

        for (No1157Test.단어_공부_테스트케이스 단어_공부_테스트케이스 : testCase) {
            BufferedReader br_given = new BufferedReader(new StringReader(단어_공부_테스트케이스.given));
            BufferedReader br_want = new BufferedReader(new StringReader(단어_공부_테스트케이스.want));
            StringWriter sw = new StringWriter();
            BufferedWriter bw_got = new BufferedWriter(sw);

            No1157.solve(br_given, bw_got);

            bw_got.close();

            BufferedReader br_got = new BufferedReader(new StringReader(sw.getBuffer().toString()));

            String got = br_got.lines().collect(Collectors.joining());
            String want = br_want.lines().collect(Collectors.joining());

            assertEquals(want, got);
        }
    }
}
