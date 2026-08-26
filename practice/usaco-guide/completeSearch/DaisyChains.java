import java.io.*;
import java.util.*;

public class DaisyChains {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        PrintWriter output = new PrintWriter(System.out);

        int n = input.nextInt();
        int total = 0;
        int[] partialSums = new int[n];
        int[] petalCounts = new int[n];

        input.nextLine();

        for (int i = 0; i < n; i++) {
            petalCounts[i] = input.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                partialSums[i] = petalCounts[0];
            }
            else {
                partialSums[i] = partialSums[i - 1] + petalCounts[i];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = findSum(i, j, partialSums);
                if (i == j) {
                    total++;
                    continue;
                }
                else if ((sum % (j - i + 1)) != 0) {
                    continue;
                }
                else {
                    int average = sum / (j - i + 1);
                    for (int k = i; k <= j; k++) {
                        if (petalCounts[k] == average) {
                            total++;
                            break;
                        }
                    }
                }
            }
        }

        output.println(total);
        output.close();
    }

    public static int findSum(int i , int j, int[] partialSums) {
        if (i == 0) {
            return partialSums[j];
        }
        else {
            return partialSums[j] - partialSums[i - 1];
        }
    }
}