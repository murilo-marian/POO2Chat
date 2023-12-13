import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Filtro filtro = Filtro.getInstance("files/blacklist.txt", TipoDeFiltro.Asteriscos, true);
            filtro.adicionarBlackList("");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
