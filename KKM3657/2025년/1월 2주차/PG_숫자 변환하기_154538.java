import java.util.ArrayDeque;

class Number {
    int number;
    int cnt;

    Number(int number, int cnt) {
        this.number = number;
        this.cnt = cnt;
    }
}
class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;

        ArrayDeque<Number> q = new ArrayDeque<>();
        boolean[] visited = new boolean[y+1];
        visited[x] = true;
        q.add(new Number(x, 0));

        // BFS
        while(!q.isEmpty()) {
            Number curr = q.poll();
            int now = curr.number;

            //정답인 경우
            if(now == y) {
                return curr.cnt;
            }

            // 3배
            if(now * 3 <= y && !visited[now * 3]) {
                visited[now * 3] = true;
                q.add(new Number(now * 3, curr.cnt+1));
            }

            // 3배
            if(now * 2 <= y && !visited[now * 2]) {
                visited[now * 2] = true;
                q.add(new Number(now * 2, curr.cnt+1));
            }

            // +n
            if(now + n <= y && !visited[now + n]) {
                visited[now + n] = true;
                q.add(new Number(now + n, curr.cnt+1));
            }
        }
        return -1;
    }
}