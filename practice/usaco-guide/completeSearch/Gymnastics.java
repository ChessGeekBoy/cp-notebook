import java.io.*;
import java.util.*;

public class Gymnastics {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("gymnastics.in"));
        PrintWriter output = new PrintWriter("gymnastics.out");
        
        // Possible to do it in O(n^2 * k) time easily
        int n = input.nextInt();
        int k = input.nextInt();
        input.nextLine();
        // each thing is about whether they're consistent or not but we also need to store which one's better
        boolean[][] cowPairs = new boolean[n][n];
        // the cowPairs array just says whether a is better than b: (cowPairs[a][b]reflects this)
        boolean[][] consistencyPairs = new boolean[n][n];
        // everything's initially consistent
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                consistencyPairs[i][j] = true;
            }
        }
        // start off initializing the current rankings
        int[] currentLine = new int[n];
        for (int i = 0; i < n; i++) {
            currentLine[i] = input.nextInt();
            for (int j = 0; j < i; j++) {
                // compare to populate cowPairs for the first time
                cowPairs[currentLine[j]][currentLine[i]] = false;
                cowPairs[currentLine[i]][currentLine[j]] = true;
            }
        }
        input.nextLine();
        //current rankings have been set
        // now to go through next ones
        for (int i = 1; i < k; i++) {
            for (int j = 0; j < n; j++) {
                currentLine[j] = input.nextInt();
            }
            input.nextLine();
        }
        output.close();
    }
}