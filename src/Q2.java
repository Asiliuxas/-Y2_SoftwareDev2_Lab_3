import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File(".\\content\\Lab 3.txt");
        Scanner sc = new Scanner(f);
        String contents = "";
        while(sc.hasNextLine())
            contents+=sc.nextLine();
        String words[] = contents.split(" ");
        int vowels = 0;
        for (char c : contents.toLowerCase().toCharArray()){
            if (c=='e'||c=='u'||c=='i'||c=='o'||c=='a')
                vowels++;
        }
        System.out.printf("Text file contains %d vowels, and average of %.3f vowel per word.",vowels,(float)vowels/words.length);
    }
}
