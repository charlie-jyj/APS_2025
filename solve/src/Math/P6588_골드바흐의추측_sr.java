package Math;

import java.io.*;
import java.util.StringTokenizer;

public class P6588_골드바흐의추측_sr {

    public static final int MAX = 1000001;

    public static void main(String[] args) throws IOException {

        /* 시도 1.
        // 아래 방법으로 하면 2부터 백만까지를 모두 계산해야 하기 때문에 시간초과가 발생한다.
        // 소수만 들어있는 배열을 만들어야 할 것 같다.
        int prime[] = new int[MAX];

        for (int i = 2; i <= MAX; i++) {
            for (int j = 1; i*j < MAX; j++) {
                if (j != 1 && i*j != i) {
                    prime[i * j] = i;
                }
            }
        }
        */

        /* 시도 2.
        // 아래와 같이 소수만 있는 리스트를 만들어서 해봐도 시간초과가 발생한다.
        int primeArray[] = new int[MAX];
        for (int i = 2; i <= MAX; i++) {
            for (int j = 1; i*j < MAX; j++) {
                if (j != 1 && i*j != i) {
                    primeArray[i * j] = i;
                }
            }
        }

        List<Integer> prime = new ArrayList<Integer>();
        for (int i = 3; i < MAX; i++) {
            if (primeArray[i] == 0) {
                prime.add(i);
            }
        }
        */

        // 시도 6. int 배열에서 boolean 배열로 변환, 기본값 false로 초기화 되므로, false = 소수, true = 소수 아님
        boolean prime[] = new boolean[MAX];
        prime[0] = prime[1] = true; // 0, 1은 소수가 아님

        // 시도 7. j = 2부터 시작하도록 변경
        // 시도 8. i <= MAX 에서 i*i <= MAX 로 변경
        for (int i = 2; i*i <= MAX; i++) {
            for (int j = 2; i*j < MAX; j++) {
                prime[i * j] = true;
            }
        }

        // 시도 11. BufferedWriter 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true) {
            // 시도 13. 어차피 한줄에 한개 값만 읽으면 되니, 토크나이저 안쓰고 바로 readLine()으로 읽기
            /*
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            */
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            boolean stopFlag = false; // stopFlag 가 true면 아래 for문을 멈춘다.
            // b-a가 가장 큰 것을 출력하려면, i가 가장 큰 소수일때부터, 작은 소수를 하나씩 더해가면서 비교한다.
            //시도 9. i = n --> i = n - 2로 변경, i+j 2가지 숫자의 합으로 n이 나와야 하기 때문에, n은 될 수 없고, n-1, 1 도 1이 소수가 아니기 때문에 될 수 없기 때문에, n-2 부터 시작한다.
            /*
            for(int i = n-2; i >= n/2 && !stopFlag; i--) {
                if (prime[i]) continue; // 시도 3. i가 소수가 아닌 경우에 건너뛰는 구문 추가
                for (int j = 3; j < n/2 && !stopFlag; j+=2) { // 시도 5. j는 3부터 시작하니까, 홀수만 검사하기 위해 j++ -> j+=2로 변경
                    if (prime[j]) continue; // 시도 4. j가 소수가 아닌 경우에 건너뛰는 구문 추가
                    // i 와 j가 소수이면서, 홀수이면 추가한다.
                    if (i % 2 != 0
                            && j % 2 != 0
                            && (i + j) == n
                    ) {
                        //시도 10. StringBuilder를 print로 변경
                        //시도 12. StringBuilder를 BufferedWriter로 변경
                        //시도 14. + 를 .append 로 변경
                        sb.append(n).append(" = ").append(j).append(" + ").append(i).append("\n");
                        //System.out.println(n + " = " + j + " + " + i + "\n");
                        //bw.write(n + " = " + j + " + " + i + "\n");
                        stopFlag = true;
                    }
                }
            }
            */
            // 시도 15. a, b 구하는 부분 수정 : n 은 무조건 짝수로 입력되므로, 짝수 - 홀수 = 홀수이다. 따라서 n - j 는 홀수가 된다.
            for (int j = 3; j <= n / 2; j += 2) {
                if (!prime[j] && !prime[n - j]) {
                    sb.append(n).append(" = ").append(j).append(" + ").append(n - j).append("\n");
                    stopFlag = true;
                    break;
                }
            }

            // 이 곳까지 내려왔는데도 stopFlag가 false라면, 두 홀수 소수의 합으로 n을 나타낼 수 없는 경우이다.
            // Goldbach's conjecture is wrong. 을 출력한다.
            if (!stopFlag) {
                sb.append("Goldbach's conjecture is wrong.\n");
                //System.out.println("Goldbach's conjecture is wrong.\n";)
                //bw.write("Goldbach's conjecture is wrong.\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
