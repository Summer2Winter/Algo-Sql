import java.util.ArrayList;
class Solution {
    int n, answer = 0;
    String[] arr;
    boolean[] visited = new boolean[10000000];
    boolean[] selected;
    ArrayList<String> list = new ArrayList<>();
    public int solution(String numbers) {
        arr = numbers.split("");
        n = arr.length;
        selected = new boolean[n];
        findAnswer(0);
        return answer;
    }

    public void findAnswer(int curr) {
        // 소수판별
        if(!list.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for(String str : list)
                sb.append(str);
            int value = Integer.parseInt(sb.toString());
            if(!visited[value] && isPrime(value)) {
                answer++;
            }
            visited[value] = true;
        }

        for(int i=0; i<n; i++) {
            if(selected[i])
                continue;
            // 선택
            selected[i] = true;
            list.add(arr[i]);
            findAnswer(curr+1);

            // 비선택
            selected[i] = false;
            list.remove(list.size()-1);
        }
    }
    public boolean isPrime(int value) {
        if(value <= 1)
            return false;
        for(int i=2; i * i <= value; i++) {
            if(value % i == 0)
                return false;
        }
        return true;
    }
}