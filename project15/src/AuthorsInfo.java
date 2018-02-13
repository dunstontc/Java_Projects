import com.github.jknack.handlebars.Context;
import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.context.JavaBeanValueResolver;
import com.github.jknack.handlebars.context.MapValueResolver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class AuthorsInfo {

  private void run() throws Exception {
    /* Load the database driver. */
    Class.forName("org.postgresql.Driver");

    try (
      /* Establish a connection to the database. */
      Connection con = DriverManager.getConnection("jdbc:postgresql://cloud2.lp1241.us/bookbiz", "truecoders", "yacc912");

      /* Create a statement object by which SQL commands may be issued. */
      Statement stmnt = con.createStatement()

    ) {
      /* Execute the SQL query command. */
      ResultSet result = stmnt.executeQuery("select au_id,au_lname,au_fname,phone,address,city,state,zip from authors order by au_lname");
    }
//    /* Close the SQL statement object. */
//    stmnt.close();

//    /* Close the database connection. */
//    con.close();
  }

  public static void main(String[] args) throws Exception {
    AuthorsInfo application = new AuthorsInfo();
    application.run();
  }
}
