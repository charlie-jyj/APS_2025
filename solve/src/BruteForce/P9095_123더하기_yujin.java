package BruteForce;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class P9095_123더하기_yujin {

    static String samplePath = "/Users/yujin/Documents/APS_2025/solve/src/BruteForce/P9095_input.txt";

    /*
    * 정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.
    * 1+1+1+1
    * 1+1+2
    * 1+2+1
    * 2+1+1
    * 2+2
    * 1+3
    * 3+1
    * 정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
    * 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. n은 양수이며 11보다 작다.
    * 각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 출력한다.
    *
    * [풀이 계획]
    * 재귀 함수를 사용해보겠다.
    * */

    public static void main(String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(samplePath));
        int testCases = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCases; i++) {
            int n = Integer.parseInt(br.readLine());
            new P9095_123더하기_yujin().solution(n);
        }
    }

    public void solution(int n) {
        int[] numbers = {1, 2, 3};
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        sum123(numbers, n, n, new ArrayList<>(), result);
        System.out.println(result.size());
    }

    public void sum123(int[] numbers, int n, int remain, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result) {
        if (remain == 0){
            result.add(current);
            return;
        }

        if(remain < 0) {
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            current.add(numbers[i]);
            sum123(numbers, n, remain-numbers[i], current, result);
            current.remove(current.size()-1);
        }
    }
}
