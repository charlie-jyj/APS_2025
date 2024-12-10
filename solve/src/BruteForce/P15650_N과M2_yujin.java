package BruteForce;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P15650_N과M2_yujin {

    static String samplePath = "/Users/yujin/Documents/APS_2025/solve/src/BruteForce/P15650_input.txt";

    /*
    * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
    * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
    * 고른 수열은 오름차순이어야 한다.
    * 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
    * 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
    * 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
    *
    * */

    public static void main(String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(samplePath));
        String[] testcase = br.readLine().split(" ");

        // 변수 선언
        int n = Integer.parseInt(testcase[0]);
        int m = Integer.parseInt(testcase[1]);
        boolean[] visited = new boolean[n+1]; // 사용 여부 확인 배열
        int[] current = new int[m]; // 순열 기록 배열
        //System.out.println(n+","+m);

        // 배열 초기화
        Arrays.fill(visited, false);
        Arrays.fill(current, 0);
        new P15650_N과M2_yujin().permutation(0, n, m, visited, new int[m]);
    }

    public static void permutation(int idx, int n, int m, boolean[] visited, int[] current) {
        //System.out.println("current:"+Arrays.toString(current)+" idx:"+idx);

        // 재귀 종료 조건
        if(idx == m) {
            StringBuilder sb = new StringBuilder();
            for (int i : current) {
                sb.append(i).append(" ");
            }
            System.out.println(sb.toString().trim()); // 마지막 공백 제거
            return;
        }

        for(int i=1 ; i < n+1 ; i++ ){
            if(visited[i]){
                continue;
            }

            // 내림차순이면 무시한다.
            if (idx > 0 && current[idx-1] > i) {
                continue;
            }

            visited[i] = true;
            current[idx] = i;
            permutation(idx+1, n, m, visited, current);
            visited[i] = false;
            current[idx] = 0;
        }

    }
}
