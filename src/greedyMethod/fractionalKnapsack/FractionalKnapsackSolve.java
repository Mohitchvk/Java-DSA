package greedyMethod.fractionalKnapsack;


import java.util.ArrayList;
import java.util.Scanner;

public class FractionalKnapsackSolve {

    public static void main(String[] args) {

        ArrayList<SackDataClass> bag = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of items");
        int n = Integer.parseInt(sc.nextLine());

        System.out.println("Enter total weight of items allowed");
        int totWt = Integer.parseInt(sc.nextLine());
        int totPrice = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the Price, Weight");
            int price = Integer.parseInt(sc.nextLine());
            int weight = Integer.parseInt(sc.nextLine());

            bag.add(new SackDataClass(price, weight));
        }

        bag.sort((o1, o2) -> (o2.price / o2.weight) - (o1.price / o1.weight));



        for (int i = 0; i < n; i++) {
            if (totWt >= bag.get(i).weight) {
                totWt = totWt - bag.get(i).weight;
                totPrice = totPrice + bag.get(i).price;
            } else {
                totPrice = totPrice + (bag.get(i).price / bag.get(i).weight) * totWt;
                totWt = 0;
            }
        }

        System.out.println("Price You get is:" + totPrice);
        System.out.println("Weight You are left with is:" + totWt);

        for (int i = 0; i < n; i++) {
            System.out.println(" price: " + bag.get(i).price + " weight: " + bag.get(i).weight);
        }

    }
}


