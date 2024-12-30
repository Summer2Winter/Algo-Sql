import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        // 데이터 추가
        for(String[] value: clothes) {
            String type = value[1];
            if(map.containsKey(type)) {
                ArrayList<String> list = map.get(type);
                list.add(value[0]);
            }
            else {
                ArrayList<String> list = new ArrayList<>();
                list.add(value[0]);
                map.put(type, list);
            }
        }
        // 계산
        for(String type : map.keySet()) {
            ArrayList<String> list = map.get(type);
            answer *= (list.size()+1);
        }
        return answer-1;
    }
}