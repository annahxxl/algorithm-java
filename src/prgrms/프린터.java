package prgrms;

import java.util.Collections;
import java.util.PriorityQueue;

public class 프린터 {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        // 1. 우선순위를 높은 숫자로 변경하여 우선순위 큐 생성
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int priority : priorities) {
            pq.add(priority);
        }

        // 2. 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되었는지 구하기
        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (pq.peek() == priorities[i]) {
                    if (i == location) {
                        answer++;
                        return answer;
                    }
                    pq.poll();
                    answer++;
                }
            }
        }

        return answer;
    }
}
