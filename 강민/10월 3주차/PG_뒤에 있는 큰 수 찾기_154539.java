import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] numbers) {
        int N = numbers.length;
        int[] answer = new int[N];
        answer[N-1] = -1;
        // 스택
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i<N; i++) {
            // 스택에 비어 있으면 추가
            if(!stack.isEmpty()) {
                // 현재 값과 비교
                if(numbers[stack.peek()] >= numbers[i])
                    stack.push(i);
                else {
                    while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                        answer[stack.pop()] = numbers[i];
                    }
                }
            }
            stack.push(i);
        }
        // 남은거 처리
        while(!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        return answer;
    }
}

// 처음 문제를 봤을때 투 포인터라고 생각했다. 하지만 N의 크기가 100만인 것을 확인하고 N^2의 방법으로 한다면 시간초과가 날 것이라고 생각했고
// 빠르게 다른 방법을 찾았다. 그 결과 연속된 숫자열에서 스택을 사용하는것을 생각해 이를 반영하였다.