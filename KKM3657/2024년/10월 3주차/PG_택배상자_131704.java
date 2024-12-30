import java.util.ArrayDeque;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int idx = 0;
        int N = order.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        // 택배 순서에 맞춰 처리
        for (int i = 1; i <= N; i++) {
            // 순서에 맞지 않으면 스택에 저장
            if (i != order[idx]) {
                stack.push(i);
            } else {
                // 맞는 순서일 경우 바로 증가
                answer++;
                idx++;
                // 스택에서 맞는 순서가 있으면 계속 처리
                while (!stack.isEmpty() && idx < N && stack.peek() == order[idx]) {
                    stack.pop();
                    answer++;
                    idx++;
                }
            }
        }
        return answer;
    }
}

// 생각보다 어려운 문제가 아닌데 구현에서 꼬여서 시간이 오래 걸렸다.
// 일단 2가지로 생각할 수 있는데 1부터 N까지 순서대로 접근하는 방식과 택배 순서대로 접근하는 방식이 있다.
// 여기서 쉽게 접근하기 위해서는 1부터 접근하는 것이 생각하기 쉬운 방법이다.
// 1. i가 현재 택배 순서와 같지 않은 경우 바로 스택에 저장하고 넘어가면 되고, 같은 경우 다음 부분이 보조 컨터이너 벨트에 해당하는지 확인하면 된다.
// 2. 여기서 불가능한 경우 바로 넘어가게 만들게 하면 정답을 구할 수 있다.