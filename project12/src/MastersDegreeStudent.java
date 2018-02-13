public class MastersDegreeStudent extends GradStudent {
  private String thesisTitle = null;

  public MastersDegreeStudent() {
    super();
  }

  public MastersDegreeStudent(Long socSecNumber,
                              String name,
                              Long studentNumber,
                              String underGradDegreeFrom,
                              String thesisTitle) {
    super(socSecNumber, name, studentNumber, underGradDegreeFrom);
    this.thesisTitle = thesisTitle;
  }

  public String toString() {
    return super.toString() + "; thesisTitle=" + thesisTitle;
  }
}
