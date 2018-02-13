public class Person implements Comparable {
  private String name = null;
  private Long socSecNumber = null;

  public Person() {
  }

  public Person(Long socSecNumber, String name) {
    this.socSecNumber = socSecNumber;
    this.name = name;
  }

  public String toString() {
    return "socSecNumber=" + socSecNumber + "; name=" + name;
  }

  public int compareTo(Object o) {
    return name.compareTo(((Person) o).name);
  }
}
