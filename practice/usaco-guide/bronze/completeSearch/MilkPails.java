import java.util.*;
import java.io.*;

public class MilkPails {
   public static void main(String[] args) throws FileNotFoundException {  
    Scanner input = new Scanner(new File("pails.in"));
    PrintWriter output = new PrintWriter("pails.out");

    int x = input.nextInt();
    int y = input.nextInt();
    int m = input.nextInt();

    int amountOfX = m / x;
    int amountOfY = 0;
    int maxFill = 0;

    while (amountOfX >= 0) {
         maxFill = Math.max(x * amountOfX + y * amountOfY, maxFill);
         amountOfX--;
         amountOfY = (m - x * amountOfX) / y;
    }        

    output.println(maxFill);
    output.close();
   }
}