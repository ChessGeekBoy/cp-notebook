import java.util.*;
import java.io.*;

public class WatchingMooloo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PrintWriter output = new PrintWriter(System.out);

        int n = input.nextInt();
        long k = input.nextInt();
        input.nextLine();

        long[] days = new long[n];

        for (int i = 0; i < n; i++) {
           days[i] = input.nextLong(); 
        }
        long totalCost = n * (k + 1); // new subscription every single day, for now

        for (int i = 1; i < n; i++) {
            // below: makes sure that merging is beneficial
            if (findGap(days[i - 1], days[i]) < k) {
                totalCost += findGap(days[i - 1], days[i]); // that number of days is added to the length of subscriptions
                totalCost -= k; // one subscription was removed
            }
        }

        output.println(totalCost);
        input.close();
        output.close();
    }

    public static long findGap(long i, long j) { return j - i - 1; }
}