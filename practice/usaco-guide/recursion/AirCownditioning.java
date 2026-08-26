import java.io.*;
import java.util.*;

public class AirCownditioning {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PrintWriter output = new PrintWriter(System.out);

        int n = input.nextInt();
        // n is the # of cows
        int m = input.nextInt();
        // m is the # of conditioners
        input.nextLine();
        // start, end, cooling, cost, in that order
        int[][] conditioners = new int[m][4];
        // only the remaining amount to be cooled is there
        int[] cells = new int[100];

        // filling in the cells, NOT the conditioners yet
        int start, end, cooling;
        for (int i = 0; i < n; i++) {
            start = input.nextInt() - 1;
            end = input.nextInt() - 1;
            cooling = input.nextInt();

            for (int j = start; j <= end; j++) {
                cells[j] = cooling;
            }
            input.nextLine();
        }

        for (int i = 0; i < m; i++) {
            conditioners[i][0] = input.nextInt() - 1;
            conditioners[i][1] = input.nextInt() - 1;
            conditioners[i][2] = input.nextInt();
            conditioners[i][3] = input.nextInt();
            input.nextLine();
        }

        // Now, all variables are set up

        // Idea: Since there are at most 10 conditioners, we can loop over all possible
        // combinations of them instead of designing an algorithm
        // Forget about optimizing, just take advantage of small inputs
        boolean[] activatedConditioners = new boolean[m];
        int number = 0;
        int minimumCost = Integer.MAX_VALUE;
        for (int i = 0; i < Math.pow(2, m); i++) {
            number = i;
            for (int j = 0; j < m; j++) {
                activatedConditioners[j] = (number % 2 == 1);
                number = number / 2;
            }
            if (checkConditionerActivation(conditioners, activatedConditioners, cells)) {
                minimumCost = Math.min(minimumCost, findActivationCost(conditioners, activatedConditioners));
                // output.println(minimumCost);
            }
        }

        output.println(minimumCost);

        output.close();
        input.close();
    }

    public static boolean checkConditionerActivation(int[][] conditioners,
            boolean[] activatedConditioners, int[] cells) {
        boolean result = true;
        int[] newCells = cells.clone();
        int start, end;
        for (int i = 0; i < conditioners.length; i++) {
            if (activatedConditioners[i]) {
                start = conditioners[i][0];
                end = conditioners[i][1];
                for (int j = start; j <= end; j++) {
                    // System.out.println("Reducing cell " + j + " by " + conditioners[i][2]);
                    newCells[j] -= conditioners[i][2];
                }
            }
        }

        for (int i = 0; i < newCells.length; i++) {
            result &= (newCells[i] <= 0);
        }

        return result;
    }

    public static int findActivationCost(int[][] conditioners, boolean[] activatedConditioners) {
        int totalCost = 0;

        for (int i = 0; i < conditioners.length; i++) {
            if (activatedConditioners[i]) {
                totalCost += conditioners[i][3];
            }
        }

        return totalCost;
    }
}