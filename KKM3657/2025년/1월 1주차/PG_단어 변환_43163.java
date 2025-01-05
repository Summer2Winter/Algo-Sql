import java.util.ArrayDeque;
class Word {
    String word;
    int cnt;

    Word(String word, int cnt) {
        this.word = word;
        this.cnt = cnt;
    }
}
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = Integer.MAX_VALUE;
        ArrayDeque<Word> q = new ArrayDeque<>();
        boolean[] selected = new boolean[words.length];
        q.add(new Word(begin, 0));

        while(!q.isEmpty()) {
            Word curr = q.poll();

            //정답
            if(curr.word.equals(target)) {
                answer = curr.cnt;
                break;
            }

            for(int i=0; i<words.length; i++) {
                if(selected[i])
                    continue;
                if(isPossible(curr.word, words[i])) {
                    selected[i] = true;
                    q.add(new Word(words[i], curr.cnt+1));
                }
            }
        }
        if(answer == Integer.MAX_VALUE)
            answer = 0;
        return answer;
    }
    public boolean isPossible(String wordA, String wordB) {
        int cnt = 0;
        for(int i=0; i<wordA.length(); i++) {
            char a = wordA.charAt(i);
            char b = wordB.charAt(i);
            // 다른 경우
            if(a != b)
                cnt++;

            if(cnt > 1)
                return false;
        }
        return true;
    }
}