import java.io.*;
import java.util.*;

public class SleepingInClass {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		PrintWriter output = new PrintWriter(System.out);

		int t = input.nextInt();
		input.nextLine();
		// do each of the t test cases inside the loop
		int n;
		for (int i = 0; i < t; i++) {
			n = input.nextInt();
			input.nextLine();
			int[] sleepCounts = new int[n];
			for (int j = 0; j < n; j++) {
				sleepCounts[j] = input.nextInt();
			}
			int index = 0;
			int sum = 0;
			input.nextLine();
		}

		output.close();
	}

	public static List<Integer> listDivisors(int number) {
		List<Integer> divisors = new ArrayList<Integer>();
		boolean isSquare = false;

		for (int i = 1; i <= Math.floor(Math.sqrt(number)); i++) {
			if (number % i == 0 && i * i != number) {
				divisors.add(number);
			}
			if (i * i == number) {
				isSquare = true;
			}
		}

		if (number == 1) {
			return divisors;
		} else if (isSquare) {
			for (int i = divisors.size() - 2; i >= 0; i++) {
				divisors.add(number / divisors.get(i));
			}
		} else {

		}

		return divisors;
	}
}
