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

public class HandlebarsTest {

  private class SalesInfoContainer{

    private String salesOrderNum;
    private int storeId;
    private String poNum;
    private Date salesDate;

    public String getSalesOrderNum() {
      return salesOrderNum;
    }

    public int getStoreId() {
      return storeId;
    }

    public String getPoNum() {
      return poNum;
    }

    public Date getSalesDate() {
      return salesDate;
    }

    SalesInfoContainer(String salesOrderNum, int storeId, String poNum, Date salesDate){
      this.salesOrderNum= salesOrderNum;
      this.storeId= storeId;
      this.poNum= poNum;
      this.salesDate= salesDate;
    }
  }

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
      ResultSet result = stmnt.executeQuery("select sonum,stor_id,ponum,sdate from sales order by sdate");

      /* Do we have a result set? */
      if (result != null) {
        // Process each result tuple. Save information is an array of objects.
        ArrayList<SalesInfoContainer> salesList= new ArrayList<>();
        while (result.next()) {
          salesList.add(new SalesInfoContainer(result.getString("sonum"), result.getInt("stor_id"), result.getString("ponum"), result.getDate("sdate")));
        }
        SalesInfoContainer[] salesArray= new SalesInfoContainer[]{};
        salesArray = salesList.toArray(salesArray);

        // Create instance of Handlebars template engine.
        Handlebars handlebars = new Handlebars();

        // Read the template file.
        BufferedReader buf = new BufferedReader(new InputStreamReader(new FileInputStream("templates/hbTest.hbs")));
        String line = buf.readLine();
        StringBuilder sb = new StringBuilder();
        while (line != null) {
          sb.append(line).append("\n"); // Note: The newline is added so output is easy to read.
          line = buf.readLine();
        }

        // Compile the template information. Extract the template string from the StringBuilder.
        Template template = handlebars.compileInline(sb.toString());

        // Define the context in which the template is rendered.
        HashMap<String, SalesInfoContainer[]> contextMap= new HashMap<>();
        contextMap.put("salesArray", salesArray); // Place the data array into the context map.
        Context context = Context
          .newBuilder(contextMap)
          .resolver(MapValueResolver.INSTANCE, JavaBeanValueResolver.INSTANCE)
          .build();

        // Print the result of applying the template to the context.
        System.out.println(template.apply(context));
      } else {
        System.out.println("Bad query; no result set from query command.");
      }
    }
  }

  public static void main(String[] args) throws Exception {
    HandlebarsTest application = new HandlebarsTest();
    application.run();
  }
}
