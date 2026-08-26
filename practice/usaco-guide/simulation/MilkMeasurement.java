import java.util.*;
import java.io.*;

class MilkMeasurement {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("measurement.in"));
		PrintWriter output = new PrintWriter("measurement.out");
		

		int[][] milkChanges = new int[100][2];
		int n = input.nextInt();
		input.nextLine();
		for (int i = 0; i < n; i++) {
			int index = input.nextInt() - 1;
			String cow = input.next();
			int amount = input.nextInt();			
			input.nextLine();
			
			switch (cow) {
				case "Mildred":
					milkChanges[index][0] = 0;
					milkChanges[index][1] = amount;
					break;
				case "Elsie":
					milkChanges[index][0] = 1;
					milkChanges[index][1] = amount;
					break;	
				case "Bessie":
					milkChanges[index][0] = 2;
					milkChanges[index][1] = amount;
					break;			
				default:
					break;
			}
		}	

		int mildredSum = 7;
		int elsieSum = 7;
		int bessieSum = 7;
		int currentMaxCow = 7;
		int changeCount = 0;
		boolean mildredMax = true;
		boolean elsieMax = true;
		boolean bessieMax = true;

		for (int i = 0; i < milkChanges.length; i++) {
			int cow = milkChanges[i][0];
			int change = milkChanges[i][1];
			switch (cow) {
				case 0:
					mildredSum += change;
					break;
				case 1:
					elsieSum += change;
					break;
				case 2:
					// this is bessie
					bessieSum += change;
					break;
				default:
					break;
			}

			currentMaxCow = Math.max(Math.max(elsieSum, bessieSum), mildredSum);
			if (bessieMax != (bessieSum == currentMaxCow) || mildredMax != (mildredSum == currentMaxCow) || elsieMax != (elsieSum == currentMaxCow)) {
				changeCount++;
			}
			bessieMax = (bessieSum == currentMaxCow);
			elsieMax = (elsieSum == currentMaxCow);
			mildredMax = (mildredSum == currentMaxCow);
		}

		output.println(changeCount);
		output.close();
	}
}
