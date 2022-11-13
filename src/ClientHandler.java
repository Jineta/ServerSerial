import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler{
    Socket clientSocket;
    private ServerObject server;
    private ObjectInputStream readerFromInputStream; //сообщение, которое сервер считывает с клиента
    private ObjectOutputStream writerToOutputStream; //сообщение, которое сервер отправляет клиенту
    ArrayList<Human> humanArrayList= new ArrayList<>();
    public ClientHandler(Socket clientSocket, ServerObject server) {

        try {
            this.server = server;
            this.clientSocket = clientSocket;
            this.readerFromInputStream = new ObjectInputStream(clientSocket.getInputStream()); //The getInputStream() returns an input stream for reading bytes from this socket.
            this.writerToOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void readFromClient() {
        Human human = null;
        try {
            while ((human = (Human) readerFromInputStream.readObject()) != null)
            humanArrayList.add(human);
                //sendToClient(human);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void sendAllToClient() {
        for (Human hum : humanArrayList) {
                sendToClient(hum);
        }
    }

    public void sendToClient(Object human) {
            try {
                writerToOutputStream.writeObject(human);
               writerToOutputStream.flush();
                //writerToOutputStream.close();
            } catch (Exception ex) {
                ex.printStackTrace();

        }
    }
}
