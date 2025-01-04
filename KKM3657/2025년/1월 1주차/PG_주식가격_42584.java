import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int i=0; i<prices.length; i++) {
            int currPrice = prices[i];
            // 낮아질때 빼기
            while(!stack.isEmpty() && prices[stack.peek()] > currPrice) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = prices.length-1-idx;
        }
        return answer;
    }
}