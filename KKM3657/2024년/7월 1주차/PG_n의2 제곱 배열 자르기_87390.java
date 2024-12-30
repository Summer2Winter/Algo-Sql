class Solution {
    public int[] solution(int n, long left, long right) {
        int abs = (int) (right - left + 1);
        int idx = 0;
        int[] answer = new int[abs];
        // i*j의 몫, 나머지로 자르기
        for(long i = left; i<=right; i++) {
            long value = i / n;
            long remain = i % n;

            if(remain > value)
                answer[idx++] = (int) remain+1;
            else
                answer[idx++] = (int) value+1;
        }
        return answer;
    }
}