class Solution {
    public int[] solution(int n, int s) {
        // 합 분배
        int temp = s / n;
        // 정답이 없는 경우
        if(temp == 0)
            return new int[]{-1};

        int[] answer = new int[n];
        int remain = s % n;
        // 분배
        for(int i=n-1; i>=0; i--) {
            if(remain-- > 0)
                answer[i] = temp + 1;
            else
                answer[i] = temp;
        }

        return answer;
    }
}