import java.util.*;
import java.io.*;

public class CowTipping {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("cowtip.in"));
        PrintWriter output = new PrintWriter("cowtip.out");

        int n = input.nextInt();
        input.nextLine();
        boolean[][] tipStatus = new boolean[n][n];
        int flipCount = 0;
        String currentLine;

        // just checked, and parsing is working properly
        for (int i = 0; i < n; i++) {
            currentLine = input.nextLine();
            for (int j = 0; j < n; j++) {
                tipStatus[i][j] = (currentLine.charAt(j) == '1');
            }
        }
        
        /* Idea: just go through each diagonal (starting from bottom-right one) and do flips if required
        Well a diagonal is when (i + j) is constant
        Maybe do k = 2n - 2 and k >= 0
        Then, let i = 0 to k
        and define j = k - i */

        
        for (int k = 2 * n - 2; k >= 0; k--) {
            for (int i = Math.min(k, n - 1); i >= 0; i--) {
                int j = k - i;
                if (j < n) {    
                    if (tipStatus[i][j]) {
                        flip(i, j, tipStatus);
                        flipCount++;
                    }
                }
            }
        }

        output.println(flipCount);
        input.close();
        output.close();
    }

    public static void flip(int x, int y, boolean[][] tipStatus) {
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                tipStatus[i][j] = !tipStatus[i][j];
            }
        }
    }
}