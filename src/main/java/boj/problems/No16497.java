package boj.problems;

import java.io.BufferedReader;
import java.io.IOException;

public class No16497 {
    public static String solve(BufferedReader input) throws IOException {
        int n = Integer.parseInt(input.readLine());

        // 1일부터 31일까지 각 날짜별로 대출된 책의 누적 권수를 저장할 배열
        // 인덱스를 날짜와 직관적으로 일치시키기 위해 크기를 32로 할당합니다.
        int[] borrowedBooksPerDay = new int[32];

        for (int i = 0; i < n; i++) {
            String[] parts = input.readLine().split(" ");
            int startDay = Integer.parseInt(parts[0]);
            int endDay = Integer.parseInt(parts[1]);

            // 핵심 로직: "모든 반납이 대출보다 먼저 이루어진다"
            // 즉, endDay에는 책이 반납되어 이미 다른 사람이 빌릴 수 있는 상태입니다.
            // 따라서 실제 대출 중인 기간은 startDay부터 endDay - 1 까지입니다.
            for (int day = startDay; day < endDay; day++) {
                borrowedBooksPerDay[day]++;
            }
        }

        // 마지막 줄: 도서관에서 보유 중인 책의 총 개수 K
        int k = Integer.parseInt(input.readLine());

        // 1일부터 31일까지 순회하며 K권을 초과하여 대출된 날이 있는지 확인합니다.
        for (int day = 1; day <= 31; day++) {
            if (borrowedBooksPerDay[day] > k) {
                // 단 하루라도 보유량 K를 초과하면 대출 요청을 모두 수용할 수 없습니다.
                return "0";
            }
        }

        // 모든 날짜에 대해 대출량이 K 이하이면 수용 가능합니다.
        return "1";
    }
}
