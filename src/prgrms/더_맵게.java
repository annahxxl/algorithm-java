package prgrms;

import java.util.PriorityQueue;

public class 더_맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        // 1. 정수 배열을 힙(우선순위 큐)로 변환
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int scv : scoville) {
            heap.add(scv);
        }

        // 2. answer 구하기
        while (heap.peek() < K) {
            // 힙의 사이즈가 2 미만이면 새로운 음식을 만들 수 없으므로 -1
            if (heap.size() < 2) {
                return -1;
            }

            int first = heap.poll();
            int second = heap.poll();
            heap.add(first + (second * 2));

            answer++;
        }

        return answer;
    }
}

