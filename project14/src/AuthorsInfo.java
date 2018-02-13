import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class AuthorsInfo {
    private void run() throws Exception {
        /* Load the database driver. */
        Class.forName("org.postgresql.Driver");

        /* Establish a connection to the database. */
        Connection con = DriverManager.getConnection("jdbc:postgresql://cloud2.lp1241.us/bookbiz", "truecoders", "yacc912");

        /* Create a statement object by which SQL commands may be issued. */
        Statement stmnt = con.createStatement();

        /* Execute the SQL query command. */
        ResultSet result = stmnt.executeQuery(" SELECT au_fname,au_lname, t.title\n" +
          "FROM authors\n" +
          "JOIN titleauthors\n" +
          "ON authors.au_id=titleauthors.au_id\n" +
          "JOIN titles AS t\n" +
          "ON t.title_id=titleauthors.title_id\n" +
          "ORDER BY au_lname ");

        /* Do we have a result set? */
        if (result != null) {
            /* Process each result tuple. */
            while (result.next()) {
                System.out.printf("au_fname=%s", result.getString("au_fname"));
                System.out.printf("au_lname=%s", result.getString("au_lname"));
                System.out.printf("title=%s %n", result.getString("title"));
            }
        } else {
            System.out.printf("Bad query; no result set from query command.");
        }

        /* Close the SQL statement object. */
        stmnt.close();

        /* Close the database connection. */
        con.close();
    }

    public static void main(String[] args) throws Exception {
        AuthorsInfo application = new AuthorsInfo();
        application.run();
    }
}