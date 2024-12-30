import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.HashSet;

class Solution {
    public int[] solution(String s) {
        // 문자열 파싱
        s = s.replace("{{", "").replace("}}", "").replace("},{", "/");
        String[] arr = s.split("/");
        int[] answer = new int[arr.length];

        // 순서 정렬
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });

        HashSet<Integer> set = new HashSet<>();
        int idx = 0;
        // 나열
        for(String word : arr) {
            StringTokenizer st = new StringTokenizer(word, ",");
            // 토큰 분리
            while(st.hasMoreTokens()) {
                int value = Integer.parseInt(st.nextToken());
                // 중복여부
                if(set.contains(value))
                    continue;
                set.add(value);
                answer[idx++] = value;
            }
        }

        return answer;
    }
}