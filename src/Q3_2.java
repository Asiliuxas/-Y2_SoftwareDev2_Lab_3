import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Improved word jumbler that consider punctuation such as : " . , ' ; : ? ! " before and after String to not be considered part of the word
 */
public class Q3_2 {
    /**
     * Will jumble up String that is longer than 4 letters
     * Will ignore punctuation that comes before and after the word but not in it.
     * @param word Valid word to be jumbled up
     * @return  Jumbled up word
     */
    public static String jumbleValid(String word){
        int start = 0, finish = word.length()-1;
        char c;
        if(finish>2){       //  Ensure that string is at least long enough to begin with
            for (int i = 0; i < word.length(); i++){
                c =  word.charAt(i);
                if (c == 44 || c == 46 || c == 39 || c == 58 || c == 59 || c == 63 || c == 33){     //  check for , . ' ; : ? !
                    if (i == start)     //  adjust starting position of string if punctuation is found
                        start++;
                    else if (i == finish) {     //  adjust finishing position of string if punctuation is found
                        i-=2;       //  Backtrack to check for consecutive symbols
                        finish--;
                    }
                }
            }
            if (finish-start > 2){      //  Check if word is long enough
                char letters[] = word.toCharArray(), letter;        //  Convert word to char array and temp letter
                int index;      //  Keep index for moving letters around
                for (int i = start+1; i < finish; i++){       //  Loop through valid string
                    index = (int)(Math.random()*(finish-start-1)+start+1);        // Randomize position within the valid string
                    letter = letters[i];
                    letters[i] = letters[index];
                    letters[index] = letter;
                }
                return String.valueOf(letters);     //  Return jumbled word
            }
        }
        return word;        //  Return original word if it was not valid
    }
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "Lab 3";      //  File Name
        File f = new File(".\\content\\"+fileName+".txt");
        Scanner sc = new Scanner(f);
        String contents = "";       //  Establish and create String contained within the file
        while(sc.hasNextLine())
            contents+=sc.nextLine();
        String words[] = contents.split(" ");       //  Dissect string into individual words
        int charCount = 0;      //  Establish counter for boot leg word wrap
        for (String w : words){
            charCount += w.length()+1;        //  Increment counter by char count and include the space that follows the word
            if (charCount > 200){       //  Check if its long enough to be wrapped
                System.out.println();
                charCount = w.length()+1;
            }
            System.out.print(jumbleValid(w)+" ");       //  Print out jumbled words followed by space
        }
    }
}
