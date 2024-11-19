package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1929_소수구하기_sr {

    public static final int MAX = 1000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int prime[] = new int[MAX];

        for (int i = 2; i <= MAX; i++) {
            for (int j = 1; i*j < MAX; j++) {
                if (j != 1 && i*j != i) {
                    prime[i * j] = i;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = N; i <= M; i++) {
            if (prime[i] == 0 && i != 1) {
                sb.append(i + "\n");
            }
        }

        System.out.println(sb);
    }
}
