package Math;

import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1978_yujin {

    static String samplePath = "/Users/yujin/Documents/APS_2025/solve/src/Math/P1978_input.txt";

    /*
    *
    * 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
    * 첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
    * 주어진 수들 중 소수의 개수를 출력한다.
    *
    * [풀이 계획]
    * 소수: 1과 자기 자신으로만 나누어지는 수
    * 루트n 까지 순회해서 나누어지는 수가 있으면 소수라고 판단
    * */
    public static void main(String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(samplePath));
        int length = Integer.parseInt(br.readLine());
        int[] testcase = testcase = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        new P1978_yujin().solution(length, testcase);
    }

    public void solution(int length, int[] testcase) {
        int count = length;
        for(int number : testcase){

            if(number <= 1){ // 1은 소수가 아님
                count--;
                continue;
            }

            for(int i = 2 ; i*i <= number ; i++){
                if (number % i == 0) {
                    count--;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
