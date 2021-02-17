package greedyMethod.jobSequencing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class JobSequencingSolver {
    public static void main(String[] args) {
        ArrayList<SequencingDataClass> office = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int totProfit = 0;

        System.out.println("Enter Total Number of Jobs");
        int n = Integer.parseInt(sc.nextLine());

        System.out.println("Enter Total Number of Slots");
        int totSlots = Integer.parseInt(sc.nextLine());

        int[] arr = new int[totSlots];
        Arrays.fill(arr, 0);        // Initialize arrays with zeros

        // Retrieve Data
        for (int i = 0; i < n; i++) {
            System.out.println("Enter Job Profit, Deadline of Job:" + i);
            office.add(new SequencingDataClass(Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine()), i + 1));
        }

        //Sorting based on profits of objects using lambda method
        office.sort(((o1, o2) -> o2.profit - o1.profit));

        // Job Sequencing is done here
        for (int i = 0; i < totSlots; i++) {
            int slot = office.get(i).deadlines;     // Returns the max deadline

            // If max deadline is empty it will be filled with JobId.
            // Else it tries all earlier slots.
            while (slot >= 0) {
                if (arr[slot - 1] == 0) {
                    arr[slot - 1] = office.get(i).jobId;
                    totProfit = totProfit + office.get(i).profit;
                    break;
                } else {
                    slot--;
                }
            }
        }

        // Print output
        System.out.println("The total Profit is" + totProfit);
        for (int i = 0; i < totSlots; i++) {
            System.out.println(arr[i]);
        }
    }
}
