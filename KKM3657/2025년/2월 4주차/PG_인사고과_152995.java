import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[] s = scores[0];
        // 정렬 1차 점수에 대해서 내림차순 정렬, 2차 점수는 오름차순 정렬
        Arrays.sort(scores, (s1, s2) -> s1[0] == s2[0] ? s1[1] - s2[1] : s2[0] - s1[0]);
        // 숫자 리스트
        ArrayList<Integer> arr = new ArrayList<>();
        // 현재 위치에서의 최소 값 확인
        int max = 0, ans = 1;
        // 점수
        for(int[] score : scores) {
            // 현재 2차 점수가 max보다 작은 경우 넘어감, 은호이면 -1
            if(score[1] < max) {
                if(score.equals(s))
                    return -1;
            }
            else {
                max = Math.max(max, score[1]);
                if(s[0] + s[1] < score[0] + score[1])
                    ans++;
            }
        }
        return ans;
    }
}