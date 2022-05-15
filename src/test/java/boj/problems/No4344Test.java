package boj.problems;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class No4344Test {
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
            assertThat(NO4344.getAverage(testCase.input)).isEqualTo(testCase.expected);
        }
    }
}
