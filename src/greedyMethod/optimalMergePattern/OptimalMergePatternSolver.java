package greedyMethod.optimalMergePattern;

import java.util.ArrayList;
import java.util.Scanner;

public class OptimalMergePatternSolver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> arrSum = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(sc.nextLine());
            arr.add(num);
        }
        for (int i = 0; i < n - 1; i++) {
            arr.sort((o1, o2) -> o1 - o2);
            arr.forEach(System.out::print);
            System.out.println(" ");
            arrSum.add(arr.get(0) + arr.get(1));
            arr.set(1, arr.get(0) + arr.get(1));
            arr.remove(0);
        }
        System.out.println("***********");
        arrSum.forEach(System.out::print);
        System.out.println("");
        int sum = 0;
        for (Integer obj : arrSum) {
            sum = sum + obj;
        }
        System.out.println(sum);
    }
}
