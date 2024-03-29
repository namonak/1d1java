package boj.problems.step9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No17478 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        output.write(solve(input));

        input.close();
        output.flush();
        output.close();
    }

    static String solve(BufferedReader input) throws IOException {
        int number = Integer.parseInt(input.readLine());
        StringBuilder sb = new StringBuilder();

        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");

        return answerToRecursion(number, "", sb);
    }


    private static String answerToRecursion(int number, String prefix, StringBuilder sb) throws IOException {
        sb.append(prefix + "\"재귀함수가 뭔가요?\"\n");
        makeAnswer(number, prefix, sb);
        sb.append(prefix + "라고 답변하였지.\n");

        return sb.toString();
    }

    private static void makeAnswer(int number, String prefix, StringBuilder sb) throws IOException {
        if (number == 0) {
            sb.append(prefix + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
            return;
        }
        sb.append(prefix + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
        sb.append(prefix + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
        sb.append(prefix + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
        answerToRecursion(--number, prefix + "____", sb);
    }
}
