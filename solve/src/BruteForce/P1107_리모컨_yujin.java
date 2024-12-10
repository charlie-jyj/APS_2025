package BruteForce;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class P1107_리모컨_yujin {

    static String samplePath = "/Users/yujin/Documents/APS_2025/solve/src/BruteForce/P1107_input.txt";

    /*
    * 수빈이는 TV를 보고 있다. 수빈이는 채널을 돌리려고 했지만, 버튼을 너무 세게 누르는 바람에, 일부 숫자 버튼이 고장났다.
    * 리모컨에는 버튼이 0부터 9까지 숫자, +와 -가 있다. +를 누르면 현재 보고있는 채널에서 +1된 채널로 이동하고, -를 누르면 -1된 채널로 이동한다.
    * 채널 0에서 -를 누른 경우에는 채널이 변하지 않고, 채널은 무한대 만큼 있다.
    * 수빈이가 지금 이동하려고 하는 채널은 N이다.
    * 어떤 버튼이 고장났는지 주어졌을 때, 채널 N으로 이동하기 위해서 버튼을 최소 몇 번 눌러야하는지 구하는 프로그램을 작성하시오.
    * 수빈이가 지금 보고 있는 채널은 100번이다.
    *
    * 첫째 줄에 수빈이가 이동하려고 하는 채널 N (0 ≤ N ≤ 500,000)이 주어진다.
    * 둘째 줄에는 고장난 버튼의 개수 M (0 ≤ M ≤ 10)이 주어진다.
    * 고장난 버튼이 있는 경우에는 셋째 줄에는 고장난 버튼이 주어지며,
    * 같은 버튼이 여러 번 주어지는 경우는 없다.
    * 첫째 줄에 채널 N으로 이동하기 위해 버튼을 최소 몇 번 눌러야 하는지를 출력한다.
    *
    * [풀이 계획]
    * ????
    * 고장난 버튼을 빼고 최대한 근사치로 접근한 후에 플러스/마이너스를 해야겠다.
    * 하지만 근사치로 어떻게 접근해야하죠?
    *
    * [반례 모음 참고]
    * https://www.acmicpc.net/board/view/134925
    *
    * */

    public static void main(String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(samplePath));
        int targetNumber = Integer.parseInt(br.readLine());
        boolean[] buttons = new boolean[10]; // 사용 가능한 버튼은 true
        Arrays.fill(buttons, true);

        int brokenButtonCount = Integer.parseInt(br.readLine());
        int[] brokenButtons = new int[brokenButtonCount];
        if (brokenButtonCount > 0) {
            String[] brokenButtonsString = br.readLine().split(" ");
            for (int i = 0; i < brokenButtons.length; i++) {
                int brokenButtonIdx = Integer.parseInt(brokenButtonsString[i]);
                buttons[brokenButtonIdx] = false;
            }
        }

        int minTapCount = getMinTapCount(buttons, targetNumber);
        System.out.println(minTapCount);

    }

    public static int getMinTapCount(boolean[] buttons, int targetNumber) {
        int currentChannel = 100;
        int minTapCount = 1000000;

        // 1~1000000 만들 수 있는 숫자
        for(int i = 0; i < 1000001; i++){
            String[] iString = Integer.toString(i).split("");
            boolean tappable = true;
            for(String s : iString){
                int part = Integer.parseInt(s);
                if(!buttons[part]){
                    tappable = false;
                }
            }
            if(tappable) {
                minTapCount = Math.min(minTapCount, targetNumber - i >= 0 ? (targetNumber - i) + iString.length : (i - targetNumber) + iString.length);
            }
        }

        minTapCount = Math.min(minTapCount, targetNumber - currentChannel >= 0 ? targetNumber - currentChannel : currentChannel - targetNumber);
        return minTapCount;
    }
}
