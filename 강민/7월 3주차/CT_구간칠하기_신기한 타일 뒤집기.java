import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int L = -1;
    static int R = 1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] area = new int[100001];
        int white = 1, black = 2;
        int wc = 0, bc = 0;
        int idx = 50000;

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int value = Integer.parseInt(st.nextToken());
            String cmd = st.nextToken();
            if(cmd.equals("L")) {
                // 현재 위치 기준 변경
                for(int j=1; j<=value; j++) {
                    if(area[idx] == black)
                        bc--;
                    else if(area[idx] == white)
                        wc--;
                    area[idx] = 1;
                    wc++;
                    if(j != value)
                        idx++;
                }
            }
            else {
                for(int j=1; j<=value; j++) {
                    if(area[idx] == white)
                        wc--;
                    else if(area[idx] == black)
                        bc--;
                    area[idx] = 2;
                    bc++;
                    if(j != value)
                        idx--;
                }
            }
            // System.out.println(idx + " " + wc + " " + bc);
        }
        System.out.println(wc + " " + bc);
    }
}