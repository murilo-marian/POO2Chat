import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServidorSocket {


    public static void main(String[] args) throws IOException {
    Server server = Server.getInstance(7000);
    server.run();
    }


}
