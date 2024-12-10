package BruteForce;

import java.io.BufferedReader;
import java.io.FileReader;

public class P1748_수이어쓰기_yujin {
    static String samplePath = "/Users/yujin/Documents/APS_2025/solve/src/BruteForce/P1748_input.txt";

    /*
    * 1부터 N까지의 수를 이어서 쓰면 다음과 같이 새로운 하나의 수를 얻을 수 있다.
    * 1234567891011121314151617181920212223...
    * 이렇게 만들어진 새로운 수는 몇 자리 수일까? 이 수의 자릿수를 구하는 프로그램을 작성하시오.
    * 첫째 줄에 N(1 ≤ N ≤ 100,000,000)이 주어진다.
    * 첫째 줄에 새로운 수의 자릿수를 출력한다.
    *
    * [풀이 계획]
    * 1~9(10^1-1): 1자리, 10~99(10^2-1): 2자리 100~999(10^3-1):3자리
    * 실제로 수를 만들지 않아도 몇 자리인지는 구할 수 있을 것 같다.
    * 다만 n이 어느 구간의 숫자인지를 알고 싶은데.
    * n이 몇자리인지 아는 방법? String으로 변환하면?
    *
    * */

    public static void main(String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(samplePath));
        int answer = 0;
        String nString = br.readLine();
        int n = Integer.parseInt(nString);
        int nLength = nString.length();
        answer += (n - Math.pow(10, nLength - 1) + 1) * nLength;
        for (int i = 1; i < nLength; i++) {
            answer += (Math.pow(10, i) - Math.pow(10, i-1))*i;
        }
        System.out.println(answer);
    }
}
