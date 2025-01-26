import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    int total;
    ArrayList<Character> list;
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answerList = new ArrayList<>();

        for(int courseValue : course) {
            // 고르는 갯수
            total = courseValue;
            // 음식 집합
            HashMap<String, Integer> frequencyMap = new HashMap<>();

            // 조합 만들기
            for (String order : orders) {
                // 불가능한 경우
                if(order.length() < total)
                    continue;
                char[] arr = order.toCharArray();
                Arrays.sort(arr);
                list = new ArrayList<>();
                makeSet(0, 0, arr, frequencyMap);
            }

            // 최대 빈도수 계산
            int maxFrequency = 2; // 최소 2명 이상이 선택한 경우만 가능
            for (int freq : frequencyMap.values()) {
                maxFrequency = Math.max(maxFrequency, freq);
            }

            // 최대 빈도수인 결과 저장
            for(Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
                if(entry.getValue() == maxFrequency)
                    answerList.add(entry.getKey());
            }
        }
        Collections.sort(answerList);
        // 정답
        String[] answer = new String[answerList.size()];
        int idx = 0;
        for(String result : answerList) {
            answer[idx++] = result;
        }
        return answer;
    }
    public void makeSet(int curr, int select, char[] food, HashMap<String, Integer> map) {
        // 선택완료
        if(select == total) {
            StringBuilder sb = new StringBuilder();
            for(Character temp : list)
                sb.append(temp);
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0)+1);
            return;
        }
        if(curr >= food.length)
            return;
        // 고르기
        list.add(food[curr]);
        makeSet(curr+1, select+1, food, map);

        // 고르지 않기
        list.remove(list.size()-1);
        makeSet(curr+1, select, food, map);
    }
}