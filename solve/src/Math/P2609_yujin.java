package Math;

import java.io.BufferedReader;
import java.io.FileReader;

/*
* 두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
* */
public class P2609_yujin {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("/Users/yujin/Documents/APS_2025/solve/src/Math/P2609_input.txt"));
        String[] testcase = br.readLine().split(" ");
        int a = Integer.parseInt(testcase[0]);
        int b = Integer.parseInt(testcase[1]);
        new P2609_yujin().solution(a, b);
    }

    public void solution(int a, int b) {

        int greatCommonDivisor = gcd(Math.max(a,b), Math.min(a,b));
        int leastCommonMultiple = a*b/greatCommonDivisor;
        System.out.println(greatCommonDivisor);
        System.out.println(leastCommonMultiple);
    }

    // 최대 공약수
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b); // a> b 일 때, a,b의 최대공약수는 b,r의 최대공약수와 같다. (유클리드 호제법)
    }
}
