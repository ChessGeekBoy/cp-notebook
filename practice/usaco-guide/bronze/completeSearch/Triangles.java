import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Triangles {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("triangles.in"));
        PrintWriter output = new PrintWriter("triangles.out");

        int n = input.nextInt();
        int[][] points = new int[n][2];
        int doubleMaxArea = 0;

        for (int i = 0; i < n; i++) {
            points[i][0] = input.nextInt();
            points[i][1] = input.nextInt();

        }

        for (int i = 0; i < n; i++) {
            int maxX = 0;
            int maxY = 0;
            int[] vertex = points[i];
            for (int j = 0; j < n; j++) {
                int[] point = points[j];
                if (point[0] == vertex[0]) {
                    maxY = Math.max(maxY, Math.abs(point[1] - vertex[1]));
                }
                else if (point[1] == vertex[1]) {
                    maxX = Math.max(maxX, Math.abs(point[0] - vertex[0]));
                }
            }
            doubleMaxArea = Math.max(doubleMaxArea, maxX * maxY);
        }
        output.println(doubleMaxArea);
        output.close();
    }
}