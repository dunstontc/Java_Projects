//    add - adds an 'int' into the list.
//    get - removes the first element in the list and returns the value to the caller.
//    empty - returns true if the list contains no data.
//    dump - prints all values in the list to stdout.

import java.util.Arrays;

public class SinglyLinkedList {
  /* ---------------------------------------------------------------- */
  /* A container for the linked list. */
  private class Node {
    int data;
    Node next;

    Node(int data) {
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

  public void add(int data) {
    if (head == null) {
      head = tail = new Node(data);
    } else {
      tail.next = new Node(data);
      tail = tail.next;
    }
  }

  public int get() {
    int value = head.data;
    head = head.next;
    return value;
  }

  void dump() {
    while (this.head != null) {
      int cur = this.get();
      System.out.printf("%d\n", cur);
    }
  }

  boolean empty() {
    return head == null;
  }
}
