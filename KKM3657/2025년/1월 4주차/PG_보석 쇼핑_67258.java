import java.util.HashSet;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];

        // 전체 종류 찾기
        HashSet<String> gemSet = new HashSet<>();
        for(String gem : gems)
            gemSet.add(gem);

        // 전체 종류
        int temp = 0, total = gemSet.size(), abs = Integer.MAX_VALUE;
        HashMap<String, Integer> map = new HashMap<>();
        int end = 0;

        // 진행
        for(int i=0; i<gems.length; i++) {
            // 빼기
            if(i != 0) {
                if(map.get(gems[i-1]) == 1) {
                    temp--;
                    map.remove(gems[i-1]);
                }
                else
                    map.put(gems[i-1], map.get(gems[i-1]) - 1);
            }

            // 구간 늘리기
            while(end < gems.length && temp < total) {
                // 더하기
                if(map.containsKey(gems[end]))
                    map.put(gems[end], map.get(gems[end]) + 1);
                else {
                    map.put(gems[end], 1);
                    temp++;
                }
                end++;
            }

            // 구간 갱신
            if(temp == total && end-i+1 < abs) {
                abs = end-i+1;
                answer[0] = i+1;
                answer[1] = end;
            }
        }
        return answer;
    }
}