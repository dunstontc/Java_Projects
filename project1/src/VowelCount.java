import java.util.Scanner;
import java.io.File;
import java.util.regex.Pattern;

public class VowelCount {
    private void run() throws Exception {

        String filePath = "project1.data";
        try (Scanner input = new Scanner(new File(filePath))) {
            int vowelCount = 0;
            while (input.hasNext()) {
                boolean vowelFound = false;
                String word = input.next().toLowerCase();
                for (int pos = 0; (!vowelFound && pos < word.length()); pos++) {
                    char c = word.charAt(pos);
                    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                        vowelCount += 1;
                        vowelFound = true;

                    }
                }
            }
            System.out.printf("Vowel count = %d.%n", vowelCount);
        }

    }

    public static void main(String[] args) throws Exception {
        VowelCount application = new VowelCount();
        application.run();
    }
}
