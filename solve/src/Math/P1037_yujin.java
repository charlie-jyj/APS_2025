package Math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P1037_yujin {

    static String samplePath = "/Users/yujin/Documents/APS_2025/solve/src/Math/P1037_input.txt";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(samplePath));

        int arrSize = Integer.parseInt(br.readLine());
        String testcase = br.readLine();
        int[] factors = Arrays.stream(testcase.split(" ")).mapToInt(Integer::parseInt).toArray();
        new P1037_yujin().solutioin(factors);
    }

    public void solutioin(int[] divisors) {

        // 1. 소인수 분해 후에 등장한 지수의 max를 찾아서 모두 곱하는 방법을 써봤지만 오답처리 되었음.
//        Map<Integer, Integer> primeFactors = new HashMap<>();
//        for (int divisor : divisors) {
//            Map<Integer, Integer> factors = primeFactorization(divisor);
//            for (Map.Entry<Integer, Integer> entry : factors.entrySet()) {
//                int factor = entry.getKey();
//                int count = entry.getValue();
//                primeFactors.put(factor, Math.max(primeFactors.getOrDefault(factor, 0), count));
//            }
//        }
//
//        int originalNumber = 1;
//        for (Map.Entry<Integer, Integer> entry : primeFactors.entrySet()) {
//            originalNumber *= Math.pow(entry.getKey(), entry.getValue());
//        }
//
//        System.out.println(originalNumber);

        // 2.값의 최대 & 최소를 찾아서 곱하는 방법을 써보겠음.
        int min = Arrays.stream(divisors).min().getAsInt();
        int max = Arrays.stream(divisors).max().getAsInt();

        System.out.println(min*max);
    }

    // 소인수 분해
    public static Map<Integer, Integer> primeFactorization(int n) {
        Map<Integer, Integer> factors = new HashMap<>();
        for (int i = 2; i <= Math.sqrt(n); i++) {
            int count = 0;
            while (n % i == 0) {
                count++;
                n /= i;
            }
            if (count > 0) {
                factors.put(i, count);
            }
        }
        if (n > 1) {
            factors.put(n, 1);
        }
        return factors;
    }

}
