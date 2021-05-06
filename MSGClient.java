import java.net.*;
import java.io.*;

public class MSGClient {

    public static void main(String[] args) {
    	System.out.println("Called main");
        
        
 
        String hostname = "192.168.1.122";
        int port = 5050;
        boolean connected = true;
        while (connected) {

            try (Socket socket = new Socket(hostname, port)) {
            	
            	System.out.println("Atempting Connection to:" + hostname);

                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                String time = reader.readLine();

                System.out.println(time);


            } catch (UnknownHostException ex) {

                System.out.println("Server not found: " + ex.getMessage());

            } catch (IOException ex) {

                System.out.println("I/O error: " + ex.getMessage());
            }
			
		}
    }
}

