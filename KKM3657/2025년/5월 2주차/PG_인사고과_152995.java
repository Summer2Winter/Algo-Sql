import java.util.Arrays;

class Solution {
    public int solution(int[][] scores) {
        // 근호
        int[] genho = scores[0];

        // 근무 태도를 내림차순 정렬 + 동료 점수는 오름차순으로 정렬
        Arrays.sort(scores, (x,y) -> x[0] == y[0] ? x[1]-y[1] : y[0] - x[0]);

        int max = 0, answer = 1; // 1등부터 시작
        for(int[] score : scores) {
            // 동료 평가가 max보다 작은 경우는 인센티브 못받음
            if(max > score[1]) {
                // 근호이면 -1로 끝
                if(score.equals(genho))
                    return -1;
            }
            else {
                max = Math.max(max, score[1]);
                if(score[0] + score[1] > genho[0] + genho[1])
                    answer++;
            }
        }
        return answer;
    }
}

// 근무로 내림차순으로 정렬한 이유는 해당 하는 점수에 따른 밑에 점수는 항상 작다는 것을 보장하기 위해서 내림차순 정렬함
// 하지만 동료평가는 오름차순으로 정렬한 이유는 이제 두 점수보다 작은 것은 인센티브에 포함되지 않아야 하므로 max를 특정할 수 있다면
// max 보다 작은 건 제외 시킬 수 있다. 또한 합을 비교하여 근호 보다 높은 경우는 +1를 하므로 정답도 구할 수 있다.
/* 예시
3,2
3,2
2,1
2,2
1,4
이렇게 된다면 2,1은 2가 3보다 작다는 것을 보장하며, max가 2이므로 그보다 작은 1은 제외되게 된다.
1,4의 경우는 합이 근호보다 크므로 answer는 +1이 된다.
 */