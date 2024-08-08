// 가장 큰 수 Lv.2
// https://school.programmers.co.kr/learn/courses/30/lessons/42746
import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int[] numbers) {
        Integer[] numArray = Arrays.stream(numbers).boxed().toArray(Integer[]::new);

        Arrays.sort(numArray, (a, b) -> {
            long ab = Long.parseLong("" + a + b);
            long ba = Long.parseLong("" + b + a);
            return Long.compare(ba, ab);
        });

        if (numArray[0] == 0) {
            return "0";
        }

        StringBuilder answer = new StringBuilder();
        for (int num : numArray) {
            answer.append(num);
        }

        return answer.toString();
    }
}