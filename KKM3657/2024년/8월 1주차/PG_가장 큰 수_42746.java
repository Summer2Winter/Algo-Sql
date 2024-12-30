import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        // int 배열을 String 배열로 변환
        String[] stringNumbers = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(stringNumbers, new Comparator<String> () {
            @Override
            public int compare(String x, String y) {
                return (y + x).compareTo(x + y); // 내림차순 정렬
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<stringNumbers.length; i++)
            sb.append(stringNumbers[i]);
        answer = sb.toString();

        if (answer.startsWith("0")) {
            return "0";
        }
        return answer;
    }
}
//int형 배열을 String 배열로 변환
//Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
//StringBuilder의 메소드중 startWith로 0 판별