import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    public int solution(int N, int number) {
        // 1개부터 8개
        ArrayList<HashSet<Integer>> dp = new ArrayList<>();

        // 초기화
        for(int i=0; i<=8; i++) {
            dp.add(new HashSet<>());
        }

        // 1개부터 8개까지 반복
        for(int i=1; i<=8; i++) {
            // 5, 55, 555.. 반복
            int repeatNumber = Integer.parseInt(String.valueOf(N).repeat(i));
            dp.get(i).add(repeatNumber);

            // 사칙연산 확인, 두 부분으로 분리
            for(int j=1; j<i; j++) {
                // i개중 사칙연산으로 j개를 만든 숫자
                for(int partA : dp.get(j)) {
                    // j개를 제외한 나머지 개수로 만든 숫자
                    for(int partB : dp.get(i-j)) {
                        // +
                        dp.get(i).add(partA+partB);
                        // -
                        dp.get(i).add(partA-partB);
                        dp.get(i).add(partB-partA);
                        // *
                        dp.get(i).add(partA*partB);
                        // /
                        if(partB != 0)
                            dp.get(i).add(partA/partB);
                        if(partA != 0)
                            dp.get(i).add(partB/partA);
                    }
                }
            }
            if(dp.get(i).contains(number))
                return i;
        }
        return -1;
    }
}


// DFS 방식
/*
class Solution {
    private int answer = Integer.MAX_VALUE;

    public int solution(int N, int number) {
        // N과 number가 동일한 경우 바로 반환
        if (N == number) return 1;

        // DFS 탐색
        dfs(N, number, 0, 0);

        // 최소 횟수 반환 (8번을 넘으면 불가능)
        return answer > 8 ? -1 : answer;
    }

    private void dfs(int N, int number, int count, int current) {
        // 숫자를 8번 초과 사용한 경우 탐색 중단
        if (count > 8) return;

        // 목표 숫자를 찾은 경우 최소값 갱신
        if (current == number) {
            answer = Math.min(answer, count);
            return;
        }

        // 사칙연산과 숫자 이어붙이기 시도
        int temp = 0;
        for (int i = 1; i <= 8 - count; i++) {
            temp = temp * 10 + N; // 숫자 이어붙이기
            dfs(N, number, count + i, current + temp); // 덧셈
            dfs(N, number, count + i, current - temp); // 뺄셈
            dfs(N, number, count + i, current * temp); // 곱셈
            if (temp != 0) dfs(N, number, count + i, current / temp); // 나눗셈
        }
    }
}

 */