import com.google.gson.Gson;
import sun.net.www.protocol.http.HttpURLConnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Date;

public class HttpExample {
  private void run1() throws Exception {
    URL url = new URL("http://localhost:9000/project17_html");
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");
    con.setRequestProperty("Content-Type", "text/html");

    // Report the request status.
    System.out.printf("status=%d%n", con.getResponseCode());

    // Display the response content if the status was good.
    if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
      BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
      String inputLine;
      StringBuilder content = new StringBuilder();
      while ((inputLine = in.readLine()) != null) {
        content.append(inputLine).append("\n"); // Add a newline so that output is easy to read.
      }
      in.close();
      System.out.printf("content= %s%n", content.toString());
    }

    // Terminate the connection.
    con.disconnect();
  }

  private class JSONObj {
    String message;
    Date when;

    JSONObj(String msg) {
      this.message = msg;
      this.when = new Date();
    }
  }

  private void run2() throws Exception {
    URL url = new URL("http://localhost:9000/project17_json");
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");
    con.setRequestProperty("Content-Type", "application/json");

    // Report the request status.
    System.out.printf("status=%d%n", con.getResponseCode());

    // Display the response content if the status was good.
    if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
      BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
      String inputLine;
      StringBuilder content = new StringBuilder();
      while ((inputLine = in.readLine()) != null) {
        content.append(inputLine);
      }
      in.close();
      Gson gson = new Gson();
      JSONObj jsonObj = gson.fromJson(content.toString(), JSONObj.class);
      System.out.printf("content= %s%n", content.toString());
      System.out.printf("jsonObj.message= %s%n", jsonObj.message);
      System.out.printf("jsonObj.when= %s%n", jsonObj.when);
    }

    // Terminate the connection.
    con.disconnect();
  }

  public static void main(String[] args) throws Exception {
    HttpExample application = new HttpExample();
    application.run1();
    application.run2();
  }
}
