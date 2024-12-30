import java.util.HashMap;

class Solution {
    HashMap<String, Integer> product = new HashMap<>();
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        //1일차 - 10일차
        for(int i=0; i<10; i++) {
            product.put(discount[i], product.getOrDefault(discount[i], 0) + 1);
        }
        if(isPossible(want, number))
            answer++;

        // 2일차
        for(int i=0; i<discount.length-10; i++) {
            // 빼기
            product.put(discount[i], product.get(discount[i]) - 1);

            // 더하기
            product.put(discount[i+10], product.getOrDefault(discount[i+10], 0) + 1);

            if(isPossible(want, number))
                answer++;
        }
        return answer;
    }

    public boolean isPossible(String[] want, int[] number) {
        for(int i=0; i<want.length; i++) {
            if(!product.containsKey(want[i]))
                return false;
            if(product.get(want[i]) < number[i])
                return false;
        }
        return true;
    }
}