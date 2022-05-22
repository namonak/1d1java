package boj.problems;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class No4344Test {
    File path = new File(".");
    String input = path.getAbsolutePath() + "/src/test/java/boj/problems/No4344_input.txt";
    String output = path.getAbsolutePath() + "/src/test/java/boj/problems/No4344_output.txt";

    @Test
    @DisplayName("평균은 넘겠지 테스트")
    void 평균은_넘겠지_테스트() throws IOException {
        BufferedReader br_given = new BufferedReader(new FileReader(input));
        BufferedReader br_want = new BufferedReader(new FileReader(output));
        StringWriter sw = new StringWriter();
        BufferedWriter bw_got = new BufferedWriter(sw);

        No4344.solve(br_given, bw_got);

        bw_got.close();

        BufferedReader br_got = new BufferedReader(new StringReader(sw.getBuffer().toString()));

        String got = br_got.lines().collect(Collectors.joining());
        String want = br_want.lines().collect(Collectors.joining());

        assertEquals(got, want);
    }

    static class 평균_구하기_테스트케이스 {
        int[] input;
        double expected;

        public 평균_구하기_테스트케이스(int[] input) {
            this.input = input;
            this.expected = Arrays.stream(input).average().getAsDouble();
        }
    }

    @Test
    @DisplayName("평균 구하기")
    void 평균_구하기() {
        평균_구하기_테스트케이스[] testCases = {
                new 평균_구하기_테스트케이스(new int[]{50, 50, 70, 80, 100}),
                new 평균_구하기_테스트케이스(new int[]{100, 95, 90, 80, 70, 60, 50}),
                new 평균_구하기_테스트케이스(new int[]{70, 90, 80}),
                new 평균_구하기_테스트케이스(new int[]{70, 90, 81}),
                new 평균_구하기_테스트케이스(new int[]{100, 99, 98, 97, 96, 95, 94, 93, 91}),
        };

        for (평균_구하기_테스트케이스 testCase : testCases) {
            assertThat(No4344.getAverage(testCase.input)).isEqualTo(testCase.expected);
        }
    }
}
