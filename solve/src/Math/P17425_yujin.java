package Math;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/*
* 두 자연수 A와 B가 있을 때, A = BC를 만족하는 자연수 C를 A의 약수라고 한다.
* 예를 들어, 2의 약수는 1, 2가 있고, 24의 약수는 1, 2, 3, 4, 6, 8, 12, 24가 있다.
* 자연수 A의 약수의 합은 A의 모든 약수를 더한 값이고, f(A)로 표현한다.
* x보다 작거나 같은 모든 자연수 y의 f(y)값을 더한 값은 g(x)로 표현한다.
* 자연수 N이 주어졌을 때, g(N)을 구해보자.
* T(1 <= T <= 100,000)
*
* 첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 100,000)가 주어진다.
* 둘째 줄부터 테스트 케이스가 한 줄에 하나씩 주어지며 자연수 N(1 ≤ N ≤ 1,000,000)이 주어진다.
* 각각의 테스트 케이스마다, 한 줄에 하나씩 g(N)를 출력한다.
* 17425를 푸는 방식 대로 하면, N*T= 100,000 * 1,000,000 = 1,000억
* 시간초과를 피하는 방법? T가 큰게 문제이다.
* 약수의 총합을 17427보다 최적화 + g(N)을 memorize 해서 중복을 피하기
*
* */
public class P17425_yujin {

    public static int MAX = 1000000;

    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("/Users/yujin/Documents/APS_2025/solve/src/Math/P17425_input.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] divisor = new long[MAX+1];
        // 약수는 무조건 1을 가지기 때문에 1로 초기화
        divisor = Arrays.stream(divisor).map(d->1).toArray();

        // 약수의 합을 각각 구한다. O(N^2) = 10,000,000,000
        for (int i = 2; i <= MAX; i++) {
            for (int j = 1; i*j <= MAX; j++) {
                divisor[i*j] += i; // divisor[i의 배수]는 i를 약수로 가짐을 이용한다.
            }
        }

        // g(N)을 구한다 g(1), g(2) O(N) + T*O(1)
        long[] memo = new long[MAX+1];
        memo[0] = 0;
        for(int i=1; i<=MAX; i++){
            memo[i] = memo[i-1] + divisor[i]; // 누적합
        }

        int testcase = Integer.parseInt(br.readLine());
        while (testcase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            bw.write(memo[n] + "\n");
        }
        bw.flush();
    }
}
