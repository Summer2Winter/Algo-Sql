import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        String[] arr = new String[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            arr[i] = Integer.toString(numbers[i]);
        }

        // 자리수로 기준으로 정렬
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                // 자리수 비교
                return (y+x).compareTo(x+y);
            }
        });

        if(arr[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++)
            sb.append(arr[i]);
        answer = sb.toString();
        return answer;
    }
}