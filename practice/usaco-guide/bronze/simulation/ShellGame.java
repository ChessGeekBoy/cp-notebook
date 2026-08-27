import java.io.*;
import java.util.*;

public class ShellGame {
    public static void main(String[] args) throws IOException {
        File myObj = new File("shell.in");
        Scanner input = new Scanner(myObj);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shell.out")));
        int swapCount = input.nextInt();
        int[] swapsAndGuesses = new int[3 * swapCount];
        for (int i = 0; i < swapCount; i++) {
            swapsAndGuesses[3 * i] = input.nextInt();
            swapsAndGuesses[3 * i + 1] = input.nextInt();
            swapsAndGuesses[3 * i + 2] = input.nextInt();
        }

        int scoreOne = giveScore(1, swapCount, swapsAndGuesses);
        int scoreTwo = giveScore(2, swapCount, swapsAndGuesses);
        int scoreThree = giveScore(3, swapCount, swapsAndGuesses);
        
        pw.println(Math.max(scoreOne, Math.max(scoreTwo, scoreThree)));

        pw.close();
    }

    public static int giveScore(int position, int swapCount, int[] swapsAndGuesses){
        int score = 0;//

        for (int i = 0; i < swapCount; i++) {
            int guess = swapsAndGuesses[3 * i + 2];
            if (position == swapsAndGuesses[3 * i]) {
                position = swapsAndGuesses[3 * i + 1];
            }
            else if (position == swapsAndGuesses[3 * i + 1]) {
                position = swapsAndGuesses[3 * i];
            }

            if (position == guess) {
                score++;
            }
        }

        return score;
    }
}