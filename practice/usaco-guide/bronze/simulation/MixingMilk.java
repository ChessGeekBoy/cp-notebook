import java.io.*;
import java.util.Scanner;

public class MixingMilk {
    public static void main(String[] args) throws IOException {
        File myObj = new File("mixmilk.in");
        Scanner input = new Scanner(myObj);
        PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("mixmilk.out")));

	    int[] capacities = new int[3];
	    int[] amounts = new int[3];

	    // Reading in the input
	    for (int i = 0; i < 3; i++) {
		    capacities[i] = input.nextInt();
            amounts[i] = input.nextInt();
	    }

        // doing the pours
        for (int i = 0; i < 100; i++) {
            if (i % 3 == 0) {
                pour(capacities, amounts, 0, 1);
            }
            else if (i % 3 == 1) {
                pour(capacities, amounts, 1, 2);
            }
            else {
                pour(capacities, amounts, 2, 0);
            }
        }

        output.println(amounts[0]);
        output.println(amounts[1]);
        output.println(amounts[2]);
        output.close();
    }

    // milk pours from i to j
    public static void pour(int[] capacities, int[] amounts, int i, int j) {
        int newJ, newI = 0;

        if (amounts[i] + amounts[j] <= capacities[j]) {
            newJ = amounts[i] + amounts[j];
            newI = 0;
        }
        // pouring fully here would exceed the capacity
        else {
            newJ = capacities[j];
            newI = amounts[i] - (capacities[j] - amounts[j]);
        }

        amounts[i] = newI;
        amounts[j] = newJ;
    }
}
