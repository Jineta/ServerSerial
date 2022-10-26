import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    static final int SERVER_PORT = 4343;
    public ClientHandler clientHandler;
    public Server() {

        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("got connection");
                Thread t = new Thread(new ClientHandler(clientSocket,this));
                t.start();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {

        Server server = new Server();
        //server.clientHandler.readAndReturnToClient();
    }

}
