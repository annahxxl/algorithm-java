package prgrms;

public class 타겟_넘버 {
    int answer = 0;

    public void dfs(int[] numbers, int target, int idx, int total) {
        if (idx == numbers.length) {
            if (total == target) {
                answer++;
            }
        } else {
            dfs(numbers, target, idx + 1, total + numbers[idx]);
            dfs(numbers, target, idx + 1, total - numbers[idx]);
        }
    }

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
}
