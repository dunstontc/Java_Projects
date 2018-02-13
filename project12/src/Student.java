public class Student extends Person {
  private Long studentNumber = null;

  public Student() {
    super();
  }

  public Student(Long socSecNumber, String name, Long studentNumber) {
    super(socSecNumber, name);
    this.studentNumber = studentNumber;
  }

  public String toString() {
    return super.toString() + "; studentNumber=" + studentNumber;
  }
}
