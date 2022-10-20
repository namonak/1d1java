package boj.problems.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.assertj.core.api.Assertions.assertThat;

public class No1008Test {
    @Test
    @DisplayName("A/B 테스트")
    void test() throws IOException {
        System.out.println("A/B : https://www.acmicpc.net/problem/1008");

        BufferedReader given = new BufferedReader(new StringReader("1 3"));

        assertThat(No1008.solve(given)).isEqualTo((double)1/3);

        given.close();
    }
}
