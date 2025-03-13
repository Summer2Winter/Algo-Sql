import java.util.ArrayDeque;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        String answer = "";

        // 다음 노드
        int[] next = new int[n];
        // 이전 노드
        int[] prev = new int[n];

        // 삭제 여부
        boolean[] deleteN = new boolean[n];

        // 초기화
        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        next[n - 1] = -1; // 마지막 원소의 다음은 없음

        // 삭제 행위
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int curr = k;
        // 실행
        for(String instruct : cmd) {
            String act = null;
            int move = 0;
            // 명령어
            if(instruct.length() == 1) {
                act = instruct;
            }
            else {
                // 분할
                String[] str = instruct.split(" ");
                act = str[0];
                move = Integer.parseInt(str[1]);
            }
            // 명령어 수행
            if(act.equals("U")) {
                while(move-- > 0) {
                    curr = prev[curr]; // 삭제된 노드 건너뜀
                }
            }
            else if(act.equals("D")) {
                while(move-- > 0) {
                    curr = next[curr]; // 삭제된 노드 건너뜀
                }
            }
            else if(act.equals("C")) {
                stack.push(curr);
                deleteN[curr] = true;

                // 행 제거
                if (prev[curr] != -1)
                    next[prev[curr]] = next[curr];  // 이전 행의 다음값을 현재 행의 다음으로 설정
                if (next[curr] != -1)
                    prev[next[curr]] = prev[curr];  // 다음 행의 이전값을 현재 행의 이전으로 설정

                // 마지막 행
                if (next[curr] != -1)
                    curr = next[curr];
                else
                    curr = prev[curr];
            }
            else {
                // 복구
                int revive = stack.pop();
                deleteN[revive] = false;

                // 복구
                if(prev[revive] != -1)
                    next[prev[revive]] = revive;
                if(next[revive] != -1)
                    prev[next[revive]] = revive;
            }
        }
        StringBuilder sb = new StringBuilder();
        // 남은거 변환
        for(int i=0; i<n; i++) {
            if(deleteN[i])
                sb.append("X");
            else
                sb.append("O");
        }
        answer = sb.toString();
        return answer;
    }
}