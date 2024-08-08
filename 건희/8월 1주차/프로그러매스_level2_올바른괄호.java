// 올바른 괄호 Lv.2
// https://school.programmers.co.kr/learn/courses/30/lessons/12909
class Solution {
    boolean solution(String s) {
        char[] input = s.toCharArray();
        //스택을 사용 할건데 '('만 저장하는 스택 생각해보면 스택도 필요없기는 하다 갯수로 카운팅 하면 되잖아
        int open = 0;
        boolean empty = true;
        for(int i = 0; i < input.length; i++){
            if(input[i] == '('){
                open++;
                empty = false;
            }else if(!empty){
                open--;
                if(open == 0){
                    empty = true;
                }
            }else{
                return false;
            }
        }
        if(open != 0){
            return false;
        }else{
            return true;
        }
    }
}