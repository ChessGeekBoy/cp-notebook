import java.io.*;
import java.util.*;

public class CowSignal {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("cowsignal.in"));
        PrintWriter output = new PrintWriter("cowsignal.out");

        int m = input.nextInt();
        int n = input.nextInt();
        int k = input.nextInt();
        //input.nextLine();

        // char[][] originalSignal = new char[][][m][n];
        char[][] newSignal = new char[k * m][k * n];
        try{
        // taking in the input and making new signal
            for (int i = 0; i < m; i++) {
                String line = input.nextLine();
                for (int j = 0; j < n; j++) {
                    // originalSignal[i][j] = line.charAt(j);
                    for (int l = 0; l < k; l++) {
                        for (int o = 0; o < k; o++) {
                            //output.println(line.length());
                            newSignal[k * i + l][k * j + o] = line.charAt(j);

                        }
                    }
                }
            }

            // printing out our new signal
            for (int i = 0; i < k * m; i++) {
                for (int j = 0; j < k * n; j++) {
                    if (j < (k * n) - 1) {
                        output.print(newSignal[i][j]);
                    } else {
                        output.println(newSignal[i][j]);
                    }
                }
            }
        }
        finally {

            output.close();
        }
    }
}
