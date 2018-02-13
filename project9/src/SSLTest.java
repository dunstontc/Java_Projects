import java.util.Iterator;

public class SSLTest {
  private void run() {
    SinglyLinkedList<Integer> ssl = new SinglyLinkedList<>();

    for (Integer index = 0; index < 5; index += 1) {
      ssl.add(index);
    }

    Iterator<Integer> iter = ssl.getIterator();
    while (iter.hasNext()) {
      System.out.println("-1->" + iter.next());
    }

    System.out.println("----------------------------------------");
    iter = ssl.getIterator();
    System.out.println("-->" + iter.next());
    System.out.println("-->" + iter.next());
    iter.remove();
    System.out.println("-->" + iter.next());
    iter.remove();
    iter.remove();
    System.out.println("-->" + iter.next());
    iter.remove();
    System.out.println("-->" + iter.next());

    System.out.println("----------------------------------------");
    iter = ssl.getIterator();
    while (iter.hasNext()) {
      System.out.println("-2->" + iter.next());
    }

  }

  public static void main(String[] args) {
    SSLTest application = new SSLTest();
    application.run();
  }
}
