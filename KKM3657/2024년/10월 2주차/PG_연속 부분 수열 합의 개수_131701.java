import java.util.HashSet;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int N = elements.length;
        HashSet<Integer> set = new HashSet<>();

        //시작 지점
        for(int i=0; i<N; i++) {
            int sum = 0;
            int idx = i, cnt = 0;
            // 선택 갯수
            while(cnt != N) {
                sum += elements[idx];
                set.add(sum);
                idx = (idx+1) % N;
                cnt++;
            }
        }
        answer = set.size();
        return answer;
    }
}

// 시작 지점에서 N까지 1개부터 N개를 선택할 수 있다. 또한 환형 구조이기 때문에 마지막 인덱스에서 넘어갈 경우 처음부터 시작하게 만들면 된다.
// 슬라이딩 윈도우로 하는 방법도 있지만 시간이 더 많이 걸리므로 시작지점부터 접근하는것이 시간이 덜 걸린다.