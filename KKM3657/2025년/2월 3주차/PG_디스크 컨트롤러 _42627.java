import java.util.PriorityQueue;
import java.util.Arrays;

class Job implements Comparable<Job> {
    int number;
    int inTime;
    int work;

    Job(int number, int inTime, int work) {
        this.number = number;
        this.inTime = inTime;
        this.work = work;
    }

    @Override
    public int compareTo(Job j) {
        if(this.work != j.work)
            return this.work - j.work;
        else if(this.inTime != j.inTime)
            return this.inTime - j.inTime;
        else
            return this.number - j.number;
    }
}
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;

        // 대기 큐
        PriorityQueue<Job> pq = new PriorityQueue<>();

        // 작업 정렬
        Arrays.sort(jobs, (x,y) -> x[0]==y[0] ? x[1]-y[1] : x[0]-y[0]);

        int time = 0, i = 0;
        while(i < jobs.length) {
            // 작업 넣기
            while(i < jobs.length && time >= jobs[i][0]) {
                pq.add(new Job(i,jobs[i][0],jobs[i][1]));
                i++;
            }
            // 작업이 빈 경우 시간 경과
            if(pq.isEmpty()) {
                time++;
                continue;
            }
            // 작업 실행
            Job curr = pq.poll();
            // 작업 종료시간
            time += curr.work;
            answer += time - curr.inTime;
        }

        // 남은 작업 처리
        while(!pq.isEmpty()) {
            // 작업 실행
            Job curr = pq.poll();
            // 작업 종료시간
            time += curr.work;
            answer += time - curr.inTime;
        }

        return answer / jobs.length;
    }
}