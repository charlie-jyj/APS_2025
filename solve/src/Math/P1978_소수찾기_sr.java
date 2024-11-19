package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1978_소수찾기_sr {

    public static final int MAX = 1001;

    public static void main(String[] args) throws IOException {
        int prime[] = new int[MAX];

        // 이전 문제와 같이 약수의 합을 구하는 배열을 만든다.
        // 즉, 배열 값 중, 0을 가지고 있는 인덱스는 소수다.
        for (int i = 2; i <= MAX; i++) {
            for (int j = 1; i*j < MAX; j++) {
                if (j != 1 && i*j != i) { // 1과 자기 자신을 제외한 약수가 있는 숫자에게만 약수를 더해준다.
                    prime[i * j] += i;
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int primeCnt = 0;
        for (int i = 0; i < N; i++) {
            int chkNum = Integer.parseInt(st.nextToken());

            // 위에서 1을 제외 했기 때문에 1로 값이 들어오면 제외해야 한다.
            if (chkNum != 1 && prime[chkNum] == 0) {
                primeCnt++;
            }
        }

        System.out.println(primeCnt);
    }
}
