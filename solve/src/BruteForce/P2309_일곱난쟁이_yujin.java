package BruteForce;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class P2309_일곱난쟁이_yujin {

    static String samplePath = "/Users/yujin/Documents/APS_2025/solve/src/BruteForce/P2309_input.txt";

    /*
    *
    * 왕비를 피해 일곱 난쟁이들과 함께 평화롭게 생활하고 있던 백설공주에게 위기가 찾아왔다.
    * 일과를 마치고 돌아온 난쟁이가 일곱 명이 아닌 아홉 명이었던 것이다.
    * 아홉 명의 난쟁이는 모두 자신이 "백설 공주와 일곱 난쟁이"의 주인공이라고 주장했다.
    * 뛰어난 수학적 직관력을 가지고 있던 백설공주는, 다행스럽게도 일곱 난쟁이의 키의 합이 100이 됨을 기억해 냈다.
    * 아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.
    *
    * 아홉 개의 줄에 걸쳐 난쟁이들의 키가 주어진다.
    * 주어지는 키는 100을 넘지 않는 자연수이며, 아홉 난쟁이의 키는 모두 다르며, 가능한 정답이 여러 가지인 경우에는 아무거나 출력한다.
    * 일곱 난쟁이의 키를 오름차순으로 출력한다. 일곱 난쟁이를 찾을 수 없는 경우는 없다.
    *
    * [풀이 계획]
    * 9개 중에서 서로 다른 7개의 숫자 조합을 만들고 합을 구했을 때 100이 되는 조합을 찾기
    * 조합을 오름차순으로 출력한다.
    * */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(samplePath));
        int[] numbers = new int[9];
        for (int i = 0; i < 9; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        new P2309_일곱난쟁이_yujin().solution(numbers);
    }

    public void solution(int[] numbers) {
        int targetSum = 100;
        ArrayList<ArrayList<Integer>> resultSet = new ArrayList<>();
        findCombinationsRecursive(numbers, targetSum, 0, new ArrayList<>(), resultSet);
        ArrayList<Integer> result = resultSet.get(0);
        Collections.sort(result);
        for(int i: result){
            System.out.println(i);
        }
    }

    // 재귀적으로 조합을 찾는 함수
    public static void findCombinationsRecursive(int[] numbers, // 원본
                                                  int targetSum, // 가지치기 조건
                                                  int start, // 인덱스
                                                  ArrayList<Integer> currentCombination, // 현재 조합
                                                  ArrayList<ArrayList<Integer>> result) { // 결과 조합

        // 재귀 종료 조건
        // 나는 7개를 고르는 것을 조건으로 세웠지만
        // TOBE: 9명 중에 난쟁이가 아닌 2명을 고르고 총합 - (2명의 키의 합) = 100 을 체크하는 방법의 경우의 수가 더 적음
        if (targetSum == 0 && currentCombination.size() == 7) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        // 총합이 100을 넘었거나 조합이 7개이지만 100이 아닐 경우 가지치기
        if (targetSum < 0 || currentCombination.size() == 7) {
            return;
        }

        for (int i = start; i < numbers.length; i++) {
            // i를 선택한 경우
            currentCombination.add(numbers[i]);
            findCombinationsRecursive(numbers, targetSum - numbers[i], i + 1, currentCombination, result);

            // i를 사용하지 않고 다음 i+i을 사용할 준비,
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}
