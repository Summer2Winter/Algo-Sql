import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashSet<String> wordSet = new HashSet<>();
        int people = 1, turn = 1;
        char prev = words[0].charAt(0);
        for(String word : words) {
            // 정답
            if(wordSet.contains(word) || prev != word.charAt(0)) {
                // 사람
                answer[0] = people;
                answer[1] = turn;
                break;
            }
            prev = word.charAt(word.length()-1);
            if(people == n) {
                people = 0;
                turn++;
            }
            people++;
            wordSet.add(word);
        }
        return answer;
    }
}