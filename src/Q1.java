import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File(".\\content\\Lab 3.txt");
        Scanner sc = new Scanner(f);
        String contents = "";
        while(sc.hasNextLine())
            contents+=sc.nextLine();
        String words[] = contents.split(" ");
        System.out.println("The file contains "+words.length+" words.");
    }
}

