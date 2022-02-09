package prgrms;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answerList = new ArrayList<>();

        // 1. 정수 배열을 Deque로 변환
        ArrayDeque<Integer> pr = new ArrayDeque<>();
        ArrayDeque<Integer> sp = new ArrayDeque<>();
        for (int i = 0; i < progresses.length; i++) {
            pr.addLast(progresses[i]);
            sp.addLast(speeds[i]);
        }

        // 2. answerList 구하기
        int day = 0;
        int cnt = 0;
        while (pr.size() > 0) {
            if (pr.getFirst() + (sp.getFirst() * day) >= 100) {
                cnt++;
                pr.removeFirst();
                sp.removeFirst();
            } else {
                // 진도가 100%인 작업이 존재한다면 배포
                if (cnt > 0) {
                    answerList.add(cnt);
                    cnt = 0;
                }
                day++;
            }
        }
        answerList.add(cnt);

        // 3. answerList를 정수 배열로 변환
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
