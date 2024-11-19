package Math;

import java.util.Scanner;

public class P17427_약수의합2_sr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long sum = 0;

        for (int i = 1; i <= N; i++) {
            sum += (N / i) * i;
        }

        System.out.println(sum);
    }
}
