import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient4_2 {
  public static void main(String[] args) throws Exception {
    String hostname = "localhost";

    Socket theSocket = new Socket(hostname, 8181);
    BufferedReader networkIn = new BufferedReader(new InputStreamReader(theSocket.getInputStream()));
    BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(theSocket.getOutputStream());
    System.out.println("Connected to echo server");
    

    while (true) {
      String theLine = userIn.readLine();
      if (theLine.equals("."))
        break;
      out.println(theLine);
      out.flush();
      System.out.println(networkIn.readLine());
     
      System.out.println(theSocket.getInetAddress());
      
    
      
    }
    networkIn.close();
    out.close();
  }
}
