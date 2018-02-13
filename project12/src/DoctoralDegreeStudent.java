public class DoctoralDegreeStudent extends GradStudent {
  private String dissertationTitle = null;

  public DoctoralDegreeStudent() {
    super();
  }

  public DoctoralDegreeStudent(Long socSecNumber,
                               String name,
                               Long studentNumber,
                               String underGradDegreeFrom,
                               String dissertationTitle) {
    super(socSecNumber, name, studentNumber, underGradDegreeFrom);
    this.dissertationTitle = dissertationTitle;
  }

  public String toString() {
    return super.toString() + "; dissertationTitle=" + dissertationTitle;
  }
}
