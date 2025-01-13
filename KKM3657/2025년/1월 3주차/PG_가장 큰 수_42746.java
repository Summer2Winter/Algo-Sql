import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        // Integer로 변경
        String[] temp = new String[numbers.length];
        int idx = 0;
        for(int value : numbers)
            temp[idx++] = Integer.toString(value);

        // 자리수로 기준으로 정렬
        Arrays.sort(temp, new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                // 자리수 비교
                return (y+x).compareTo(x+y);
            }
        });

        // 0이면 0 출력
        if(temp[0].equals("0"))
            return "0";

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<temp.length; i++)
            sb.append(temp[i]);
        answer = sb.toString();
        return answer;
    }
}