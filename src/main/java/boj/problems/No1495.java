package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class No1495 {

    public static String solve(BufferedReader input) throws IOException {
        FastScanner scanner = new FastScanner(input);

        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int m = scanner.nextInt();

        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = scanner.nextInt();
        }

        boolean[] prev = new boolean[m + 1];
        prev[s] = true;

        return String.valueOf(findMaximumVolume(prev, diff, m));
    }

    private static int findMaximumVolume(boolean[] reachable, int[] changes, int maxVolume) {
        boolean[] current = reachable;
        for (int change : changes) {
            current = moveReachableVolumes(current, change, maxVolume);
            if (!hasReachableVolume(current)) {
                return -1;
            }
        }

        return findHighestReachableVolume(current);
    }

    private static boolean[] moveReachableVolumes(boolean[] current, int change, int maxVolume) {
        boolean[] next = new boolean[maxVolume + 1];
        for (int volume = 0; volume <= maxVolume; volume++) {
            if (current[volume]) {
                markReachable(next, volume + change);
                markReachable(next, volume - change);
            }
        }
        return next;
    }

    private static void markReachable(boolean[] volumes, int volume) {
        if (volume >= 0 && volume < volumes.length) {
            volumes[volume] = true;
        }
    }

    private static boolean hasReachableVolume(boolean[] volumes) {
        for (boolean reachable : volumes) {
            if (reachable) {
                return true;
            }
        }
        return false;
    }

    private static int findHighestReachableVolume(boolean[] volumes) {
        for (int volume = volumes.length - 1; volume >= 0; volume--) {
            if (volumes[volume]) {
                return volume;
            }
        }
        return -1;
    }

    private static class FastScanner {
        private final BufferedReader br;
        private StringTokenizer st;

        private FastScanner(BufferedReader br) {
            this.br = br;
        }

        private int nextInt() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) {
                    throw new IOException("입력이 부족합니다.");
                }
                st = new StringTokenizer(line);
            }
            return Integer.parseInt(st.nextToken());
        }
    }
}
