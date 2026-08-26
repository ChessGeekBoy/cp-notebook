import java.util.*;
import java.io.*;

public class BovineGenomics {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("cownomics.in"));
        PrintWriter output = new PrintWriter("cownomics.out");
        // n is the number of spotted and plain cows (each)
        int n = input.nextInt();
        // m is the number of characters per line
        int m = input.nextInt();
        input.nextLine();

        // let's use a bitmask for each one?
        // what subset of the base pairs is in each position in the first N lines and in
        // the second N lines
        // for example: all 4 is {true, true, true, true}
        // Let's use the convention ACGT
        // a bitmask is a boolean[4]
        // so the full array is a boolean[m][4]
        boolean[][] spottyGenes = new boolean[m][4];
        boolean[][] plainGenes = new boolean[m][4];
        int plausiblePositions = 0;

        // populating the Spotty Genes
        for (int i = 0; i < n; i++) {
            char[] line = input.nextLine().toCharArray();
            for (int j = 0; j < m; j++) {
                switch (line[j]) {
                    case 'A':
                        spottyGenes[j][0] = true;
                        break;
                    case 'C':
                        spottyGenes[j][1] = true;
                        break;
                    case 'G':
                        spottyGenes[j][2] = true;
                        break;
                    case 'T':
                        spottyGenes[j][3] = true;
                        break;
                    default:
                        break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            char[] line = input.nextLine().toCharArray();
            for (int j = 0; j < m; j++) {
                switch (line[j]) {
                    case 'A':
                        plainGenes[j][0] = true;
                        break;
                    case 'C':
                        plainGenes[j][1] = true;
                        break;
                    case 'G':
                        plainGenes[j][2] = true;
                        break;
                    case 'T':
                        plainGenes[j][3] = true;
                        break;
                    default:
                        break;
                }
            }
        }

        // Now, it's time to compare them
        for (int i = 0; i < m; i++) {
            boolean anyProblems = false;
            for (int j = 0; j < 4; j++) {
                if (plainGenes[i][j] && spottyGenes[i][j]) {
                    anyProblems = true;
                    break;
                }
            }
            if (!anyProblems) {
                // output the position, keeping zero-based
                plausiblePositions++;
            }
        }

        output.println(plausiblePositions);
        output.close();
        input.close();
    }
}
