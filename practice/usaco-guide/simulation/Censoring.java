import java.io.*;
import java.util.*;

public class Censoring {
   private static  String alphabet = "abcdefghijklmnopqrstuvwxyz";
   public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new FileReader("censor.in"));
    PrintWriter output = new PrintWriter("censor.out");



    // String
    String text = input.readLine();
    String censor = input.readLine();
    // this following code isn't nice because of the 
    // Why don't we convert everything to numbers, and then back?
    /*for (int i = 0; i < text.length() - censor.length(); i++) {
        if (text.substring(i, i + censor.length()).equals(censor)) {
            text = text.substring(0, i) + text.substring(i + censor.length(), text.length());
            i = 0;
        }        
    }*/
    int censorIndex = text.indexOf(censor);
    while (censorIndex != -1) {
        text = text.substring(0, censorIndex) + text.substring(censorIndex + censor.length(), text.length());
        if (censorIndex - censor.length() >= 0) {
            censorIndex = text.indexOf(censor, censorIndex - censor.length());
        }
        else {
            censorIndex = text.indexOf(censor);
        }
    }

    output.println(text);
    output.close();
   } 
}

