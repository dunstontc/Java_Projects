import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class SalesInfo {
    private void run() throws Exception {
        /* Load the database driver. */
        Class.forName("org.postgresql.Driver");

        /* Establish a connection to the database. */
        Connection con = DriverManager.getConnection("jdbc:postgresql://cloud2.lp1241.us/bookbiz", "truecoders", "yacc912");

        /* Create a statement object by which SQL commands may be issued. */
        Statement stmnt = con.createStatement();

        /* Execute the SQL query command. */
        ResultSet result = stmnt.executeQuery("select * from sales");

        /* Do we have a result set? */
        if (result != null) {
            /* Process each result tuple. */
            while (result.next()) {
                System.out.printf("Source Number: %s -- ", result.getString("sonum"));
                System.out.printf("Store Id: %s -- ", result.getString("stor_id"));
                System.out.printf("ponum: %s -- ", result.getString("ponum"));
                System.out.printf("Sale Date: %s\n", result.getString("sdate"));
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
        SalesInfo application = new SalesInfo();
        application.run();
    }
}
