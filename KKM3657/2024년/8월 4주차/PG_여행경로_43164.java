import java.util.ArrayList;
import java.util.Arrays;

// 백 트래킹
class Solution {
    int N;
    boolean[] visited;
    String[][] tickets;
    ArrayList<String> list = new ArrayList<>();
    public String[] solution(String[][] arr) {
        String[] answer = {};
        tickets = arr;
        N = tickets.length;
        visited = new boolean[N];
        Arrays.sort(tickets, (x,y) -> {
            return x[0].equals(y[0]) ? x[1].compareTo(y[1]) : x[0].compareTo(y[0]);
        });
        list.add("ICN");
        // 인천에서 시작
        for(int i=0; i<N; i++) {
            String[] ticket = tickets[i];
            if(!visited[i] && ticket[0].equals("ICN")) {
                visited[i] = true;
                list.add(ticket[1]);
                // 정답인 경우
                if(dfs(ticket[1], 1)) {
                    answer = new String[list.size()];
                    for(int j=0; j<list.size(); j++) {
                        answer[j] = list.get(j);
                    }
                    return answer;
                }
                list.remove(1);
                visited[i] = false;
            }
        }
        return answer;
    }
    public boolean dfs(String place, int curr) {
        // 기저 조건 - 전부 순회한 경우
        if(curr == N) {
            return true;
        }

        for(int i=0; i<N; i++) {
            if(!visited[i] && place.equals(tickets[i][0])) {
                visited[i] = true;
                list.add(tickets[i][1]);
                if(dfs(tickets[i][1], curr+1))
                    return true;
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
        return false;
    }
}