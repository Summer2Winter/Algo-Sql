import java.util.ArrayList;
import java.util.ArrayDeque;

class Data {
    int curr;
    int prev;
    int next;
    boolean delete;

    Data(int curr, int prev, int next) {
        this.curr = curr;
        this.prev = prev;
        this.next = next;
    }
}
class Solution {
    public String solution(int n, int k, String[] cmd) {
        // 리스트
        ArrayList<Data> list = new ArrayList<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i<n; i++) {
            if(i==0) {
                list.add(new Data(i, -1, i+1));
            }
            else if(i==n-1) {
                list.add(new Data(i, i-1, -1));
            }
            else {
                list.add(new Data(i, i-1, i+1));
            }
        }

        // 시작점
        int cx = k;

        for(String str : cmd) {
            String[] temp = str.split(" ");
            String dir = temp[0];
            int value = -1;
            if(str.length() > 1)
                value = Integer.parseInt(temp[1]);

            // 현재 위치
            Data curr = list.get(cx);
            // 방향
            if(dir.equals("U")) {
                for(int i=0; i<value; i++)
                    cx = list.get(cx).prev;
            }
            else if(dir.equals("D")) {
                for(int i=0; i<value; i++)
                    cx = list.get(cx).next;
            }
            // 삭제
            else if(dir.equals("C")) {
                // 현재 위치가 마지막이면 -1 처리
                if(curr.next == -1) {
                    Data prev = list.get(curr.prev);
                    prev.next = -1;
                    cx = curr.prev;
                }
                // 현재 위치가 첫번째일때 처리
                else if(curr.prev == -1) {
                    Data next = list.get(curr.next);
                    next.prev = -1;
                    cx = curr.next;
                }
                else {
                    Data prev = list.get(curr.prev);
                    prev.next = curr.next;

                    Data next = list.get(curr.next);
                    next.prev = curr.prev;
                    cx = curr.next;
                }
                // 삭제 표시
                stack.push(curr.curr);
                curr.delete = true;
            }
            // 복구
            else {
                curr = list.get(stack.pop());
                // 복구한게 마지막이라면
                if(curr.next == -1) {
                    Data prev = list.get(curr.prev);
                    prev.next = curr.curr;
                }
                else if(curr.prev == -1) {
                    Data next = list.get(curr.next);
                    next.prev = curr.curr;
                }
                else {
                    Data prev = list.get(curr.prev);
                    prev.next = curr.curr;
                    Data next = list.get(curr.next);
                    next.prev = curr.curr;
                }
                curr.delete = false;
            }
        }
        // 기록
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++) {
            if(list.get(i).delete)
                sb.append("X");
            else
                sb.append("O");
        }
        return sb.toString();
    }
}