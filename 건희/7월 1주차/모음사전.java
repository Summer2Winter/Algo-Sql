import java.util.*;

class Solution {
    char[] text = {'A','E','I','O','U'};
    ArrayList<String> list;
    public int solution(String word) {
        int answer = 1;
        list = new ArrayList<>();
        // 모든 경우를 담을 배열을 선언한다.
        // bfs를 실행 시켜서 모든 경우를 배열에 넣는다. 단 문자열의 길이가 6이 되면 종료
        // 최종적으로 해당 배열을 전체 순회해서 word랑 같은 녀석을 찾고 
        // 해당 인덱스에 +1 해서 반환한다.
        bfs("");
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals(word)){
                answer+=i;
                break;
            }
        }
        return answer;
    }
    
    public void bfs(String before){
        for(int i = 0; i < 5; i ++){
            String tmp = before+text[i];
            if(tmp.length() >= 6) break;
            list.add(tmp);
            bfs(tmp);
        }
    }
}
