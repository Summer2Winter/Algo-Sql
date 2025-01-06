import java.util.ArrayDeque;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int idx = 0;
        for(int i=1; i<=order.length; i++) {
            // 스택에서 바로 뽑을 수 있는 경우
            while(!stack.isEmpty() && stack.peek() == order[idx]) {
                stack.pop();
                idx++;
                answer++;
            }
            if(idx < order.length) {
                if(i != order[idx])
                    stack.push(i);
                else {
                    idx++;
                    answer++;
                }
            }
        }
        // 나머지
        while(!stack.isEmpty() && stack.peek() == order[idx]) {
            stack.pop();
            idx++;
            answer++;
        }
        return answer;
    }
}