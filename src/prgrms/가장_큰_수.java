package prgrms;

import java.util.Arrays;

public class 가장_큰_수 {
    public String solution(int[] numbers) {
        String answer = "";

        // 1. 정수 배열을 문자열 배열로 변환
        String[] str = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }

        // 2. 내림차순 정렬
        Arrays.sort(str, (n1, n2) -> (n2 + n1).compareTo(n1 + n2));

        // 3. 첫 번째 값이 0이면 0을 리턴
        if (str[0].equals("0")) {
            return "0";
        }

        // 4. 문자열을 모두 더해 answer 구하기
        for (String s : str) {
            answer += s;
        }

        return answer;
    }
}
