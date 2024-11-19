package Math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class P1929_소수구하기_yujin {

    static String samplePath = "/Users/yujin/Documents/APS_2025/solve/src/Math/P1929_input.txt";

    /*
    *
    * M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
    * 첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.
    * 한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
    *
    * [풀이 계획]
    * 에라토스테네스의 체로 N까지의 소수 여부를 기록하고 M~N을 순회하면서 true/false를 반환하고 true이면 출력하자.
    *
    * */

    public static void main(String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(samplePath));
        String[] testcase = br.readLine().split(" ");
        int N = Integer.parseInt(testcase[0]);
        int M = Integer.parseInt(testcase[1]);
        new P1929_소수구하기_yujin().solution(N, M);
    }

    public void solution(int n, int m){
        // 에라토스테네스의 체를 구현해보아요.
        boolean[] judge = new boolean[m + 1]; // 소수이면 true, 소수가 아니면 false
        Arrays.fill(judge, true);

        // 0, 1은 소수가 아니잖아요.
        judge[0] = false;
        judge[1] = false;

        // judge를 순회하면서 가장 먼저 만나게되는 true는 소수이다.
        // 그 소수의 배수를 judge에서 제거한다.
        for(int i = 2; i*i <= m; i++){
            if (judge[i]) { // 소수이면

                //for (int j = i * i; j <= m; j += i) {
                // 이렇게 쓴 사람이 있더라구? i+i 보다 작은 배수는 이미 나보다 작은 숫자의 배수에서 처리되었기 때문에 반복문을 덜 돌릴 수 있겠다.
                for(int j = 2; i*j <= m; j++){
                    judge[i*j] = false;
//                    judge[j] = false;
                }
            }
        }

        for(int i = n; i <= m; i++){
            if(judge[i]){
                System.out.println(i);
            }
        }
    }
}
