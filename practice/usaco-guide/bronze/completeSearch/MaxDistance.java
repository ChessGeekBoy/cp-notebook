import java.util.*;
import java.io.*;

public class MaxDistance {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		PrintWriter output = new PrintWriter(System.out);

		int n = input.nextInt();
		int[][] points = new int[n][2];
		for (int i = 0; i < n; i++) {
			points[i][0] = input.nextInt();
		}
		input.nextLine();
		for (int i = 0; i < n; i++) {
			points[i][1] = input.nextInt();
		}
		int squareMaxDistance = 0;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int distance = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
				squareMaxDistance = Math.max(squareMaxDistance, distance);				
			}
		}

		output.println(squareMaxDistance);
		output.close();
		input.close();
	}
}
