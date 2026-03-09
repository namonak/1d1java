package swea.problems;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

public class SWEA5608 {
    static class Result {
        long count;
        long value;

        public Result(long count, long value) {
            this.count = count;
            this.value = value;
        }
    }

    static Map<Long, Result> memo;

    public static String solve(BufferedReader br) throws Exception {
        StringBuilder result = new StringBuilder();

        int testCaseCount = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= testCaseCount; i++) {
            long M = Long.parseLong(br.readLine().trim());

            memo = new HashMap<>();

            Result res = solve(M);

            result.append("#")
                    .append(i)
                    .append(" ")
                    .append(res.count)
                    .append(" ")
                    .append(res.value)
                    .append("\n");
        }

        return result.toString().trim();
    }

    private static Result solve(long limit) {
        if (limit == 0) {
            return new Result(0, 0);
        }

        if (memo.containsKey(limit)) {
            return memo.get(limit);
        }

        long root = (long) Math.cbrt(limit);
        long cube = root * root * root;

        Result res1 = solve(limit - cube);
        long count1 = res1.count + 1;
        long value1 = res1.value + cube;

        Result res2 = solve(cube - 1);
        long count2 = res2.count;
        long value2 = res2.value;

        Result best;
        if (count1 > count2) {
            best = new Result(count1, value1);
        } else if (count2 > count1) {
            best = new Result(count2, value2);
        } else {
            if (value1 >= value2) {
                best = new Result(count1, value1);
            } else {
                best = new Result(count2, value2);
            }
        }

        memo.put(limit, best);
        return best;
    }
}
