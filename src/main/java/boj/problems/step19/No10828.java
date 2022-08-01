package boj.problems.step19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No10828 {
    static class Stack {
        int size = 0;
        int[] arr;

        Stack(int stackSize) {
            this.arr = new int[stackSize];
        }

        public void push(int data) {
            this.arr[size] = data;
            size++;
        }

        public int pop() {
            if (this.size == 0) {
                return -1;
            }

            int ret = this.arr[this.size - 1];
            this.arr[this.size - 1] = 0;
            this.size--;

            return ret;
        }

        public int size() {
            return this.size;
        }

        public int empty() {
            return this.size == 0 ? 1 : 0;
        }

        public int top() {
            if (this.size == 0) {
                return -1;
            }

            return this.arr[this.size - 1];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        solve(input, output);

        output.flush();
        output.close();
    }

    static void solve(BufferedReader input, BufferedWriter output) throws IOException {
        int n = Integer.parseInt(input.readLine());

        Stack stack = new Stack(n);

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine(), " ");

            switch (st.nextToken()) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    output.write(stack.pop() + "\n");
                    break;
                case "size":
                    output.write(stack.size() + "\n");
                    break;
                case "empty":
                    output.write(stack.empty() + "\n");
                    break;
                case "top":
                    output.write(stack.top() + "\n");
                    break;
            }
        }
    }
}
