package Math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class P6588_골드바흐의추측_yujin {

    static String samplePath = "/Users/yujin/Documents/APS_2025/solve/src/Math/P6588_input.txt";
    /*
    * 1742년, 독일의 아마추어 수학가 크리스티안 골드바흐는 레온하르트 오일러에게 다음과 같은 추측을 제안하는 편지를 보냈다.
    * 4보다 큰 모든 짝수는 두 홀수 소수의 합으로 나타낼 수 있다.
    * 예를 들어 8은 3 + 5로 나타낼 수 있고, 3과 5는 모두 홀수인 소수이다.
    * 또, 20 = 3 + 17 = 7 + 13, 42 = 5 + 37 = 11 + 31 = 13 + 29 = 19 + 23 이다.
    * 이 추측은 아직도 해결되지 않은 문제이다.
    * 백만 이하의 모든 짝수에 대해서, 이 추측을 검증하는 프로그램을 작성하시오.
    *
    * 입력은 하나 또는 그 이상의 테스트 케이스로 이루어져 있다. 테스트 케이스의 개수는 100,000개를 넘지 않는다.
    * 각 테스트 케이스는 짝수 정수 n 하나로 이루어져 있다. (6 ≤ n ≤ 1000000)
    * 입력의 마지막 줄에는 0이 하나 주어진다.
    *
    * 각 테스트 케이스에 대해서, n = a + b 형태로 출력한다.
    * 이때, a와 b는 홀수 소수이다. 숫자와 연산자는 공백 하나로 구분되어져 있다.
    * 만약, n을 만들 수 있는 방법이 여러 가지라면, b-a가 가장 큰 것을 출력한다.
    * 또, 두 홀수 소수의 합으로 n을 나타낼 수 없는 경우에는 "Goldbach's conjecture is wrong."을 출력한다.
    *
    * [풀이 계획]
    * 10만 이하의 소수를 모두 구하겠다.
    * 그 소수를 순회하면서 n - a 를 하고 그 값이 소수이면 출력하고 끝.
    *
    * */

    static int MAX = 1000000;

    public static void main(String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(samplePath));

        // 에라토스테네스의 체, 1000000까지
        boolean[] judge = new boolean[MAX+1];
        Arrays.fill(judge, true);
        judge[0] = false;
        judge[1] = false;
        for (int i = 2; i*i <= MAX; i++) {
            for(int j = i*i; j <= MAX; j+=i){
                judge[j] = false;
            }
        }

        // judge에서 true인 소수를 List에 추가
        ArrayList<Integer> primes = new ArrayList<>();
        for(int i = 2; i <= MAX; i++){
            if(judge[i]){
                primes.add(i);
            }
        }

        int n;
        while((n = Integer.parseInt(br.readLine())) > 0){
            new P6588_골드바흐의추측_yujin().solution(n, primes, judge);
        }
    }

    public void solution(int n, ArrayList<Integer> primes, boolean[] judge) {
        for(int i = 0; i < primes.size(); i++){
            if(judge[n-primes.get(i)]){
                System.out.println(n + " = " + primes.get(i) + " + " + (n-primes.get(i)));
                break;
            }
        }
    }
}
