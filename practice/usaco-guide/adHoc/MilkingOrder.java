import java.io.*;
import java.util.*;

public class MilkingOrder {
    public static void main(String[] args) throws FileNotFoundException{
       Scanner input = new Scanner(new File("milkorder.in"));
       PrintWriter output = new PrintWriter("milkorder.out");

       int n = input.nextInt();
       int m = input.nextInt();
       int k = input.nextInt();
       input.nextLine();
       int rank = 0;
       int[] milkingOrder = new int[n];

       // filling out the hierarchy
       int[] hierarchy = new int[m];
       for (int ranking = 0; ranking < m; ranking++) {
        int cow = input.nextInt();
        if (cow == 1) {
            rank = ranking;
        }
        hierarchy[ranking] = cow;
       }
       input.nextLine();


       boolean setPosition = false;
       // taking in the position demands
       for (int i = 0; i < k; i++) {
        int cowNumber = input.nextInt();
        setPosition |= (cowNumber == 1);
        milkingOrder[input.nextInt() - 1] = cowNumber;
       }



       if (setPosition) {
        for (int i = 0; i < n; i++) {
            if (milkingOrder[i] == 1)
            output.println(i + 1);
        }
       }
       else {
        // if rank is 0, the for loop never goes through
        int minIndex = 0;
        for (int i = 0; i <= rank; i++) {
            for (int j = minIndex; j < n; j++) {
                if (milkingOrder[j] == hierarchy[i]) {
                    break;
                }
                else if (milkingOrder[j] == 0) {
                   // fill in the empty cell 
                   milkingOrder[j] = hierarchy[i];
                   minIndex = j + 1;
                   if (i == rank) {
                    output.println(j);
                   }
                   break;
                }
            }
        }
       }

       output.close();
    }    
}
