import java.util.ArrayList;
import java.util.HashSet;
class Solution {
    char[] arr;
    ArrayList<Character> list = new ArrayList<Character>();
    HashSet<Integer> set = new HashSet<>();
    boolean[] selected;
    public int solution(String numbers) {
        arr = numbers.toCharArray();
        selected = new boolean[arr.length];
        findAnswer(0);
        return set.size();
    }
    public void findAnswer(int select) {
        if(list.size() != 0) {
            StringBuilder sb = new StringBuilder();
            for(Character c : list)
                sb.append(c);
            int value = Integer.parseInt(sb.toString());
            if(isPossible(value))
                set.add(value);
        }
        // 순열
        for(int i=0; i<arr.length; i++) {
            if(selected[i])
                continue;
            // 선택
            selected[i] = true;
            list.add(arr[i]);
            findAnswer(select+1);

            // 비선택
            selected[i] = false;
            list.remove(list.size()-1);
        }
    }
    public boolean isPossible(int value) {
        if(value <= 1)
            return false;
        else {
            for(int i=2; i*i<=value; i++) {
                if(value % i == 0)
                    return false;
            }
            return true;
        }
    }
}