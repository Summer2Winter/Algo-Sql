// 1차 시도 => 단순 BFS 시간 초과 발생
// 모든 경우의 수를 고려해야 하지 않을까?
// 트리 구조로 완전 탐색을 해야 할 것 같은데
// 최소 넓이를 구하는 거니까 백트래킹 조건도 없고
// 그냥 bfs로 때려야 하지 않을까

// int area = 10000*10000 + 1 로 두고 시작을 하면
// 입력 배열 과 해당 배열 길이를 전역으로 올리고
// bfs(현재 가로 w, 현재 세로 h, 현재 인덱스 i)로 하고
// 현재 인덱스 i를 탐색해서 현재 명함의 가로 세로를 불러오고
// 1번 bfs 가로 세로 그대로 크기 비교해서 최대값 갱신 후 i+1
// 2번 bfs 세로 가로 바궈서 크기 비교해서 최대값 갱신 후 i+1
// i가 입력 배열 길이랑 같아 지면 정지하고 area와 비교 후 갱신
// import java.util.*;
// class Solution {
//     static int length;
//     static int[][] input;
//     static int areaMin;
//     public int solution(int[][] sizes) {
//         input = sizes;
//         areaMin = 10000*10000+1;
//         length = sizes.length;
//         bfs(0,0,0);
//         return areaMin;
//     }
    
//     public void bfs(int w, int h, int i){
//         if(i != length ){
//             int tmpW = input[i][0];
//             int tmpH = input[i][1];
//             // 1번 bfs
//             bfs(Math.max(w,tmpW), Math.max(h,tmpH), i+1);
//             // 2번 bfs
//             bfs(Math.max(w,tmpH), Math.max(h,tmpW), i+1);
//         }else{
//             int area = w*h;
//             areaMin = Math.min(area, areaMin);
//         }
//     }
// }
// 2차시도 카드 가로 세로 중 한 쪽의 길이가 항상 길거나 같게 설정 => 통과
class Solution {
    public int solution(int[][] sizes) {
        int maxW = 0;
        int maxH = 0;
        for (int[] card : sizes) {
            int w = Math.max(card[0], card[1]);
            int h = Math.min(card[0], card[1]);
            maxW = Math.max(maxW, w);
            maxH = Math.max(maxH, h);
        }
        return maxW * maxH;
    }
}
