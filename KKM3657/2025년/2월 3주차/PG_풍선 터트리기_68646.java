import java.util.*;

class Solution {
    public int solution(int[] a) {
        int n = a.length;
        if (n <= 2) return n;  // 길이가 2 이하라면 모든 요소가 가능

        int answer = 0;

        // 왼쪽과 오른쪽에서 최소값을 유지
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];

        leftMin[0] = a[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], a[i]);
        }

        rightMin[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], a[i]);
        }

        // 가능한 요소 찾기
        for (int i = 0; i < n; i++) {
            if (a[i] <= leftMin[i] || a[i] <= rightMin[i]) {
                answer++;
            }
        }

        return answer;
    }
}
