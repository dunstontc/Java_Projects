import java.util.Iterator;

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
  /* An iterator for the list. */
  private class SSLIterator implements Iterator<T> {
    private Node node;
    private SinglyLinkedList<T> sll;
    private Node prev, next, last;

    SSLIterator(SinglyLinkedList<T> sllArg) {
      sll = sllArg;
      node = sll.head;
      prev = next = null;
    }

    /**
     * Returns true if the iteration has more elements.
     */
    public boolean hasNext() {
      return node != null;
    }

    /**
     * Returns the next element in the iteration.
     */
    public T next() {
      T result = null;
      /* Does the list have another node? */
      if (node != null) {
        /* Yes.  Save critical values. */
        prev = last;
        last= node;
        result = node.data;
        next = node.next;
        node = node.next;
      }else{
        next= null;
      }
      return result;
    }

    public void remove() {
      sll.remove(last, prev, next);
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

  public Iterator<T> getIterator() {
    return new SSLIterator(this);
  }

  // Used by iterator.
  private void remove(Node p, Node prev, Node next) {
    // Do we really have a node to delete?
    if (p != null) {
      // ********** Add code here. ********** //
    }
  }
}
