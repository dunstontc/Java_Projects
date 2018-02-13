public class UnderGradStudent extends Student {
  private String major = null;

  public UnderGradStudent() {
    super();
  }

  public UnderGradStudent(Long socSecNumber, String name, Long studentNumber, String major) {
    super(socSecNumber, name, studentNumber);
    this.major = major;
  }

  public String toString() {
    return super.toString() + "; major=" + major;
  }
}
