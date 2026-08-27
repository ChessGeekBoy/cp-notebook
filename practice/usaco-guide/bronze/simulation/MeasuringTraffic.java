import java.util.*;
import java.io.*;

public class MeasuringTraffic {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("traffic.in"));
         PrintWriter output = new PrintWriter("traffic.out");

        int n = input.nextInt();
        // Each row of traffic contains 0 for none, 1 for on, 2 for off
        // It also has the traffic flow rate over that segment
        // It has to store the range of the traffic flow rate
        int[][] traffic = new int[n][3];
        input.nextLine(); // Used to move to the next line
       
        for (int i = 0; i < n; i++) {
            
        }
    }
}