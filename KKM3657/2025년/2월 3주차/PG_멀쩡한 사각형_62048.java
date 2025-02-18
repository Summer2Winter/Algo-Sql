class Solution {
    public long solution(int w, int h) {
        long answer = 0;
        for (int x = 0; x < w; x++)
            answer += (int) (x * (double) h / w);
        return answer * 2;
    }
}