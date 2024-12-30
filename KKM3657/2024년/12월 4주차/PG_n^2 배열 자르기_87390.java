class Solution {
    public int[] solution(int n, long left, long right) {
        int abs = (int) (right - left + 1);
        int[] answer = new int[abs];
        int idx = 0;

        for(long i=left; i<=right; i++) {
            // 몫
            long value = i / n;
            // a+1까지 숫자
            long remain = i % n;
            answer[idx++] = (int) Math.max(remain, value) + 1;
        }
        return answer;
    }
}