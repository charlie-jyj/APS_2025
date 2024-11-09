package Math;

import java.io.BufferedReader;
import java.io.FileReader;

/*
* 2와 5로 나누어 떨어지지 않는 정수 n(1 ≤ n ≤ 10000)가 주어졌을 때, 각 자릿수가 모두 1로만 이루어진 n의 배수를 찾는 프로그램을 작성하시오.
* 나머지와 관련한 문제는 모듈러 연산을 고려해봐야 한다.
* 나눠야하는 수가 길면 O(1) 이 아니라 O(N)이 됨
*
* */

public class P4375_yujin {

    static String samplePath = "/Users/yujin/Documents/APS_2025/solve/src/Math/P4375_input.txt";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(samplePath));
        String testcase = "";
        while ((testcase = br.readLine()) != null) {
            new P4375_yujin().solution(Integer.parseInt(testcase));
        }
    }

    public void solution(int N) {

        /*
        * 아래의 방식 대로 풀면 Long 타입 길이 제한 때문에 NumberException
        * -> 배수를 실제로 만들지 않는 방향으로 생각해야 함.
        * */
//        String target = "";
//        while (true) {
//            target = target + "1";
//            if (Long.parseLong(target)%N == 0) {
//                flag = false;
//            }
//        }
//        System.out.println(target.length());

        int length = 0;
        int remainder = 0;

        /*
        * for(int i = 1;;i++)
        * */
        while(true) {
            length++;
            remainder = ((remainder * 10) % N + 1 % N) % N;
            if (remainder == 0) {
                break;
            }
        }
        System.out.println(length);
    }
}
