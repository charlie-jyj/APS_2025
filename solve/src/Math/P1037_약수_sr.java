package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1037_약수_sr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 약수의 갯수
        int cnt = Integer.parseInt(st.nextToken());
        int min = 0; // 입력받은 약수 중 최소 값
        int max = 0; // 입력받은 약수 중 최대 값

        st = new StringTokenizer(br.readLine());

        min = max = Integer.parseInt(st.nextToken());
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());

            if (num > max) {
                max = num;
            } else if (num < min) {
                min = num;
            }
        }

        System.out.println(min * max);
    }
}
