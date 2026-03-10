package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;

public class No3015 {
    private static class Node {
        int height;
        int count;

        Node(int height, int count) {
            this.height = height;
            this.count = count;
        }
    }

    public static String solve(BufferedReader input) throws IOException {

        int n = Integer.parseInt(input.readLine());
        Node[] stack = new Node[n];
        int top = -1;

        long answer = 0L;

        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(input.readLine());
            int count = 1;

            // 1) 현재 키보다 작은 키는 pop(시야 확보)
            while (top >= 0 && stack[top].height < h) {
                answer += stack[top].count; // 작은 키는 모두 보임
                top--;
            }

            // 2) 동일 키 처리
            if (top >= 0 && stack[top].height == h) {
                // 같은 키 그룹 간 쌍만큼 더함
                answer += stack[top].count;
                count = stack[top].count + 1;
                top--;

                // 같은 키 뒤에 더 큰 키가 남아 있으면 1명 더 보임
                if (top >= 0) {
                    answer++;
                }

            } else {
                // 3) 현재 키보다 큰 사람 1명은 무조건 보임
                if (top >= 0) {
                    answer++;
                }
            }

            // 스택에 현재 그룹 push
            stack[++top] = new Node(h, count);
        }

        return String.valueOf(answer);
    }
}
