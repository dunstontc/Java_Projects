import java.util.Scanner;
import java.io.File;

public class WordCount {
    private void run() throws Exception {

        String filePath = "project2.data";
        try (Scanner input = new Scanner(new File(filePath))) {
            int wordCount = 0;
            while (input.hasNext()) {
                String word = input.next().toLowerCase();
                if (word.length() > 1) {
                    if (word.charAt(word.length()-1) == word.charAt(word.length()-2)) {
                        wordCount += 1;
                    }
                }
            }
            System.out.printf("Word count = %d.%n", wordCount);
        }

    }

    public static void main(String[] args) throws Exception {
        WordCount application = new WordCount();
        application.run();
    }
}
