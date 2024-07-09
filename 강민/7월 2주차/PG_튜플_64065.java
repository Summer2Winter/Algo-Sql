import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Comparator;

class Solution {
    public int[] solution(String s) {
        String temp = s.substring(2,s.length()-2);
        temp = temp.replace("},{", "-");
        String[] arr = temp.split("-");

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        });

        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<arr.length; i++) {
            StringTokenizer st = new StringTokenizer(arr[i], ",");
            while(st.hasMoreTokens()) {
                int value = Integer.parseInt(st.nextToken());
                if(!set.contains(value)){
                    set.add(value);
                    list.add(value);
                }
            }
        }

        int[] answer = list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        return answer;
    }
}