package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P2309_일곱난쟁이_sr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = 9;
        List<Integer> dwarf = new ArrayList<>();
        List<Integer> ansDwarf = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            dwarf.add(Integer.parseInt(br.readLine()));
        }

        List<List<Integer>> combinations = new ArrayList<>();
        generateCombinations(dwarf, 7, 0, new ArrayList<>(), combinations);

        for (int i = 0; i < combinations.size(); i++) {
            if (combinations.get(i).stream().mapToInt(Integer::intValue).sum() == 100) {
                ansDwarf = combinations.get(i);
            }
        }

        ansDwarf.sort((a, b) -> a - b);
        for (int i = 0; i < ansDwarf.size(); i++) {
            System.out.println(ansDwarf.get(i));
        }
    }

    public static void generateCombinations(List<Integer> input, int r, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == r) {
            result.add(new ArrayList<>(current)); // 현재 조합을 결과에 추가
            return;
        }

        for (int i = start; i < input.size(); i++) {
            current.add(input.get(i)); // 요소 추가
            generateCombinations(input, r, i + 1, current, result); // 재귀 호출
            current.remove(current.size() - 1); // 백트래킹
        }
    }
}
