import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Date;

public class HttpServerExample {
  private class RootHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange he) throws IOException {
      String response = "<p>Server start success if you see this message</p>";
      he.sendResponseHeaders(200, response.length());
      OutputStream os = he.getResponseBody();
      os.write(response.getBytes());
      os.close();
    }
  }

  private class Project17Html implements HttpHandler {
    @Override
    public void handle(HttpExchange he) throws IOException {
      String response = "<html><body><p>Project17 response.</p></body></html>";
      he.sendResponseHeaders(200, response.length());
      OutputStream os = he.getResponseBody();
      os.write(response.getBytes());
      os.close();
    }
  }

  private class JSONObj {
    String message;
    Date when;

    JSONObj(String msg) {
      this.message = msg;
      this.when = new Date();
    }
  }

  private class Project17JSON implements HttpHandler {
    @Override
    public void handle(HttpExchange he) throws IOException {
      Gson gson = new Gson();
      String response = gson.toJson(new JSONObj("This is a test."));
      he.setAttribute("Content-Type", "application/json");
      he.sendResponseHeaders(200, response.length());
      OutputStream os = he.getResponseBody();
      os.write(response.getBytes());
      os.close();
    }
  }

  private void run(int port) throws Exception {
    HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
    System.out.printf("Server started using port %d.", port);
    server.createContext("/", new RootHandler());
    server.createContext("/project17_html", new Project17Html());
    server.createContext("/project17_json", new Project17JSON());
    server.setExecutor(null);
    server.start();
  }

  public static void main(String[] args) throws Exception {
    HttpServerExample application = new HttpServerExample();
    application.run(9000);
  }
}
