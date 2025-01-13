import java.io.*;
import java.net.*;
public class server {
    public static void main(String[] args) {
        // The port the server will listen to
        int port = 12345;
        try {
            // Create a ServerSocket object that listens on port 12345
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Create input and output streams to communicate with the client
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

            String clientMessage;

            // Keep reading messages from the client
            while ((clientMessage = input.readLine()) != null) {
                System.out.println("Client says: " + clientMessage);
                output.println("Server received: " + clientMessage);
            }

            // Close the connection after communication is done
            input.close();
            output.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
