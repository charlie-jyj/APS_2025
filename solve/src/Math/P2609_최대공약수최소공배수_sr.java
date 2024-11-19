package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2609_최대공약수최소공배수_sr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 36
        int M = Integer.parseInt(st.nextToken()); // 48
        int max = N > M ? N : M;
        int min = N < M ? N : M;

        int GCD = 0;
        int LCM = 0;

        while (true) {
           if (max % min == 0) {
               GCD = min;
               break;
           } else {
               int temp = max % min;
               max = min;
               min = temp;
           }
        }

        LCM = N * M / GCD;

        System.out.println(GCD);
        System.out.println(LCM);
    }
}
