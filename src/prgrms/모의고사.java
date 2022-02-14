package prgrms;

import java.util.ArrayList;

public class 모의고사 {
    public int[] solution(int[] answers) {
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        // 1. 각각의 점수 구하기
        int[] scores = {0, 0, 0};
        for (int i = 0; i < answers.length; i++) {
            if (p1[i % 5] == answers[i]) {
                scores[0]++;
            }
            if (p2[i % 8] == answers[i]) {
                scores[1]++;
            }
            if (p3[i % 10] == answers[i]) {
                scores[2]++;
            }
        }

        // 2. 최댓값 찾기
        int maximum = 0;
        for (int score : scores) {
            if (score > maximum) {
                maximum = score;
            }
        }

        // 3. answerList 구하기
        ArrayList<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maximum) {
                answerList.add(i + 1);
            }
        }

        // 4. answerList를 정수 배열로 변환
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
