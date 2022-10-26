import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {
    Socket clientSocket;
    private Server server;
    private ObjectInputStream readerFromInputStream; //сообщение, которое сервер считывает с клиента
    private ObjectOutputStream writerToOutputStream; //сообщение, которое сервер отправляет клиенту
    public ClientHandler(Socket clientSocket, Server server) {

        try {
            this.server = server;
            this.clientSocket = clientSocket;
            this.readerFromInputStream = new ObjectInputStream(clientSocket.getInputStream()); //The getInputStream() returns an input stream for reading bytes from this socket.
            this.writerToOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

   public void run() {
        Object human = null;
        try {
            while ((human = readerFromInputStream.readObject()) != null) {
                sendToClient(human);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void sendToClient(Object human) {
        try {
            writerToOutputStream.writeObject(human);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
