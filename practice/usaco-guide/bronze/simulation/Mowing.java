import java.util.*;
import java.io.*;

public class Mowing {

    static int time = 0;
    static int maxX = -1;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("mowing.in"));
        PrintWriter output = new PrintWriter("mowing.out");


        // we need to take in the input, but make the arrays work out nice
        // well if we do a 3000 by 3000 thing, then ofc we're fine

        int n = input.nextInt();
        input.nextLine();
        int[][] lawn = new int[21 * n + 20][21 * n + 20]; // not the problem
        // each value is initially 0
        for (int i = 0; i < lawn.length; i++) { //
            for (int j = 0; j < lawn[0].length; j++) {//
                lawn[i][j] = 0;
            }
        }
        
        int xPosition = 10 * n;
        int yPosition = 10 * n;
        String direction = "";
        int distance = 0;
        
        boolean seenBefore = false;

        for (int i = 0; i < n; i++) {
            direction = input.next();
            distance = input.nextInt();
            input.nextLine();
            //output.println(distance + " " + direction);
            

            switch (direction) {
                case "N":
                    for (int j = 1; j <= distance; j++) {
                        yPosition++;
                        Helper(lawn, xPosition, yPosition, direction, output);
                        
                        lawn[xPosition][yPosition] = time;
                        time++;
                    }
                    break;
                case "S":
                    for (int j = 1; j <= distance; j++) {
                        yPosition--;
                        Helper(lawn, xPosition, yPosition, direction, output);
                        
                        lawn[xPosition][yPosition] = time;
                        time++;
                    }
                    break;
                case "W":
                    for (int j = 1; j <= distance; j++) {
                        xPosition--;
                        Helper(lawn, xPosition, yPosition, direction, output);
                        
                        lawn[xPosition][yPosition] = time;
                        time++;
                    }
                    break;
                case "E":
                    for (int j = 1; j <= distance; j++) {
                        xPosition++;
                        Helper(lawn, xPosition, yPosition, direction, output);
                        
                        lawn[xPosition][yPosition] = time;
                        time++;
                    }
                    break;
                default:
                    break;
            }
        }

        output.println(maxX);
        output.close();
    }

    private static void Helper(int[][]lawn, int xPosition, int yPosition, String direction, PrintWriter output)
    {
        boolean seenBefore = (lawn[xPosition][yPosition] > 0);
        if (seenBefore) {
            // we know maxX can't be -1 // so what should it be? if it was last cut at time lawn[xPosition][yPosition],
            // and we know that it is seen at time
            // thus, maxX <= time - lawn[xPosition][yPosition]
            if (maxX != -1) {
                maxX = Math.min(maxX, time - lawn[xPosition][yPosition]);
                //output.println(direction + maxX + " " + time + " " + lawn[xPosition][yPosition]);
            } else {
                maxX = time - lawn[xPosition][yPosition];
                //output.println(direction + maxX + " " + time + " " + lawn[xPosition][yPosition]);
            }
        }
    }
}
