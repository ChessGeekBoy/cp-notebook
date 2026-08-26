import java.io.*;
import java.util.*;

public class CircleCross {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("circlecross.in"));
        PrintWriter output = new PrintWriter("circlecross.out");

        int total = 0;
        int[][] data = new int[26][2];
        for (int i = 0; i < 26; i++) {
            data[i][0] = 30;
            data[i][1] = 30;
        }
        String crossingsString = input.nextLine();
        char[] crossings = crossingsString.toCharArray();
        for (int index = 0; index < crossingsString.length(); index++) {
            int cowIndex = crossings[index] - 'A';
            if (data[cowIndex][0] != 30) {
                data[cowIndex][1] = index;
            } else {
                data[cowIndex][0] = index;
            }
        }

        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                // check if the parentheses intersect
                if (data[i][0] < data[j][0] && data[j][0] < data[i][1] && data[i][1] < data[j][1]) {
                    total++;
                } else if (data[j][0] < data[i][0] && data[i][0] < data[j][1] && data[j][1] < data[i][1]) {
                    total++;
                }
            }
        }

        output.println(total);
        output.close();
        input.close();
    }
}