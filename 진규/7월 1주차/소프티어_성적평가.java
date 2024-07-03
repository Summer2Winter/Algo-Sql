import java.io.*;
import java.util.*;

public class Main {

    static class Grade implements Comparable<Grade> {

        int idx;
        int grade;

        Grade(int idx, int grade) {
            this.idx = idx;
            this.grade = grade;
        }

        public int compareTo(Grade o) {
            return - (this.grade - o.grade);
        }

        public String toString() {
            return this.idx + " " + this.grade;
        }
    }

    static int N;
    static int[][] grade;
    static int[] sumGrade;
    static int[][] rank;
    
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        
        grade = new int[3][N];
        sumGrade = new int[N];
        rank = new int[4][N];
        
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                grade[i][j] = Integer.parseInt(st.nextToken());
                sumGrade[j] += grade[i][j];
            }
        }

        for (int i = 0; i < 3; i++) {
            calculateRank(grade[i], rank[i]);
        }

        calculateRank(sumGrade, rank[3]);

        answer();
    }

    private static void calculateRank(int[] grade, int[] rank) {

        Grade[] G = new Grade[N];
        for (int i = 0; i < N; i++) {
            G[i] = new Grade(i, grade[i]);
        }
        
        Arrays.sort(G);

        int num = 1; // 등수
        for (int i = 0; i < N; i++) {
            if (i > 0 && G[i].grade == G[i - 1].grade) {
                rank[G[i].idx] = rank[G[i - 1].idx];
            } else {
                rank[G[i].idx] = num;
            }
            num++;
        }        
    }
    private static void answer() {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(rank[i][j] + " ");
            }
            System.out.println();
        }
    }
}
