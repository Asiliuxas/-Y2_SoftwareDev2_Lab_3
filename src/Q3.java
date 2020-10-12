import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q3 {
    public static String jumble(String word){
        char letters[] = word.toCharArray();
        char letter;
        int index;
        for(int i = 1; i<letters.length-1;i++){
            index = (int)(Math.random()*(letters.length-2)+1);
            letter = letters[i];
            letters[i] = letters[index];
            letters[index] = letter;
        }
        return String.valueOf(letters);
    }
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File(".\\content\\Lab 3.txt");
        Scanner sc = new Scanner(f);
        String contents = "";
        while(sc.hasNextLine())
            contents+=sc.nextLine();
        String words[] = contents.split(" ");
        int charCount = 0;
        for (String w : words){
            charCount += w.length();
            if (charCount > 150){
                System.out.println();
                charCount = w.length();
            }
            if(w.length() > 3)
                System.out.print(jumble(w));
            else
                System.out.print(w);
            System.out.print(" ");
        }
    }
}
