import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        // LRU 전략을 위한 페이지
        LinkedList<String> list = new LinkedList<>();
        // 조회를 위한 map 선언
        Map<String, Integer> map = new HashMap<>();

        if(cacheSize == 0)
            return cities.length * 5;

        for(int i=0; i<cities.length; i++) {
            String city = cities[i].toUpperCase();
            // cache hit
            if(map.containsKey(city)){
                answer += 1;
                // 리스트에서 해당 페이지 갱신
                list.remove(city);
                list.addFirst(city);
                map.put(city, i+1);
            }
            // cache miss
            else {
                answer += 5;
                if(list.size() == cacheSize){
                    String change = list.removeLast();
                    map.remove(change);
                }
                map.put(city, i+1);
                list.addFirst(city);
            }
        }
        return answer;
    }
}