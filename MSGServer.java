import java.io.*;
import java.net.*;
import java.util.concurrent.TimeUnit;
import java.lang.InterruptedException;

public class MSGServer {

    public MSGServer(int port) throws InterruptedException {
      try (ServerSocket serverSocket = new ServerSocket(port)) {

          System.out.println("Server is listening on port " + port);

          while (true) {
              Socket socket = serverSocket.accept();

              System.out.println("New client connected");
              
              InputStream input = socket.getInputStream();

              OutputStream output = socket.getOutputStream();
              PrintWriter writer = new PrintWriter(output, true);

              writer.println("HELLO");

          }

      } catch (IOException ex) {
          System.out.println("Server exception: " + ex.getMessage());
          ex.printStackTrace();
      }
   }
}

