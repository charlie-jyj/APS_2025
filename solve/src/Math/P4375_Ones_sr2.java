package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P4375_Ones_sr2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String M = "";
        while ((M = br.readLine()) != null) {
            int N = Integer.parseInt(M);
            int digitCnt = 1;
            int remainder = 1;

            while (remainder % N != 0) {
                remainder = (remainder * 10 + 1) % N;
                digitCnt++;
            }
            System.out.println(digitCnt);
        }

        br.close();
    }
}
