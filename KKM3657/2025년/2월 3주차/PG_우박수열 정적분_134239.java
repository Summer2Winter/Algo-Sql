import java.util.ArrayList;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Double> prefixSum = new ArrayList<>();

        // 우박수 수열 및 면적 계산
        list.add(k);
        prefixSum.add(0.0); // 초기 면적은 0

        while (k > 1) {
            int next = (k % 2 == 0) ? k / 2 : k * 3 + 1;
            list.add(next);
            // 면적 계산: (min(value1, value2) + (차이의 절반))
            double area = Math.min(k, next) + Math.abs(k - next) / 2.0;
            prefixSum.add(prefixSum.get(prefixSum.size() - 1) + area);
            k = next;
        }

        int n = list.size() - 1;
        double[] answer = new double[ranges.length];

        // 정적분 계산
        for (int i = 0; i < ranges.length; i++) {
            int a = ranges[i][0];
            int b = n + ranges[i][1];

            // 구간이 유효하지 않으면 -1
            if (a > b) {
                answer[i] = -1;
            } else {
                // 누적합을 이용해 구간 면적 계산
                answer[i] = prefixSum.get(b) - prefixSum.get(a);
            }
        }

        return answer;
    }
}
