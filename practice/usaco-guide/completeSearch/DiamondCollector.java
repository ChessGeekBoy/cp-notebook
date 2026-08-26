import java.io.*;
import java.util.*;

public class DiamondCollector {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("diamond.in"));
        PrintWriter output = new PrintWriter("diamond.out");

        int n = input.nextInt();
        int k = input.nextInt();
        int max = 0;
        input.nextLine();
        int[] sizes = new int[n];
        for (int i = 0; i < n; i++) {
            sizes[i] = input.nextInt();
            input.nextLine();
        }

        for (int smallest = 0; smallest < sizes.length; smallest++) {
            int currentCount = 0;
            for (int i = 0; i < sizes.length; i++) {
                if ((sizes[i] - sizes[smallest]) <= k && (sizes[i] >= sizes[smallest])) {
                    currentCount++;
                }
            }
            max = Math.max(currentCount, max);
        }
        output.println(max);
        output.close();
    }
}
