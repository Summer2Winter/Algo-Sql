import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        // 이중 우선순위 큐
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());

        for(String command : operations) {
            String[] temp = command.split(" ");
            if(temp[0].equals("I")) {
                pq1.add(Integer.parseInt(temp[1]));
                pq2.add(Integer.parseInt(temp[1]));
            }
            else if(temp[0].equals("D")) {
                if(pq1.isEmpty())
                    continue;
                if(Integer.parseInt(temp[1]) == 1) {
                    int max = pq2.poll();
                    pq1.remove(max);
                }
                else {
                    int min = pq1.poll();
                    pq2.remove(min);
                }
            }
        }
        if(pq1.isEmpty())
            answer = new int[2];
        else {
            answer[0] = pq2.poll();
            answer[1] = pq1.poll();
        }

        return answer;
    }
}