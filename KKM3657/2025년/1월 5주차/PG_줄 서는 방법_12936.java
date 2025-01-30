import java.util.ArrayList;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> remain = new ArrayList<>();
        ArrayList<Integer> answerList = new ArrayList<>();
        // 현재 숫자
        for(int i=1; i<=n; i++)
            remain.add(i);

        long fact = 1; // 팩토리얼 값 초기화
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }

        k--; // 0-based index로 변환

        for (int i = 0; i < n; i++) {
            fact /= (n - i); // (n-i)! 값 계산
            int index = (int) (k / fact);
            answer[i] = remain.get(index);
            answerList.add(remain.remove(index));
            k %= fact;
        }

        return answer;
    }
}