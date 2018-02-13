public class SSLTest {
  private void run() {
    SinglyLinkedList ssl = new SinglyLinkedList();

    for (Integer index = 0; index < 5; index += 1) {
      ssl.add(index);
    }

    ssl.dump((Object data) -> System.out.printf("dump: %d%n", (Integer)data));

    while(!ssl.empty()){
      System.out.printf("----> %d%n", (Integer)ssl.get());
    }

  }

  public static void main(String[] args) {
    SSLTest application = new SSLTest();
    application.run();
  }
}
