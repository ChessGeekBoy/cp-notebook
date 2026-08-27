import java.util.*;
import java.io.*;

public class SpeedingTicket {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("speeding.in"));
        PrintWriter output = new PrintWriter("speeding.out");

        // setting up variables
        int n = input.nextInt();
        int m = input.nextInt();
        input.nextLine();

        // arrays contain start, end, and speed/speed limit
        int[][] speedLimits = new int[n][3];
        int[][] speeds = new int[m][3];

        // taking in input
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                speedLimits[i][0] = 0;
                speedLimits[i][1] = input.nextInt();
                speedLimits[i][2] = input.nextInt();
            }
            else {
                speedLimits[i][0] = speedLimits[i - 1][1];
                speedLimits[i][1] = speedLimits[i][0] + input.nextInt();
                speedLimits[i][2] = input.nextInt();
            }
            input.nextLine();
        }

        for (int i = 0; i < m; i++) {
            if (i == 0) {
                speeds[i][0] = 0;
                speeds[i][1] = input.nextInt();
                speeds[i][2] = input.nextInt();
            }
            else {
                speeds[i][0] = speeds[i - 1][1];
                speeds[i][1] = speeds[i][0] + input.nextInt();
                speeds[i][2] = input.nextInt();
            }
            input.nextLine();
        }

        /*for (int i = 0; i < n; i++) {
            output.println("Speed Limit on " + speedLimits[i][0] + "-" + speedLimits[i][1] + ": " + speedLimits[i][2]);
        }
        for (int i = 0; i < m; i++) {
            output.println("Speed on " + speeds[i][0] + "-" + speeds[i][1] + ": " + speeds[i][2]);
        }*/
        // so then clearly the input is read correctly


        // since the inputs are integers, we are just going to loop through each mile and check
        int speedIndex = 0;
        int speedLimitIndex = 0;
        int maxExceededSpeed = 0;

        for (int mile = 0; mile < 100; mile++) {
            // mile respresents the start of the given mile
            if (mile >= speeds[speedIndex][1]) {
                speedIndex++;
            }
            if (mile >= speedLimits[speedLimitIndex][1]) {
                speedLimitIndex++;
            }

            maxExceededSpeed = Math.max(speeds[speedIndex][2] - speedLimits[speedLimitIndex][2], maxExceededSpeed);
        }

        output.println(maxExceededSpeed);
        output.close();
    }
}
