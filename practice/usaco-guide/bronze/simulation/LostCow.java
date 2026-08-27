import java.util.*;
import java.io.*;

public class LostCow {
   public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("lostcow.in"));
    PrintWriter output = new PrintWriter("lostcow.out");


    // taking in the input
    int x = input.nextInt();
    int y = input.nextInt();
    boolean cowFound = (x == y);
    int distance = 0;
    int running = 1;
    int currentX = x;
    
    while (!cowFound) {
        // Something is wrong with the logic for cowFound, let's just split into cases where running is positive and negative
        if (running >= 0) {
            cowFound = (currentX <= y) && (y <= currentX + running);
        }
        else {
            cowFound = (currentX + running <= y) && (y <= currentX);
        }

       if (cowFound) {
        distance += Math.abs(currentX - y);
       }
       else {
        currentX += running;
        distance += Math.abs(running);
       }
       if (running == 1) {
        running = -3;
       }
       else {
        running *= -2;
       }
    }

    output.println(distance);
    output.close();
   } 
}
