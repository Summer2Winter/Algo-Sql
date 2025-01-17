class Solution {
    int answer;
    public int solution(int storey) {
        answer = Integer.MAX_VALUE;
        findAnswer(storey, 0);
        return answer;
    }
    public void findAnswer(int storey, int temp) {
        if(storey == 0) {
            answer = Math.min(answer, temp);
            return;
        }
        // 현재 자리수
        int curr = storey % 10;

        if(curr == 5) {
            // 내려가는 경우
            findAnswer(storey / 10, temp + curr);

            // 올라가는 경우
            findAnswer(storey / 10 + 1, temp + 10 - curr);
        }
        else if(curr > 5) {
            // 올라가는 경우
            findAnswer(storey / 10 + 1, temp + 10 - curr);
        }
        else {
            // 내려가는 경우
            findAnswer(storey / 10, temp + curr);
        }
    }
}