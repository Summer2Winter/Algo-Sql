import java.io.*;
import java.util.*;

class Command {
    int time;
    String command;

    Command(int time, String command) {
        this.time = time;
        this.command = command;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] currA = new int[1_000_002];
        int[] currB = new int[1_000_002];

        int currX = 0, timeA = 1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            String c = st.nextToken();

            // 왼쪽 이동
            for(int j = 0; j<t; j++) {
                // 현재 위치 이동
                if(c.equals("R"))
                    currX += 1;
                else
                    currX -= 1;
                currA[timeA++] = currX;
            }
        }

        int currY = 0, timeB = 1;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            String c = st.nextToken();

            // 왼쪽 이동
            for(int j = 0; j<t; j++) {
                // 현재 위치 이동
                if(c.equals("R"))
                    currY += 1;
                else
                    currY -= 1;
                currB[timeB++] = currY;
            }
        }

        for(int i=timeA; i<=1_000_000; i++) {
            currA[i] = currA[i-1];
        }
        for(int i=timeB; i<=1_000_000; i++) {
            currB[i] = currB[i-1];
        }

        // 같은지 확인
        int end = Math.max(timeA, timeB);
        int answer = 0;
        for(int i=1; i<end; i++) {
            if(currA[i-1] != currB[i-1] && currA[i] == currB[i])
                answer++;
        }
        System.out.println(answer);
    }
}