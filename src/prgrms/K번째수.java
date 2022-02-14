package prgrms;

import java.util.ArrayList;
import java.util.Arrays;

public class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> answerList = new ArrayList<>();

        for (int[] command : commands) {
            int i = command[0];
            int j = command[1];
            int k = command[2];

            // 1. 배열 자르기
            int[] arr = Arrays.copyOfRange(array, i - 1, j);

            // 2. 배열 정렬하기
            Arrays.sort(arr);

            // 3. answerList에 값 추가
            answerList.add(arr[k - 1]);
        }

        // 4. answerList를 정수 배열로 변환
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
