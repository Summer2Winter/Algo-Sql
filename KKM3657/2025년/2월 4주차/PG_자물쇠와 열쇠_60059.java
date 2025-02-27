import java.util.*;

class Solution {
    int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};

    public boolean solution(int[][] key, int[][] lock) {
        int M = key.length;
        int N = lock.length;

        // 3배 크기의 확장된 자물쇠 배열 생성
        int[][] extendedLock = new int[N * 3][N * 3];

        // 원본 자물쇠를 중앙에 배치
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                extendedLock[i + N][j + N] = lock[i][j];
            }
        }

        // 모든 위치에서 key를 이동하며 맞는지 확인
        for (int r = 0; r < 4; r++) { // 4번 회전
            key = rotate(key); // key 회전

            for (int x = 0; x < N * 2; x++) {
                for (int y = 0; y < N * 2; y++) {
                    if (check(extendedLock, key, x, y, N)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // key를 회전하는 함수 (90도 회전)
    private int[][] rotate(int[][] key) {
        int M = key.length;
        int[][] rotated = new int[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                rotated[j][M - 1 - i] = key[i][j];
            }
        }
        return rotated;
    }

    // key를 특정 위치(x, y)에 두고 lock과 맞는지 확인
    private boolean check(int[][] extendedLock, int[][] key, int x, int y, int N) {
        int[][] tempLock = deepCopy(extendedLock);
        int M = key.length;

        // key를 tempLock에 추가
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                tempLock[x + i][y + j] += key[i][j];
            }
        }

        // 자물쇠 영역만 검사하여 맞는지 확인
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tempLock[i + N][j + N] != 1) { // 반드시 1이어야 함 (0은 채워지고, 2는 겹침)
                    return false;
                }
            }
        }
        return true;
    }

    // 배열 복사
    private int[][] deepCopy(int[][] arr) {
        int M = arr.length;
        int[][] copy = new int[M][M];
        for (int i = 0; i < M; i++) {
            System.arraycopy(arr[i], 0, copy[i], 0, M);
        }
        return copy;
    }
}
