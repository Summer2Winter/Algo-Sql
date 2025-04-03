class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(String skillName : skill_trees) {
            // 다음에 배워야 될 스킬
            int idx = 0;
            boolean result = true;
            for(int i=0; i<skillName.length(); i++) {
                char curr = skillName.charAt(i); // 현재 글자
                if(idx >= skill.length()) {
                    break;
                }
                // 스킬트리에 포함된 글자인지 확인
                if(skill.indexOf(curr) != -1) {
                    if(skill.charAt(idx) != curr) {
                        result = false;
                        break;
                    }
                    idx++;
                }
            }
            if(result) {
                answer++;
            }
        }
        return answer;
    }
}