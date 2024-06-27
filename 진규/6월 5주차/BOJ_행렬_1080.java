import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] board, tmpBoard;

    static StringTokenizer st;
    static String str;
    static int answer;

    public static void main(String[] args) throws Exception {

        //System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        tmpBoard = new int[N][M];
        for (int i = 0; i < N; i++) {

            str = br.readLine();
            for (int j = 0; j < M; j++) {

                board[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }
        for (int i = 0; i < N; i++) {

            str = br.readLine();
            for (int j = 0; j < M; j++) {

                tmpBoard[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        for (int i = 0; i < N-2; i++) {
            for (int j = 0; j < M-2; j++) {

                if (board[i][j] != tmpBoard[i][j]) {
                    reverse(i, j);
                    answer += 1;
                }
            }
        }

        System.out.println(check() ? answer : -1);
    }

    private static void reverse(int x, int y) {

        for (int i = x; i < x+3; i++) {
            for (int j = y; j < y+3; j++) {

                board[i][j] = 1 - board[i][j];
            }
        }
    }

    private static boolean check() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (board[i][j] != tmpBoard[i][j])
                    return false;
            }
        }

        return true;
    }
}