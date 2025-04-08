import java.io.*;
import java.util.*;
class Command {
    char command;
    int distance;

    Command(char command, int distance) {
        this.command = command;
        this.distance = distance;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int aCnt = Integer.parseInt(st.nextToken());
        int bCnt = Integer.parseInt(st.nextToken());

        // 명령 순서
        Command[] aCommand = new Command[aCnt];
        Command[] bCommand = new Command[bCnt];

        int maxTime = 0;
        for(int i=0; i<aCnt; i++) {
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int temp = Integer.parseInt(st.nextToken());
            aCommand[i] = new Command(c, temp);
            maxTime += temp;
        }

        for(int i=0; i<bCnt; i++) {
            st = new StringTokenizer(br.readLine());
            bCommand[i] = new Command(st.nextToken().charAt(0), Integer.parseInt(st.nextToken()));
        }

        // 시간에 해당하는 거리 기록
        int[] aCurr = new int[maxTime+1], bCurr = new int[maxTime+1];
        int cA = 0, cB = 0;
        // A가 움직인 거리 기록
        int time = 1, idx = 0;
        while(time <= maxTime) {
            Command curr = aCommand[idx];
            // a 이동
            int temp = 0;
            while(time <= maxTime && temp++ < curr.distance) {
                int value = curr.command == 'R' ? 1 : -1;
                int nA = cA + value;
                aCurr[time++] = nA;
                cA = nA;
            }
            idx = (idx+1) % aCnt;
        }

        // B가 움직인 거리 기록
        time = 1;
        idx = 0;
        while(time <= maxTime) {
            Command curr = bCommand[idx];
            // a 이동
            int temp = 0;
            while(time <= maxTime && temp++ < curr.distance) {
                int value = curr.command == 'R' ? 1 : -1;
                int nB = cB + value;
                bCurr[time++] = nB;
                cB = nB;
            }
            idx = (idx+1) % bCnt;
        }
        long answer = -1;
        for(int i=1; i<=maxTime; i++) {
            if(aCurr[i] == bCurr[i]) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}