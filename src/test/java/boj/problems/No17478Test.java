package boj.problems;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class No17478Test {
    @ParameterizedTest(name = "Case {index}: expected {1}")
    @MethodSource("provideTestCases")
    @DisplayName("재귀함수가 뭔가요? : https://www.acmicpc.net/problem/17478")
    void test(String given, String expected) throws Exception {
        BufferedReader reader = new BufferedReader(new StringReader(given));
        String result = No17478.solve(reader);
        assertThat(result).isEqualTo(expected);
    }

    // spotless:off
    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                arguments(
                        "2",
                        "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n" +
                        "\"재귀함수가 뭔가요?\"\n" +
                        "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n" +
                        "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n" +
                        "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n" +
                        "____\"재귀함수가 뭔가요?\"\n" +
                        "____\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n" +
                        "____마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n" +
                        "____그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n" +
                        "________\"재귀함수가 뭔가요?\"\n" +
                        "________\"재귀함수는 자기 자신을 호출하는 함수라네\"\n" +
                        "________라고 답변하였지.\n" +
                        "____라고 답변하였지.\n" +
                        "라고 답변하였지."
                ),
                arguments(
                        "4",
                        "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n" +
                        "\"재귀함수가 뭔가요?\"\n" +
                        "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n" +
                        "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n" +
                        "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n" +
                        "____\"재귀함수가 뭔가요?\"\n" +
                        "____\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n" +
                        "____마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n" +
                        "____그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n" +
                        "________\"재귀함수가 뭔가요?\"\n" +
                        "________\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n" +
                        "________마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n" +
                        "________그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n" +
                        "____________\"재귀함수가 뭔가요?\"\n" +
                        "____________\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n" +
                        "____________마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n" +
                        "____________그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n" +
                        "________________\"재귀함수가 뭔가요?\"\n" +
                        "________________\"재귀함수는 자기 자신을 호출하는 함수라네\"\n" +
                        "________________라고 답변하였지.\n" +
                        "____________라고 답변하였지.\n" +
                        "________라고 답변하였지.\n" +
                        "____라고 답변하였지.\n" +
                        "라고 답변하였지."
                )
        );
    }
    // spotless:on
}
