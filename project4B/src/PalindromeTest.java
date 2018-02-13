import java.util.Scanner;

public class PalindromeTest {
  private boolean PalindromeTestR(String word, int left, int right) {
    boolean result = true;
    if (left < right) {
      result = word.charAt(left) == word.charAt(right) && PalindromeTestR(word, left + 1, right - 1);
    }
    return result;
  }

  private void run() {
    /* Ask the user for test word. */
    System.out.println("Please enter the word to be tested.");

    /* Read the input value. */
    Scanner input = new Scanner(System.in);
    String word = input.next();
    input.close();

    /* Is the word a palindrome? */
    boolean palindrome = PalindromeTestR(word, 0, word.length() - 1);

    /* Print the results. */
    System.out.format("The test for %s is %b.%n", word, palindrome);
  }

  public static void main(String[] args) {
    PalindromeTest application = new PalindromeTest();
    application.run();
  }
}
