package prgrms;

import java.util.HashMap;

public class 완주하지_못한_선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();

        // 1. 참가자 등록
        for (String player : participant)
            map.put(player, map.getOrDefault(player, 0) + 1);

        // 2. 완주자는 값이 0이 되도록 체크
        for (String player : completion)
            map.put(player, map.get(player) - 1);

        // 3. 값이 0인 아닌 참가자는 완주하지 못한 선수
        for (String key : map.keySet()) {
            if (map.get(key) > 0) {
                answer = key;
                break;
            }
        }

        return answer;
    }
}
