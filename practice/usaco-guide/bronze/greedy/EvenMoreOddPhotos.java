import java.io.*;
import java.util.*;

public class EvenMoreOddPhotos {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        PrintWriter output = new PrintWriter(System.out);

        int n = input.nextInt();
        int oddCount = 0;
        int evenCount = 0;
        input.nextLine();
        // counting odds and evens works as of now
        for (int i = 0; i < n; i++) {
            if (input.nextInt() % 2 == 0) {
                evenCount++;
            }
            else {
                oddCount++;
            }
        }
        
        // yes, we do start off wanting an even-sum group
        boolean wantEven = true;
        // we will assume it's possible to keep going for now, if it doesn't work it will turn false
        boolean stillPossible = true;
        // # of groups should start at zero, that's correct
        int groupCount = 0;

        // this seems fine
        while (stillPossible) {
            if (wantEven && stillPossible) {
                //output.println("We want an even group");
                // sacrifice an even if there is one
                if (evenCount > 0) {
                    evenCount--;
                    //output.println("Using an even number to make even group, " + evenCount + " remaining");
                    groupCount++;
                }
                // if not, if there are two odds, sac them
                else if (oddCount >= 2) {
                    oddCount -= 2;
                    //output.println("Using two odd numbers to make even group, " + oddCount + " remaining");
                    groupCount++;
                }
                // if neither is there, then impossible
                else if (oddCount == 1) {
                    //output.println("Failed to make an even number.");
                    groupCount--;
                    stillPossible = false;
                }
                else {
                    stillPossible = false;
                }
            }
            else if (!wantEven && stillPossible) {
                //output.println("Want an odd group");
                // must use an odd
                if (oddCount > 0) {
                    oddCount--;
                    //output.println("Used an odd to make an odd group, " + oddCount + " remaining");
                    groupCount++;
                }
                else {
                    //output.println("failed to make an odd group");
                    stillPossible = false;
                }
            }
            wantEven = !wantEven; 
        }
        
        output.println(groupCount);
        output.close();
        input.close();
    }
}