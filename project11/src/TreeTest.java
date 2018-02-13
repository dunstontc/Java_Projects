import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TreeTest {
  private void run() throws FileNotFoundException {
    /* Construct a Binary Search Tree object. */
    BSTree tree = new BSTree();

    /* Read names and save them in the tree. */
    Scanner input = new Scanner(new File("names.data"));
    while (input.hasNextLine()) {
      String name = input.nextLine().trim();
      tree.add(name);
    }
    input.close();

    /* Dump the tree. */
    tree.dump();
  }

  public static void main(String[] args) throws FileNotFoundException {
    TreeTest application = new TreeTest();
    application.run();
  }
}
