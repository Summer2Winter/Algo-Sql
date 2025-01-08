import java.util.Arrays;
class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];

        // s를 n부분으로 나누기
        if(s / n == 0)
            return new int[]{-1};

        // 값 분배
        Arrays.fill(answer, s / n);
        // 남은 값 분배
        int remain = s % n, idx = 0;
        for (int i = n - 1; i >= n - remain; i--) {
            answer[i]++;
        }
        return answer;
    }
}