package BruteForce;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class P1476_날짜계산_yujin {

    static String samplePath = "/Users/yujin/Documents/APS_2025/solve/src/BruteForce/P1476_input.txt";

    /*
    * 준규가 사는 나라는 우리가 사용하는 연도와 다른 방식을 이용한다.
    * 준규가 사는 나라에서는 수 3개를 이용해서 연도를 나타낸다. 각각의 수는 지구, 태양, 그리고 달을 나타낸다.
    * 지구를 나타내는 수를 E, 태양을 나타내는 수를 S, 달을 나타내는 수를 M이라고 했을 때, 이 세 수는 서로 다른 범위를 가진다.
    * (1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19)
    * 우리가 알고있는 1년은 준규가 살고있는 나라에서는 1 1 1로 나타낼 수 있다.
    * 1년이 지날 때마다, 세 수는 모두 1씩 증가한다.
    * 만약, 어떤 수가 범위를 넘어가는 경우에는 1이 된다.
    * 예를 들어, 15년은 15 15 15로 나타낼 수 있다.
    * 하지만, 1년이 지나서 16년이 되면 16 16 16이 아니라 1 16 16이 된다. 이유는 1 ≤ E ≤ 15 라서 범위를 넘어가기 때문이다.
    * E, S, M이 주어졌고, 1년이 준규가 사는 나라에서 1 1 1일때,
    * 준규가 사는 나라에서 E S M이 우리가 알고 있는 연도로 몇 년인지 구하는 프로그램을 작성하시오.
    * 첫째 줄에 세 수 E, S, M이 주어진다. 문제에 나와있는 범위를 지키는 입력만 주어진다.
    * 첫째 줄에 E S M으로 표시되는 가장 빠른 연도를 출력한다. 1 1 1은 항상 1이기 때문에, 정답이 음수가 나오는 경우는 없다.
    *
    *
    * */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(samplePath));
        String testcase = "";
        while((testcase = br.readLine()) != null){
            int[] tokens = Arrays.stream(testcase.split(" ")).mapToInt(Integer::parseInt).toArray();
            new P1476_날짜계산_yujin().solution(tokens);
        }
    }

    public void solution(int[] tokens) {
        int e = tokens[0];
        int s = tokens[1];
        int m = tokens[2];

        // 아래와 같이 풀었더니 테스트케이스4 에서 시간 초과가 나버린다.
        // 아래 방법을 활용하는 방법 e,s,m 에서 1씩 빼주고 나머지로 계산하고
        // 1작은 수를 답으로 구했으니 마지막에 +1 할 것
//        int result = 1;
//        while(true){
//            System.out.println("processing:" + result);
//            if (result%15 == e && result%28 == s && result%19 == m) {
//                System.out.println("answer:" + result);
//                break;
//            }
//            result++;
//        }

        int[] E = new int[15];
        for(int i=0; i<15; i++){
            E[i] = i+1;
        }

        int[] S = new int[28];
        for(int i=0; i<28; i++){
            S[i] = i+1;
        }

        int[] M = new int[19];
        for(int i=0; i<19; i++){
            M[i] = i+1;
        }

        int result = 1;
        int eIdx = 0;
        int sIdx = 0;
        int mIdx = 0;

        while(true){
            if(E[eIdx] == e && S[sIdx] == s && M[mIdx] == m){
                System.out.println(result);
                break;
            }

            result++;
            eIdx = (eIdx+1)%15;
            sIdx = (sIdx+1)%28;
            mIdx = (mIdx+1)%19;
        }



    }
}
