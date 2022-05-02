import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;


public class Server {
    static Socket socket;
    static ServerSocket server;
    static ObjectInputStream input;
    static ObjectOutputStream output;

    public static void sender(Object o){

        try {
            output = new ObjectOutputStream(socket.getOutputStream());
            output.writeObject(o);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Object reciver(){
        Object o = new Object();
        try {
            input = new ObjectInputStream(socket.getInputStream());
            o = input.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }

    public static  void main(String[] args) {

        try {
            server=new ServerSocket(6666);
            socket=server.accept();

        } catch (IOException e) {
            e.printStackTrace();
        }

            System.out.println();
            gameseri g = new gameseri();
            g.seriProgram();
            System.out.println("12334");

    }

}
