public class Professor extends Person {
  private String discipline = null;

  public Professor() {
    super();
  }

  public Professor(Long socSecNumber, String name, String discipline) {
    super(socSecNumber, name);
    this.discipline = discipline;
  }

  public String toString() {
    return super.toString() + "; discipline=" + discipline;
  }
}
