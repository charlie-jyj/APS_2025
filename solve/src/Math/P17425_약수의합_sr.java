package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P17425_약수의합_sr {

    public static final int MAX = 1000001;

    public static void main(String[] args) throws IOException {
        long fx[] = new long[MAX];
        long gx[] = new long[MAX];

        // 모든 수는 약수 1을 가지고 있다.
        Arrays.fill(fx, 1);

        for (int i = 2; i <= MAX; i++) {
            for (int j = 1; j*i < MAX; j++) {
                fx[i*j] += i; // i * j 는 i로 나누어 떨어진다. 즉, i는 i * j의 약수이다.
            }
        }

        for (int i = 1; i < MAX; i++) {
            gx[i] = gx[i-1] + fx[i];
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());

            sb.append(gx[m] + "\n");
        }
        System.out.println(sb);
    }
}
