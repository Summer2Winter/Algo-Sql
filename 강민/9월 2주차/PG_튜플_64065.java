import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    public int[] solution(String s) {
        // 변환
        s = s.replace("{{" , "");
        s = s.replace("}}" , "");
        s = s.replace("},{", "-");
        String[] arr = s.split("-");

        // 정렬 원소의 길이 만큼
        Arrays.sort(arr, (x,y) -> x.length() - y.length());

        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        // 튜플 만들기
        for(int i=0; i<arr.length; i++) {
            // 문자열 나누기
            String[] temp = arr[i].split(",");
            for(int j=0; j<temp.length; j++) {
                int number = Integer.parseInt(temp[j]);
                if(!set.contains(number)) {
                    list.add(number);
                    set.add(number);
                    break;
                }
            }
        }
        // 배열로 바꾸기
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++)
            answer[i] = list.get(i);
        return answer;
    }
}