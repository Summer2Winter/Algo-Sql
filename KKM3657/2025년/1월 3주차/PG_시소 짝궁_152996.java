import java.util.HashMap;

class Solution {
    public long solution(int[] weights) {
        HashMap<Double, Integer> map = new HashMap<>();
        long answer = 0;

        for (int weight : weights) {
            // 비율 조건에 맞는 경우를 탐색
            answer += map.getOrDefault((double) weight, 0); // 동일한 무게
            answer += map.getOrDefault(weight * 2.0 / 3.0, 0); // 2:3 비율
            answer += map.getOrDefault(weight * 2.0 / 4.0, 0); // 2:4 비율
            answer += map.getOrDefault(weight * 3.0 / 2.0, 0); // 3:2 비율
            answer += map.getOrDefault(weight * 3.0 / 4.0, 0); // 3:4 비율
            answer += map.getOrDefault(weight * 4.0 / 2.0, 0); // 4:2 비율
            answer += map.getOrDefault(weight * 4.0 / 3.0, 0); // 4:3 비율

            // 현재 weight를 map에 추가
            map.put((double) weight, map.getOrDefault((double) weight, 0) + 1);
        }

        return answer;
    }
}
