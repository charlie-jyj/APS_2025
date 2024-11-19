package BruteForce;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class P3035_사탕게임_yujin {

    static String samplePath = "/Users/yujin/Documents/APS_2025/solve/src/BruteForce/P3035_input.txt";
    /*
    * 상근이는 어렸을 적에 "봄보니 (Bomboni)" 게임을 즐겨했다.
    * 가장 처음에 N×N크기에 사탕을 채워 놓는다.
    * 사탕의 색은 모두 같지 않을 수도 있다.
    * 상근이는 사탕의 색이 다른 인접한 두 칸을 고른다.
    * 그 다음 고른 칸에 들어있는 사탕을 서로 교환한다.
    * 이제, 모두 같은 색으로 이루어져 있는 가장 긴 연속 부분(행 또는 열)을 고른 다음 그 사탕을 모두 먹는다. -> 대각선 고려 X
    * 사탕이 채워진 상태가 주어졌을 때, 상근이가 먹을 수 있는 사탕의 최대 개수를 구하는 프로그램을 작성하시오.
    *
    * 첫째 줄에 보드의 크기 N이 주어진다. (3 ≤ N ≤ 50)
    * 다음 N개 줄에는 보드에 채워져 있는 사탕의 색상이 주어진다. 빨간색은 C, 파란색은 P, 초록색은 Z, 노란색은 Y로 주어진다.
    * 사탕의 색이 다른 인접한 두 칸이 존재하는 입력만 주어진다.
    *
    * 첫째 줄에 상근이가 먹을 수 있는 사탕의 최대 개수를 출력한다.
    *
    * [풀이 계획]
    * n*n 행렬을 선언해서 사탕으로 채운다
    * 2중 반복문을 돌려서 1개의 사탕을 선택하고
    * 반복문 안에서 인접한 사탕과 교환한다. (길찾기라면 상우하좌를 돌겠지만 교환이 목적이니 우하만 교체한다)
    * (i,j) -> 우: (i, j+1), 하: (i+1, j)
    * 교환한 결과가 연속 부분의 최대를 구한다. (초기값 1에서 반복적으로 갱신한다.)
    *
    * */
    public static void main(String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(samplePath));
        int n = Integer.parseInt(br.readLine());
        String[][] candies = new String[n][];
        for (int i = 0; i < n; i++) {
            candies[i] = br.readLine().split("");
        }

        new P3035_사탕게임_yujin().solution(candies, n);
    }

    public static int bomboni(String[][] candies, int startRow, int endRow, int startCol, int endCol) {
        int max_bomboni = 1;

        // 행으로 봄보니
        for(int i = startRow; i <= endRow; i++) {
            int count = 1;
            for(int j = 1; j < candies.length; j++) {
                if(candies[i][j].equals(candies[i][j-1])){
                    count++;
                    max_bomboni = Math.max(max_bomboni, count);
                } else {
                    count = 1; // 연속이 아니면 초기화
                }
            }
        }

        // 열로 봄보니
        for(int j = startCol; j <= endCol; j++) {
            int count = 1;
            for(int i = 1; i < candies.length; i++) {
                if(candies[i][j].equals(candies[i-1][j])){
                    count++;
                    max_bomboni = Math.max(max_bomboni, count);
                } else {
                    count = 1; // 연속이 아니면 초기화
                }
            }
        }
        return max_bomboni;
    }

    public void solution(String[][] candies, int n){
        // 사탕 테스트 출력
//        for(String[] candyRow: candies) {
//            System.out.println(Arrays.toString(candyRow));
//        }

        int answer = 1; // 연속의 최솟값

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){

                // 선택한 캔디를 오른쪽 캔디와 교환
                if(j+1 < n){
                    String temp = candies[i][j];
                    candies[i][j] = candies[i][j+1];
                    candies[i][j+1] = temp;

                    // 바꾼 결과로 몇개의 사탕을 먹을 수 있는지 확인한다. -> 나는 이 부분을 생각을 못했는데 이러면 n^2 만큼 확인해야 해서 O(n^4)
                    // 영향을 받은 행열만 확인하겠다. i행, j열, j+1열 O(n^3)
                    int count = bomboni(candies, i, i, j, j+1);

                    // 최대값 갱신
                    answer = Math.max(count, answer);

                    // 결과 확인 후 원복
                    candies[i][j+1] = candies[i][j];
                    candies[i][j] = temp;
                }

                // 선택한 캔디를 아래의 캔디와 교환
                if(i+1 < n){
                    String temp = candies[i][j];
                    candies[i][j] = candies[i+1][j];
                    candies[i+1][j] = temp;

                    int count =  bomboni(candies, i, i+1, j, j);

                    // 최대값 갱신
                    answer = Math.max(count, answer);

                    // 결과 확인 후 원복
                    candies[i+1][j] = candies[i][j];
                    candies[i][j] = temp;
                }

            }
        } // 반복문 종료

        System.out.println(answer);

    }
}
