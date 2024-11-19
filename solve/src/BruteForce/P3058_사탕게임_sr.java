package BruteForce;

import java.util.Scanner;

public class P3058_사탕게임_sr {
    // 최대 연속된 사탕의 개수를 구하는 함수
    public static int maxCandy(char[][] board, int N) {
        int maxCount = 1;  // 최대 개수 초기화

        // 각 행과 열에서 연속된 사탕의 최대 개수 계산
        for (int i = 0; i < N; i++) {
            int rowCount = 1;  // 행의 연속된 사탕 개수
            int colCount = 1;  // 열의 연속된 사탕 개수

            for (int j = 1; j < N; j++) {
                // 행에서 연속된 사탕 계산
                if (board[i][j] == board[i][j - 1]) {
                    rowCount++;
                } else {
                    maxCount = Math.max(maxCount, rowCount);
                    rowCount = 1;
                }

                // 열에서 연속된 사탕 계산
                if (board[j][i] == board[j - 1][i]) {
                    colCount++;
                } else {
                    maxCount = Math.max(maxCount, colCount);
                    colCount = 1;
                }
            }

            // 마지막으로 갱신
            maxCount = Math.max(maxCount, rowCount);
            maxCount = Math.max(maxCount, colCount);
        }

        return maxCount;
    }

    // 모든 교환을 시도하여 최대 사탕 개수를 구하는 함수
    public static int candyGame(char[][] board, int N) {
        int maxCandies = 1;  // 전체 최대 개수 초기화

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 오른쪽 칸과 교환
                if (j + 1 < N) {
                    // 교환
                    char temp = board[i][j];
                    board[i][j] = board[i][j + 1];
                    board[i][j + 1] = temp;

                    // 최대 사탕 개수 갱신
                    maxCandies = Math.max(maxCandies, maxCandy(board, N));

                    // 복구
                    board[i][j + 1] = board[i][j];
                    board[i][j] = temp;
                }

                // 아래쪽 칸과 교환
                if (i + 1 < N) {
                    // 교환
                    char temp = board[i][j];
                    board[i][j] = board[i + 1][j];
                    board[i + 1][j] = temp;

                    // 최대 사탕 개수 갱신
                    maxCandies = Math.max(maxCandies, maxCandy(board, N));

                    // 복구
                    board[i + 1][j] = board[i][j];
                    board[i][j] = temp;
                }
            }
        }

        return maxCandies;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 보드 크기 입력
        int N = sc.nextInt();
        sc.nextLine();  // 개행 문자 처리

        // 보드 입력
        char[][] board = new char[N][N];
        for (int i = 0; i < N; i++) {
            board[i] = sc.nextLine().toCharArray();
        }

        // 결과 출력
        System.out.println(candyGame(board, N));

        sc.close();
    }
}
