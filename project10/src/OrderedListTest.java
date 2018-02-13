import java.util.Comparator;
import java.util.Iterator;

public class OrderedListTest {
  private class StringDescendComparator implements Comparator<String> {
    public int compare(String s1, String s2) {
      return 0 - s1.compareTo(s2);
    }
  }

  private class StringAscendComparator implements Comparator<String> {
    public int compare(String s1, String s2) {
      return s1.compareTo(s2);
    }
  }

  private void run() {
    OrderedList<String> ol = new OrderedList<>(new StringAscendComparator());

    ol.add("mmm");
    ol.add("aa5");
    ol.add("aa4");
    ol.add("aa3");
    ol.add("aa2");
    ol.add("aa1");
    ol.add("zzz");

    ol.dump("dump1");

    for (String s : ol) {
      System.out.println("forEach: value=" + s);
    }

    Iterator<String> iter = ol.iterator();
    System.out.printf("iterator: next()=%s\n",iter.next());
    iter.remove();
    ol.dump("dump1.1");

    iter = ol.getBackwardIterator();
    while (iter.hasNext()) {
      System.out.println("BackwardIterator: next()=" + iter.next());
      iter.remove();
    }
    ol.dump("dump1.2");

    System.out.println("-------------------------------------------------------");

    ol = new OrderedList<>(new StringDescendComparator());

    ol.add("mmm");
    ol.add("aaa");
    ol.add("aaa");
    ol.add("zzz");

    ol.dump("dump2");

    System.out.format("remove=%b%n", ol.remove("mmm"));
    ol.dump("dump2.1");

    System.out.format("remove=%b%n", ol.remove("zzz"));
    ol.dump("dump2.2");

    System.out.format("remove=%b%n", ol.remove("aaa"));
    ol.dump("dump2.3");
  }

  public static void main(String[] args) {
    OrderedListTest application = new OrderedListTest();
    application.run();
  }
}
