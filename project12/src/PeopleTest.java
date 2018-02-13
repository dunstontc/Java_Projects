import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class PeopleTest {

  private void run() {
    boolean debug = true;
    ArrayList<Person> people = new ArrayList<>();
    try {
      Scanner input = new Scanner(new File("people.data"));
      while (input.hasNext()) {
        /* Get the type code from input information. */
        String typeCode = input.next();
        /* Declare a 'person' variable; to be defined later. */
        Person p = null;
        /* Process the input based on the type code which we just read. */
        switch (typeCode) {
          case "p":
            p = new Professor(
              input.nextLong(), // ssnum
              input.next(),     // name
              input.next());    // subject
            break;
          case "u":
            p = new UnderGradStudent(
              input.nextLong(), // ssnum
              input.next(),     // name
              input.nextLong(), // studnum
              input.next());    // major
            break;
          case "m":
            p = new MastersDegreeStudent(
              input.nextLong(), // ssnum
              input.next(),     // name
              input.nextLong(), // studnum
              input.next(),     // degfrom
              input.next());    // thesis
            break;
          case "d":
            p = new DoctoralDegreeStudent(
              input.nextLong(), // ssnum
              input.next(),     // name
              input.nextLong(), // studnum
              input.next(),     // degfrom
              input.next());    // dissertation
            break;
          default:
            System.err.println("Invalid typeCode during input");
        }
        /* Save the 'person' in the 'people' list. */
        if (debug) {
          /* While debugging, the object could be null; don't add nulls. */
          if (p != null) people.add(p);
        } else {
          people.add(p);
        }
      }

      /* Sort the list of People objects. */
      /* The People objects may be sorted because the class implements  */
      /* the Comparable interface. The compareTo method required by the */
      /* interface specifies how the objects are to be ordered.         */
      /* ========== Add code here. Only 1 line is required. ========== */
      // public static <T extends Comparable<? super T>> void sort(List<T> list)
      Collections.sort(people);

      /* Display the information in the 'people' list. */
      for (Person p : people) {
        /* Determine the 'type' of person we are now processing. */
        Class c = p.getClass();
        /* Print the 'type' name and all of the information for this person. */
        System.out.println(c.getName() + ": " + p.toString());
      }
    } catch (Exception e) {
      /* Report any exception which occurs. */
      System.out.println("Error message = " + e.getMessage());
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    PeopleTest application = new PeopleTest();
    application.run();
  }
}
