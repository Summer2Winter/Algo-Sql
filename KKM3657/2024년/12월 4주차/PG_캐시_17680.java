import java.util.LinkedList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> cache = new LinkedList<>();

        // 실행시간
        if(cacheSize == 0)
            answer = cities.length * 5;
        else {
            int cacheIdx = 0;
            for(String place : cities) {
                place = place.toUpperCase();

                // 캐시 hit
                if(cache.remove(place)){
                    cache.add(place);
                    answer += 1;
                }
                else {
                    if(cacheIdx == cacheSize)
                        cache.removeFirst();
                    else
                        cacheIdx += 1;
                    cache.add(place);
                    answer += 5;
                }
            }
        }
        return answer;
    }
}