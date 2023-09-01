
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteSocket {
    public static void main(String[] args) {
        //Utilizado para leitura do teclado
        Scanner entrada = new Scanner(System.in);

        //variaável para armazenar o tezxto que será digitado
        String texto = "";

        Socket cliente = null;

        PrintStream saida = null;

        try {
            //cria o socket com os parametros
            cliente = new Socket("localhost", 7000);

            saida = new PrintStream(cliente.getOutputStream());


            ClientReceiver clientReceiver = ClientReceiver.getInstance(cliente);

            new Thread(clientReceiver).start();
            do {
                texto = entrada.nextLine();
                saida.println(texto);
            } while (!"sair".equals(texto));
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
