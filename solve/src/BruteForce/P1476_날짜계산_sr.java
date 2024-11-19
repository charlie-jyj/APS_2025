package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1476_날짜계산_sr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        // 1 <= E <= 15, 1 <= S <= 28, 1 <= M <= 19
        // 1 16 16 = 16
        // 1 1 1 = 1
        // 1 2 3 = 5266
        // 15 28 19 = 7980

        // 시도 1.
        /*
        int i = 1;
        while (true) {
            int e = i % 15;
            int s = i % 28;
            int m = i % 19;

            if (e == E && s == S && m == M) {
                System.out.println(i);
                break;
            }

            i++;
        }
        */

        // 시도 2.
        // 1씩 빼주는 이유는 예를들어, E가 15인 경우는, E % 15 를 했을 경우에 0-14 만 나오기 때문에,
        // 1을 먼저 빼주고, 나중에 답을 출력할 때, 1을 더해주어야 한다.
        /*
        E = E - 1;
        S = S - 1;
        M = M - 1;

        int i = 0;
        while (true) {
            int e = i % 15;
            int s = i % 28;
            int m = i % 19;

            if (e == E && s == S && m == M) {
                System.out.println(i + 1);
                break;
            }

            i++;
        }
        */

        // 시도 3. E가 1 <= E <= 15로 범위가 가장 작으므로,
        // 시작값을 E로 하고, i+=15 를 하면, E는 항상 입력한 값이 된다.
        // i에다가 1-14 까지 더할때는, E값도 입력한 값이 아닌 다른 값으로 바뀌게 되고, 그 동안, S, M값이 변경되어도 답이 아니기 때문에 무방하다.
        E = E - 1;
        S = S - 1;
        M = M - 1;

        int i = E;
        while (true) {
            int e = i % 15;
            int s = i % 28;
            int m = i % 19;

            if (s == S && m == M) {
                System.out.println(i + 1);
                break;
            }

            i+=15;
        }
    }
}
