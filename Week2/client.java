import java.io.*;
import java.net.*;
public class client {
    public static void main(String[] args) {
        String serverAddress = "localhost";  // Server address
        int port = 12345;                   // Server port

        try {
            // Create a Socket object to connect to the server
            Socket socket = new Socket(serverAddress, port);
            System.out.println("Connected to the server");

            // Create input and output streams to communicate with the server
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            String userMessage;
            String serverResponse;

            // Send messages to the server
            while (true) {
                System.out.print("Enter message to send to server: ");
                userMessage = userInput.readLine();
                output.println(userMessage);  // Send user input to the server

                // Read server's response
                serverResponse = input.readLine();
                System.out.println("Server: " + serverResponse);

                if (userMessage.equalsIgnoreCase("exit")) {
                    break;  // Exit the loop if the user types "exit"
                }
            }

            // Close the connection
            userInput.close();
            input.close();
            output.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
