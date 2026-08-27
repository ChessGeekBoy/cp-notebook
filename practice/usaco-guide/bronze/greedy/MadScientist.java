import java.io.*;
import java.util.*;

public class MadScientist {
	public static void main(String[] args) throws Exception {
		// Idea: just flip the longest strings you can without "messing things up"
		Scanner input = new Scanner(new File("breedflip.in"));
		PrintWriter output = new PrintWriter("breedflip.out");
		int n = input.nextInt();
		input.nextLine();
		String a = input.nextLine();
		String b = input.nextLine();
		boolean[] isSame = new boolean[n];
		for (int i = 0; i < n; i++) {
			isSame[i] = (a.substring(i, i + 1)).equals(b.substring(i, i + 1));
		}
		int moveCount = 0;
		boolean previous = true;
		for (int i = 0; i < n; i++) {
			if (!isSame[i] && previous) {
				moveCount++;
			}
			previous = isSame[i];
		}	
		output.println(moveCount);
		output.close();
		input.close();
	}
	
	// FTFFTTT  (clearly the answer is 2)
	// but my code (and my algorithm) give an answer of 4 (at least currently)
	// We jsut want the number of blocks of falses, right?
	// try something like:
	// if (!current && previous), then moveCount++
}
