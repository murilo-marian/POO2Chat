import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServidorSocket {
    //criar um chat utilizando esse conceito, que funcione usando socket

    //socket:
    //IP
    //PROTOCOLO
    //PORTA

    public static void main(String[] args) throws IOException {
        //Cria o servidor e seta como nulo
        ServerSocket servidor = null;

        //cria uma conexão para atender o cliente e seta como nulo
        Socket conexao = null;

        //entrada de dados
        BufferedReader entrada = null;

        try {
            servidor = new ServerSocket(7000);
            List<ConnectionHandler> clientes = new ArrayList<>();

            while (true){
                conexao = servidor.accept();
                ConnectionHandler connectionHandler = new ConnectionHandler(conexao);
                Object lock = new Object();
                synchronized (lock) {
                    clientes.add(connectionHandler);
                }
                for (ConnectionHandler cliente : clientes) {
                    cliente.setClientes(clientes);
                }
                new Thread(connectionHandler).start();
            }

        } catch (IOException e) {
            System.out.println("Algo de errado aconteceu");
        } finally {
            //encerro o socket de comunicação
            conexao.close();

            servidor.close();
        }
    }


}
