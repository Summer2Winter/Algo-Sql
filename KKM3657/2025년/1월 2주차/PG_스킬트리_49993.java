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