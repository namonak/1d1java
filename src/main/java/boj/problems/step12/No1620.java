package boj.problems.step12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        output.write(solve(input));

        input.close();
        output.flush();
        output.close();
    }

    static String solve(BufferedReader input) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());
        int monsterNumber = Integer.parseInt(st.nextToken());
        int questionNumber = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> monsterMap1 = new HashMap<>();
        HashMap<Integer, String> monsterMap2 = new HashMap<>();

        makeMonsterMap(input, monsterNumber, monsterMap1, monsterMap2);

        return makeOutput(input, questionNumber, monsterMap1, monsterMap2);
    }

    private static void makeMonsterMap(BufferedReader input, int monsterNumber, HashMap<String, Integer> monsterMap1, HashMap<Integer, String> monsterMap2) throws IOException {
        for (int i = 1; i <= monsterNumber; i++) {
            String monster = input.readLine();
            monsterMap1.put(monster, i);
            monsterMap2.put(i, monster);
        }
    }

    private static String makeOutput(BufferedReader input, int questionNumber, HashMap<String, Integer> monsterMap1, HashMap<Integer, String> monsterMap2) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < questionNumber; i++) {
            String question = input.readLine();
            addResult(monsterMap1, monsterMap2, sb, question);
        }
        return sb.toString();
    }

    private static void addResult(HashMap<String, Integer> monsterMap1, HashMap<Integer, String> monsterMap2, StringBuilder sb, String question) {
        if (Character.isDigit(question.charAt(0))) {
            sb.append(monsterMap2.get(Integer.parseInt(question)) + "\n");
            return;
        }
        sb.append(monsterMap1.get(question) + "\n");
    }
}
