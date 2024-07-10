import java.util.*;

/*
    base : 다른 사람보다 합산 점수가 높다면 두개의 점수중 하나는 무조건 다른 사람보다 높음.
    1. 근무 태도 점수 기준으로 내림차순
    2. 근무 태도 점수가 같다면 동료 평가 점수로 오름차순
    -> 이렇게 되면, 동료 평가 점수의 값이 이전에 동료 평가 점수보다 작을 경우 인센티브를 받지 못함.
    3. 배열을 순차적으로 돌면서 동료 평가 점수가 가장 큰 값을 탐색하면서 인센티브 받지 못하는 경우 탐색
*/

class Solution {
    
    public int solution(int[][] scores) {

        int[] wanhoScore = scores[0];
        int rank = 1;
        int companyScore = 0;
        int wTotal = wanhoScore[0] + wanhoScore[1];
        
        Arrays.sort(scores, (o1, o2) -> {
            if (o1[0] == o2[0])
                return o1[1] - o2[1];
            return o2[0] - o1[0];
        });
        
        for (int[] score : scores) {
            if (companyScore <= score[1]) {
                companyScore = score[1];
                if (score[0] + score[1] > wTotal) rank += 1; // 완호보다 점수가 큰 경우
            }
            else { // 반례 : [[4, 0], [2, 5], [5, 3], [2, 6]] / -1
                if (score.equals(wanhoScore)) { // 동료 평가 점수가 이전보다 높아야 인센티브를 받을 수 있는데 낮다면 인센티브를 받을 수 없고 이 점수가 완호 점수라면 -1 리턴
                    System.out.println(Arrays.toString(score));
                    System.out.println(Arrays.toString(wanhoScore));
                    
                    return -1;
                }
            }
        }

        return rank;
    }
}