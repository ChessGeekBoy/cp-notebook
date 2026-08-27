import java.util.*;
import java.io.*;

public class BlockGame {
	public static void main(String[] args) throws FileNotFoundException {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		Scanner input = new Scanner(System.in);
		PrintWriter output = new PrintWriter(System.out);

		// input-related things
		int n = input.nextInt();
		input.nextLine();

		int[] letters = new int[26];

		for (int i = 0; i < n; i++) {
			String word1 = input.next();
			String word2 = input.next();
			int[] word1Array = new int[26];
			int[] word2Array = new int[26];

			for (int j = 0; j < word1.length(); j++) {
				word1Array[alphabet.indexOf(word1.substring(j, j + 1))]++;
			}
			for (int j = 0; j < word2.length(); j++) {
				word2Array[alphabet.indexOf(word2.substring(j, j + 1))]++;
			}
			for (int j = 0; j < 26; j++) {
				letters[j] += Math.max(word1Array[j], word2Array[j]);
			}
		}

		for (int i = 0; i < letters.length; i++) {
			output.println(letters[i]);
		}
		output.close();
	}
}
