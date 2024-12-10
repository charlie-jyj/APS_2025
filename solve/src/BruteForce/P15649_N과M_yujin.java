package BruteForce;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class P15649_N과M_yujin {

    static String samplePath = "/Users/yujin/Documents/APS_2025/solve/src/BruteForce/P15649_input.txt";

    /*
    *
    * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
    * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
    * 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
    * 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
    * 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
    *
    * */
    public static void main(String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(samplePath));
        String[] testcase = br.readLine().split(" ");
        int N = Integer.parseInt(testcase[0]);
        int M = Integer.parseInt(testcase[1]);
        new P15649_N과M_yujin().solution(N, M);
    }

    public void solution(int n, int m) {

        // 1~N으로 배열 만들기 (오름차순)
        // 내림차순이라면
        int[] numbers = new int[n];
        //for(int i = n-1; i >= 0; i--) {
        for(int i = 0; i < n; i++) {
            System.out.println(i+1);
            numbers[i] = i+1;
            //numbers[n-1-i] = i+1;
        }
        System.out.println(Arrays.toString(numbers));

        // visited 배열 만들기
        int[] visited = new int[n];
        Arrays.fill(visited, 0);

        // 재귀 호출
        findTarget(numbers, new ArrayList<Integer>(), m, visited);
    }

    public void findTarget(int[] numbers, ArrayList<Integer> selected, int targetLength, int[] visited) {
        // 완성 조건 selected 의 길이가 targetLength와 같을 때 출력한다.
        if(selected.size() == targetLength) {
            for(int i = 0; i < targetLength; i++) {
                if(i == targetLength-1){
                    System.out.print(selected.get(i));
                } else {
                    System.out.print(selected.get(i) + " ");
                }
            }
            System.out.print("\n");
            return;
        }

        // 더 고를 수 있는 숫자가 없을 때
        int selectable = Arrays.stream(visited).filter(v-> v==0).toArray().length;
        if(selectable == 0) return;

        // numbers를 작은 숫자에서부터 하나하나 순회하면서 사용하지 않은 숫자를 찾겠어요
        for(int i = 0; i < numbers.length; i++) {
            if(visited[i] == 0){
                visited[i] = 1;
                selected.add(numbers[i]);
                findTarget(numbers, selected, targetLength, visited);

                // 원복
                visited[i] = 0;
                selected.remove(selected.size()-1);
            }
        }
    }
}
