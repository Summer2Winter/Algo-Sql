import java.util.Arrays;

class Solution {
    String[] answer;
    boolean[] visited;
    boolean isCompleted;

    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> a[0].equals(b[0]) ? a[1].compareTo(b[1]) : a[0].compareTo(b[0]));

        visited = new boolean[tickets.length];
        answer = new String[tickets.length + 1];
        answer[0] = "ICN"; // 시작 공항 고정
        isCompleted = false;

        findAnswer("ICN", tickets, 1);
        return answer;
    }

    public void findAnswer(String currPlace, String[][] tickets, int count) {
        // 모든 티켓을 사용한 경우, 종료
        if (count == answer.length) {
            isCompleted = true;
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (visited[i] || !tickets[i][0].equals(currPlace))
                continue;

            visited[i] = true;
            answer[count] = tickets[i][1];
            findAnswer(tickets[i][1], tickets, count + 1);

            // 경로를 찾았으면 더 이상 탐색하지 않음 (불필요한 백트래킹 방지)
            if (isCompleted) return;

            visited[i] = false; // 백트래킹
        }
    }
}
