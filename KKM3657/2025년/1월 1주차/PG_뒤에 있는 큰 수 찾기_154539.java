import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i<numbers.length; i++) {
            // 뒷 큰수 확인
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i])
                answer[stack.pop()] = numbers[i];
            // 추가
            stack.push(i);
        }
        while(!stack.isEmpty())
            answer[stack.pop()] = -1;
        return answer;
    }
}