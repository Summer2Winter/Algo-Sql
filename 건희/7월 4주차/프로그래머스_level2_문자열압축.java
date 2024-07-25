// https://school.programmers.co.kr/learn/courses/30/lessons/60057
public int solution(String s) {
        int n = s.length();
        int result = n;
        // 1개 단위부터 n/2 단위까지 자르기
        for (int unit = 1; unit <= n / 2; unit++) {
            String compressed = "";
            String prev = s.substring(0, unit);
            int count = 1;
            // 단위 크기만큼 문자열 자르기
            for (int j = unit; j < n; j += unit) {
                String sub;
                if (j + unit > n) {
                    sub = s.substring(j);
                } else {
                    sub = s.substring(j, j + unit);
                }

                if (prev.equals(sub)) {
                    count++;
                } else {
                    if (count > 1) {
                        compressed += count + prev;
                    } else {
                        compressed += prev;
                    }
                    prev = sub;
                    count = 1;
                }
            }
            if (count > 1) {
                compressed += count + prev;
            } else {
                compressed += prev;
            }
            result = Math.min(result, compressed.length());
        }
        return result;
    }