package prgrms;

import java.util.Arrays;

public class 체육복 {
    // O(n)
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;

        // 1. 체크리스트 생성 (최종적으로 체육복을 빌려야 하는 학생은 -1)
        int[] check = new int[n + 2]; // 0으로 초기화된 배열 생성
        for (int l : lost) {
            check[l]--;
        }
        for (int r : reserve) {
            check[r]++;
        }

        // 2. 체육복 빌려주기
        for (int i = 1; i <= n; i++) {
            if (check[i] == -1) {
                if (check[i - 1] == 1) {
                    check[i - 1]--;
                    check[i]++;
                } else if (check[i + 1] == 1) {
                    check[i + 1]--;
                    check[i]++;
                } else {
                    answer--;
                }
            }
        }

        return answer;
    }

    // O(n ** 2)
    public int sol(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 1. 여벌 체육복이 있는 학생이 도난당한 경우
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        // 2. 도난당한 학생에게 체육복을 빌려주는 경우
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if ((lost[i] - 1 == reserve[j]) || (lost[i] + 1 == reserve[j])) {
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        return answer;
    }
}
