import java.net.ServerSocket;
import java.net.Socket;

public class ServerObject {
    static final int SERVER_PORT = 4343;
   // public ClientHandler clientHandler;
    public ServerObject() {
             // while (true) {
        try {
                ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
                Socket clientSocket = serverSocket.accept();
                System.out.println("got connection with server");
                ClientHandler c1 = new ClientHandler(clientSocket, this);
                c1.readFromClient();
            c1.sendAllToClient();
           // }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
    }
    public static void main(String[] args) throws Exception {

        ServerObject server = new ServerObject();
//server.clientHandler.readFromClient();
//server.clientHandler.sendToClient();
    }

}
