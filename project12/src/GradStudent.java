public class GradStudent extends Student {
  private String underGradDegreeFrom = null;

  public GradStudent() {
    super();
  }

  public GradStudent(Long socSecNumber, String name, Long studentNumber, String underGradDegreeFrom) {
    super(socSecNumber, name, studentNumber);
    this.underGradDegreeFrom = underGradDegreeFrom;
  }

  public String toString() {
    return super.toString() + "; underGradDegreeFrom=" + underGradDegreeFrom;
  }
}
