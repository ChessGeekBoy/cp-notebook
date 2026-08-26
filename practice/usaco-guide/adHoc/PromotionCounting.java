import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PromotionCounting {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(new File("promote.in"));
        PrintWriter output = new PrintWriter("promote.out");

        // Ok, this is basically just a counting problem
        int[] differences = new int[4];
        for (int i = 0; i < 4; i++) {
            differences[i] = -(input.nextInt() - input.nextInt());
            input.nextLine();
        }
        output.println(differences[1] + differences[2] + differences[3]);
        output.println(differences[2] + differences[3]);
        output.println(differences[3]);

        output.close();
    }
}