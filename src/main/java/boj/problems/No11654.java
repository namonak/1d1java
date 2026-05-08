package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;

public class No11654 {
    static String solve(BufferedReader input) throws IOException {
        return String.valueOf((int) Objects.requireNonNull(input.readLine()).charAt(0));
    }
}
