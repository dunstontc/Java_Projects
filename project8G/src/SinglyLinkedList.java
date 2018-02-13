
public class SinglyLinkedList<T> {

  /* ---------------------------------------------------------------- */
  /* A container for the linked list. */
  private class Node {
    T data;
    Node next;

    Node(T data) {
      this.data = data;
      this.next = null;
    }
  }

  /* ---------------------------------------------------------------- */
  /* Class variables. */
  private Node head;
  private Node tail;

  public SinglyLinkedList() {
    head = tail = null;
  }

  public void add(T data) {
    if (head == null) {
      head = tail = new Node(data);
    } else {
      tail.next = new Node(data);
      tail = tail.next;
    }
  }

  public T get() {
    T value = head.data;
    head = head.next;
    return value;
  }

  void dump(DumpOperator dop) {
    Node p = head;
    while (p != null) {
      dop.dmp(p.data);
      p = p.next;
    }
  }

  boolean empty() {
    return head == null;
  }
}
