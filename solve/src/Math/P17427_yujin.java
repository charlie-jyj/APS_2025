package Math;
import java.io.*;

import java.util.Scanner;

public class P17427_yujin {

    static String samplePath = "/Users/yujin/Documents/APS_2025/solve/src/Math/P17427_input.txt";

    /*
    * 두 자연수 A와 B가 있을 때, A = BC를 만족하는 자연수 C를 A의 약수라고 한다.
    * 예를 들어, 2의 약수는 1, 2가 있고, 24의 약수는 1, 2, 3, 4, 6, 8, 12, 24가 있다.
    * 자연수 A의 약수의 합은 A의 모든 약수를 더한 값이고, f(A)로 표현한다.
    * x보다 작거나 같은 모든 자연수 y의 f(y)값을 더한 값은 g(x)로 표현한다.
    * 자연수 N이 주어졌을 때, g(N)을 구해보자.
    * */
    public static void main(String[] args) throws Exception {
        //Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();

        BufferedReader br = new BufferedReader(new FileReader(samplePath));
        int n = Integer.parseInt(br.readLine());
        new P17427_yujin().solution(n);
    }

    public void solution(int n) {

        /*
        * g(N) = f(1) + f(2) + f(3) + f(4) + f(5) + f(6) + ...
        * 1
        * 1, 2
        * 1, 3
        * 1, 2, 4
        * 1, 5
        * 1, 2, 3, 6
        * = 1*6 + 2*3 + 3*2 + 4*1 + 5*1 + 6*1
        * i * (i 배수의 개수 <= N)
        * */
        //int result = 0;
        long result = 0; // int로 제출해서 틀림ㅋㅋ
        for(int i = 1 ; i<=n ; i++){ // O(N)
            result += i*(n/i);
        }
        System.out.println(result);
    }
}
