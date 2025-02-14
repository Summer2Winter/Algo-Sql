import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int totalPicks = picks[0] + picks[1] + picks[2];  // 사용 가능한 곡괭이 개수
        int maxMineable = totalPicks * 5; // 최대 캘 수 있는 광물 개수
        int total = Math.min(maxMineable, minerals.length); // 실제 캘 광물 개수

        PriorityQueue<int[]> mineral = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] x, int[] y) {
                if (x[0] != y[0]) return y[0] - x[0]; // 다이아 개수 비교
                if (x[1] != y[1]) return y[1] - x[1]; // 철 개수 비교
                return y[2] - x[2]; // 돌 개수 비교
            }
        });
        int dia = 0, iron = 0, stone = 0;
        // 5개로 묶기
        for(int i=0; i<total; i++) {
            String name = minerals[i];
            // 광물 분류
            if(name.equals("diamond"))
                dia++;
            else if(name.equals("iron"))
                iron++;
            else
                stone++;
            // 5개가 되면 묶음 추가
            if((i+1)%5 == 0) {
                mineral.add(new int[]{dia,iron,stone});
                dia = 0;
                iron = 0;
                stone = 0;
            }
        }
        // 5개로 나눠 떨어지지 않는 경우
        if(minerals.length % 5 != 0) {
            mineral.add(new int[]{dia,iron,stone});
        }

        // 곡괭이 배분
        while(!mineral.isEmpty()) {
            int[] curr = mineral.poll();

            // 곡괭이가 없는 경우
            if(picks[0] == 0 && picks[1] == 0 && picks[2] == 0)
                break;

            // 다이아 곡괭이 배분
            if(picks[0] != 0) {
                picks[0]--;
                answer += curr[0] + curr[1] + curr[2];
            }
            // 철 곡괭이 배분
            else if(picks[1] != 0) {
                picks[1]--;
                answer += curr[0] * 5 + curr[1] + curr[2];
            }
            // 돌 곡괭이 배분
            else if(picks[2] != 0) {
                picks[2]--;
                answer += curr[0] * 25 + curr[1] * 5 + curr[2];
            }
        }
        return answer;
    }
}