package Math;

import java.io.*;
import java.util.StringTokenizer;

public class P100448_yujin {

    static String samplePath = "/Users/yujin/Documents/APS_2025/solve/src/Math/P100448_input.txt";
    static int testcaseRow = 1;
    static int testcaseCol = 3;

    public static void main(String[] args) throws Exception {
        new P100448_yujin().solution();
    }

    public void solution() throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 백준용
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BufferedReader br = new BufferedReader(new FileReader(samplePath));
        StringBuilder sb = new StringBuilder();

        Integer[][] input = new Integer[testcaseRow][testcaseCol]; // 여러 개의 테스트 케이스가 들어올 경우,

        String testcase = "";
        int row = 0;
        while ((testcase = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(testcase, " ");
            for (int col = 0; st.hasMoreTokens(); col++) {
                String token = st.nextToken();
                input[row][col] = Integer.parseInt(token);
            }
            row++;
        }

        // testcase 순회
        for(int i = 0 ; i < input.length ; i++) {
            int A = input[i][0];
            int B = input[i][1];
            int C = input[i][2];

            sb.append((A+B)%C).append("\n");
            sb.append(((A%C)+(B%C))%C).append("\n");
            sb.append((A*B)%C).append("\n");
            sb.append(((A%C)*(B%C))%C).append("\n");
        }

        /*
        * 백준용
        * StringTokenizer st = new StringTokenizer(testcase, " ");
        * int A = Integer.parseInt(st.nextToken());
        * int B = Integer.parseInt(st.nextToken());
        * int C = Integer.parseInt(st.nextToken());
        * System.out.println((A+B)%C);
        * System.out.println(((A%C)+(B%C))%C);
        * System.out.println((A*B)%C);
        * System.out.println(((A%C)*(B%C))%C);
        * */

        br.close();
        System.out.println(sb);
    }
}


