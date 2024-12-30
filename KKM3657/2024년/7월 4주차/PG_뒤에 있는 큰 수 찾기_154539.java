import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int i=0; i<numbers.length; i++) {
            // 스택에서 찾기
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                int idx = stack.pop();
                answer[idx] = numbers[i];
            }

            // 스택에 넣기
            stack.push(i);
        }
        return answer;
    }
}