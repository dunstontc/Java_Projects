import java.util.NavigableSet;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.TreeMap;

  /*
   * Download the project named 'project6'.
   * Create a Frequency class which is an application that will perform a frequency analysis of the words found in 'poem.txt'.
   * The application is to print an alphabetical list of the words along with a count of the number of times the word was found within the poem.
   *
   * Additional questions:
   * What is a map?
   * How is a TreeMap different from a Map?
   */
public class Frequency {
  private void run() {
    try {
      Scanner input = new Scanner(new File("poem.txt"));
      TreeMap<String, Integer> treeMap = new TreeMap<>();

      while (input.hasNext()) {
        String word = input.next();
        if(treeMap.containsKey(word)) {
          treeMap.put(word, treeMap.get(word)+ 1);
        } else {
          treeMap.put(word, 1);
        }
      }
      input.close();

      NavigableSet<String> keySet = treeMap.navigableKeySet();
//      System.out.println("Normal order: " + keySet);
      for(String key : keySet) {
        System.out.printf("Word: %s, Count: %d\n", key, treeMap.get(key));
      }



    } catch (FileNotFoundException e) {
      System.out.println("Unable to open input file.");
    }
  }

  public static void main(String[] args) {
    Frequency application = new Frequency();
    application.run();
  }
}
