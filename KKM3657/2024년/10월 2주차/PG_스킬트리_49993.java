class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int len = skill.length();
        char[] skillArr = skill.toCharArray();
        for(int t=0; t<skill_trees.length; t++) {
            // 초기화
            int idx = 0;
            boolean flag = true;
            char[] skillTree = skill_trees[t].toCharArray();

            // 알파벳 기록
            boolean[] visited = new boolean[26];

            for(int i=0; i<skillTree.length; i++) {
                if(idx == len) break;
                // 현재 글자
                int curr = skillTree[i] - 'A', now = skillArr[idx] - 'A';

                if(visited[now]) {
                    flag = false;
                    break;
                }
                if(curr == now) idx++;
                visited[curr] = true;
            }
            // 남은거 확인
            for(int i=idx; i<len; i++) {
                if(visited[skillArr[i] - 'A']) {
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }
        return answer;
    }
}

// 문제에서 26개의 알파벳, 중복이 없다는 것을 제시했으므로 26의 크기의 알파벳 배열을 만들고 방문 기록을 한다.
// 여기서 순서가 중요하므로 String을 char 배열로 만들고 방문처리를 하면 기존에 방문했던 곳이 나오면 넘어가도록 하였다.
// 마지막에는 남은 글자들을 하나씩 확인하고 처리하는 방식을 사용했다.