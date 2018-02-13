public class Queue<T> {

  /* ---------------------------------------------------------------- */
  /* A container for the linked list. */
  private class Node {
    public T data;
    public Node next;

    public Node(T data) {
      this.data = data;
      this.next = null;
    }
  }

  /* ---------------------------------------------------------------- */
  /* Class variables. */
  private Node head;
  private Node tail;
  private int size;

  public Queue() {
    head = tail = null;
    size = 0;
  }

  synchronized public void add(T data) {
    if (head == null) {
      head = tail = new Node(data);
    } else {
      tail.next = new Node(data);
      tail = tail.next;
    }
    size += 1;
  }

  synchronized public boolean isEmpty() {
    return head == null;
  }

  synchronized public int size() {
    return size;
  }

  synchronized public T remove() {
    T result;
    if (head == null) {
      result = null;
    } else {
      result = head.data;
      head = head.next;
      size -= 1;
    }
    return result;
  }
}
