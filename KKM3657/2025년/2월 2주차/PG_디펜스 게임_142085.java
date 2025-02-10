import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int round = 0;
        PriorityQueue<Integer> spendN = new PriorityQueue<>((x,y) -> y-x);

        // 우선순위큐
        for(int i=0; i<enemy.length; i++) {
            // 병력 소모
            n -= enemy[i];
            spendN.add(enemy[i]);

            // 병사 수가 부족하면 무적권 사용
            if(n < 0) {
                if(k > 0 && !spendN.isEmpty()) {
                    n += spendN.poll();
                    k--;
                }
                else
                    return round;
            }
            round++;
        }
        return enemy.length;
    }
}