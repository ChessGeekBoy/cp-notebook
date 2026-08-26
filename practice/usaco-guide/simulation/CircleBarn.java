import java.util.*;
import java.io.*;


public class CircleBarn {
   public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("cbarn.in"));
    PrintWriter output = new PrintWriter("cbarn.out");

    // taking in the input
    int n = input.nextInt();
    input.nextLine();
    int[] rooms = new int[n];
    for (int i = 0; i < n; i++) {
        rooms[i] = input.nextInt();
        input.nextLine();
    }

    // Now we go through all possible options
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
        // We're going to see what happens if we open the exterior door to room i
        int sum = 0;
        for (int j = 0; j < n; j++) {
            if (j < i) {
                sum += rooms[j] * (n - (i - j));
            }
            else {
                sum += rooms[j] * (j - i);
            }
        }
        if (i == 0) {
            min = sum;
        }
        else {
            min = Math.min(min, sum);
        }
    }

    output.println(min);
    output.close();
   } 
}
