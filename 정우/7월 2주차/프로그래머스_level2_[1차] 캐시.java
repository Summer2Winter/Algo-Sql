import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if(cacheSize !=0){
            ArrayList<String> list = new ArrayList<>();
            for(int i=0; i<cities.length; i++){
                String city = cities[i].toUpperCase();
                if(list.contains(city)){
                    list.remove(city);
                    list.add(city);
                    answer += 1;
                }
                else{
                    if(list.size()==cacheSize){
                        list.remove(0);
                    }
                    list.add(city);
                    answer += 5;
                }
            }
        }
        else{
            answer = cities.length * 5;
        }
        return answer;
    }
}
