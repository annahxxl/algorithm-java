package prgrms;

import java.util.HashMap;

public class 전화번호_목록 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        // 1. 전화번호부 생성
        HashMap<String, Boolean> dic = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++) {
            dic.put(phone_book[i], true);
        }

        // 2. 모든 전화번호의 마지막 숫자를 제외한 substring이 전화번호부에 존재하는지 확인
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if (dic.containsKey(phone_book[i].substring(0, j))) {
                    answer = false;
                }
            }
        }

        return answer;
    }
}
