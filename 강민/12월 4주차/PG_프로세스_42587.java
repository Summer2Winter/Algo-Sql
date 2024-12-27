import java.util.ArrayDeque;

class Solution {
    int[] priority = new int[10];
    public int solution(int[] priorities, int location) {
        int answer = 0;

        // 1-9까지 우선 순위 현황
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int idx = 0;
        for(int number : priorities){
            priority[number]++;
            queue.add(idx++);
        }

        //큐
        int time = 1;
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            // 현재보다 높은 우선 순위가 없다면
            if(isHigher(priorities, priorities[curr])) {
                if(curr == location)
                    return time;
                else
                    time++;
                priority[priorities[curr]]--;
            }
            else
                queue.add(curr);
        }
        return time;
    }
    // 우선순위 판별
    public boolean isHigher(int[] priorities, int value) {
        for(int i=9; i>value; i--) {
            if(priority[i] != 0)
                return false;
        }
        return true;
    }
}