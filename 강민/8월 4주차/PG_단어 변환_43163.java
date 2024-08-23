class Solution {
    String[] words;
    String end;
    int answer = Integer.MAX_VALUE;
    int N;
    boolean[] visited;
    public int solution(String begin, String target, String[] arr) {
        end = target;
        words = arr;
        N = words.length;
        visited = new boolean[N];
        dfs(begin, 0);
        if(answer == Integer.MAX_VALUE) {
            return 0;
        }
        return answer;
    }
    public void dfs(String curr, int cnt) {
        // 최소를 넘음
        if(answer < cnt) {
            return;
        }

        // 기저 조건
        if(curr.equals(end)){
            answer = Math.min(answer, cnt);
            return;
        }

        for(int i=0; i<N; i++) {
            if(visited[i])
                continue;
            // 다음으로 이동이 가능한지 확인
            if(isPossible(curr, words[i])) {
                visited[i] = true;
                dfs(words[i], cnt+1);
                visited[i] = false;
            }
        }
    }
    public boolean isPossible(String curr, String word) {
        boolean flag = false;
        for(int i=0; i<word.length(); i++) {
            char temp1 = curr.charAt(i);
            char temp2 = word.charAt(i);

            if(temp1 != temp2) {
                if(!flag)
                    flag = true;
                else
                    return false;
            }
        }
        return true;
    }
}