import java.util.Arrays;
import java.util.ArrayDeque;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int N = A.length;
        // 정렬
        Arrays.sort(A);
        Arrays.sort(B);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int idx = 0;
        // 비교
        for(int i=0; i<N; i++) {
            // 비어있을때 넣기
            if(stack.isEmpty()) {
                stack.push(B[idx++]);
            }
            // 스택에 넣기
            while(A[i] >= stack.peek() && idx < N){
                // 다음 숫자 넣기
                stack.push(B[idx++]);
            }

            // 스택에서 추출
            if(stack.peek() > A[i]) {
                stack.pop();
                answer++;
            }
        }
        return answer;
    }
}
/*
    일단 데이터가 10만을 넘긴다는 점에서 dp, 그리디, 스택을 생각해 보았는데 스택으로 보였다.
    그 이유는 이전 숫자들을 저장하면서 자리를 찾아야 하므로 이는 스택을 이용하는 것이다.
    따라서 스택을 이용해서 정렬된 형태에서 해당 자리에 들어갈 수 있는 작은 수를 찾아서 넣는 방식으로
    정렬된 형태로 되어 있다면 이는 문제가 없다.
 */
/*
import java.util.Arrays;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int N = A.length;

        Arrays.sort(A);
        Arrays.sort(B);

        // 비교
        for(int a=N-1, b=N-1; a>=0; a--) {
            if(A[a] < B[b]) {
                answer++;
                b--;
            }
        }
        return answer;
    }
}
 */