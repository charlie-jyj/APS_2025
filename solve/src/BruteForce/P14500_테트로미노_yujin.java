package BruteForce;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class P14500_테트로미노_yujin {

    static String samplePath = "/Users/yujin/Documents/APS_2025/solve/src/BruteForce/P14500_input.txt";

    /*
    * 폴리오미노란 크기가 1×1인 정사각형을 여러 개 이어서 붙인 도형이며, 다음과 같은 조건을 만족해야 한다.
    * 정사각형은 서로 겹치면 안 된다.
    * 도형은 모두 연결되어 있어야 한다.
    * 정사각형의 변끼리 연결되어 있어야 한다. 즉, 꼭짓점과 꼭짓점만 맞닿아 있으면 안 된다.
    * "정사각형 4개"를 이어 붙인 폴리오미노는 테트로미노라고 하며, 다음과 같은 5가지가 있다.
    * 아름이는 크기가 N×M인 종이 위에 테트로미노 하나를 놓으려고 한다.
    * 종이는 1×1 크기의 칸으로 나누어져 있으며, 각각의 칸에는 정수가 하나 쓰여 있다.
    * 테트로미노 하나를 적절히 놓아서 테트로미노가 놓인 칸에 쓰여 있는 수들의 합을 최대로 하는 프로그램을 작성하시오.
    * 테트로미노는 반드시 한 정사각형이 정확히 하나의 칸을 포함하도록 놓아야 하며, 회전이나 대칭을 시켜도 된다.
    *
    * 첫째 줄에 종이의 세로 크기 N과 가로 크기 M이 주어진다. (4 ≤ N, M ≤ 500)
    * 둘째 줄부터 N개의 줄에 종이에 쓰여 있는 수가 주어진다.
    * i번째 줄의 j번째 수는 위에서부터 i번째 칸, 왼쪽에서부터 j번째 칸에 쓰여 있는 수이다.
    * 입력으로 주어지는 수는 1,000을 넘지 않는 자연수이다.
    *
    * */
    public static void main(String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(samplePath));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[][] board = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for(int j = 0; j < m; j++){
                board[i][j] = Integer.parseInt(row[j]);
                visited[i][j] = false;
            }
        }


        ArrayList<Integer> result = new ArrayList<>();
        // 여기서 중복이 생기는데.. 어떻게 하면 중복을 제거할 수 있을까?
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int[][] pick = new int[3][2];
                visited[i][j] = true;
                dfs(board, visited, result, i, j, 2, board[i][j], pick);
                visited[i][j] = false;
            }
        }

        int answer = result.stream().mapToInt(Integer::intValue).max().getAsInt();
        System.out.println(answer);
    }

    public static void dfs(int[][] board, boolean[][] visited, ArrayList<Integer> result, int row, int col, int length, int sum, int[][] pick){
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[] now = {row, col};
        pick[length] = now;

        if (length == 0){
            // 3개만 색칠한 상태에서
            // visited가 true인 칸의 상하좌우를 다 뒤져서 최대값을 찾은 후 sum에 더한다. (ㅏ,ㅓ,ㅜ,ㅗ 때문에)
            int localMax = 0;
            for(int[] item: pick){
                    int r = item[0];
                    int c = item[1];
                    for (int[] direction : directions) {
                        int x = r + direction[0];
                        int y = c + direction[1];
                        if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && !visited[x][y]) {
                            localMax = Math.max(localMax, board[x][y]);
                        }
                    }
            }
            result.add(sum+localMax);
            return;
        }

        for(int[] direction : directions){
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if(newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length && !visited[newRow][newCol]){
                visited[newRow][newCol] = true;
                dfs(board, visited, result, newRow, newCol, length-1, sum+board[newRow][newCol], pick);
                visited[newRow][newCol] = false;
            }
        }
    }
}
