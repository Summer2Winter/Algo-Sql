import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public String[] solution(String[] files) {
        // 배열 정렬
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String regex = "^(\\D+)(\\d+)(.*)$";
                Pattern pattern = Pattern.compile(regex);

                Matcher m1 = pattern.matcher(s1);
                Matcher m2 = pattern.matcher(s2);

                if (m1.matches() && m2.matches()) {
                    // head, number 추출
                    String head1 = m1.group(1).toLowerCase(); // 대소문자 구분 X
                    String head2 = m2.group(1).toLowerCase();

                    int number1 = Integer.parseInt(m1.group(2));
                    int number2 = Integer.parseInt(m2.group(2));

                    // head 기준 정렬
                    int headCompare = head1.compareTo(head2);
                    if (headCompare != 0) {
                        return headCompare;
                    }

                    // number 기준 정렬
                    return Integer.compare(number1, number2);
                }
                return 0; // 기본 정렬
            }
        });
        return files;
    }
}