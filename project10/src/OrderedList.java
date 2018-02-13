import java.util.Comparator;
import java.util.Iterator;

public class OrderedList<T> implements Iterable<T> {

  private class Node {
    T data;
    Node next;
    Node prev;

    Node(T data) {
      this.data = data;
      next = prev = null;
    }
  }

  private class ForwardIterator implements Iterator<T> {
    private OrderedList<T> ol;
    private Node p;
    private Node lastNext;

    ForwardIterator(OrderedList<T> ol) {
      this.ol = ol;
      p = head;
      lastNext = null;
    }

    public boolean hasNext() {
      return p != null;
    }

    /**
     * Returns true if the iteration has more elements.
     * @return boolean
     */
    public T next() {
      T result = p == null ? null : p.data;
      lastNext = p;
      p = p == null ? null : p.next;
      return result;
    }

    public void remove() {
      ol.remove(lastNext);
    }
  }

  private class BackwardIterator implements Iterator<T> {
    /* ========== Add code here. ========== */
    private OrderedList<T> ol;
    private Node p;
    private Node lastPrev;

    BackwardIterator(OrderedList<T> ol) {
      this.ol = ol;
      p = tail;
      lastPrev = null;
    }

    public boolean hasNext() {
      return p != null;
    }

    public T next() {
      T result = p == null ? null : p.data;
      lastPrev = p;
      p = p == null ? null : p.next;
      return result;
    }

    public void remove() {
      ol.remove(lastPrev);
    }
  }

  private Node head;
  private Node tail;
  private Comparator<T> cmp;

  /**
   * Constructor.
   * @param cmp a Comparator object which is used to order the data items within the list.
   */
  public OrderedList(Comparator<T> cmp) {
    head = tail = null;
    this.cmp = cmp;
  }

  public void add(T data) {
    // Is the list empty?
    if (head == null) {
      // Yes... so change that.
      head = tail = new Node(data);
    } else {
      // Find the insert point within the list.
      Node newNode = new Node(data);
      Node p = head;
      while (p != null && cmp.compare(newNode.data, p.data) > 0) {
        p = p.next;
      }
      // Add to end of list???
      if (p == null) {
        // Yes.
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
      } else if (p == head) {
        // Insert in front of the current head node.
        head.prev = newNode;
        newNode.next = head;
        head = newNode;
      } else {
        // Insert into the list.
        newNode.next = p;
        newNode.prev = p.prev;
        p.prev.next = newNode;
        p.prev = newNode;
      }
    }
  }

  public Boolean remove(T data) {
    Boolean result = false;
    // Do we have a list?
    if (head != null) {
      // Yes... so try to find the data item.
      Node p = head;
      while (p != null && cmp.compare(p.data, data) != 0) {
        p = p.next;
      }
      // Did we find a match?
      if (p != null) {
        // Yes... so remove it.
        remove(p);
        // Denote the fact that we found and removed the first occurence of data item.
        result = true;
      }
    }
    return result;
  }

  private void remove(Node p) {
    if (p != null) {
      // Yes... so remove it.
      if (p == head && p == tail) {
        head = tail = null;
      } else if (p == head) {
        head.next.prev = null;
        head = head.next;
      } else if (p == tail) {
        tail.prev.next = null;
        tail = tail.prev;
      } else {
        p.next.prev = p.prev;
        p.prev.next = p.next;
      }
    }
  }

  public Iterator<T> getForwardIterator() {
    return new ForwardIterator(this);
  }

  public Iterator<T> getBackwardIterator() {
    return new BackwardIterator(this);
  }

  public Iterator<T> iterator() {
    return new ForwardIterator(this);
  }

  public void dump(String id) {
    Node p = head;
    if (p == null) {
      System.out.printf("%s --> List is empty.\n", id);
    }
    while (p != null) {
      System.out.format("%s --> %s%n", id, p.data.toString());
      p = p.next;
    }
  }
}
