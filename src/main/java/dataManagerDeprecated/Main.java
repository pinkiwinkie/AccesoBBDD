package dataManagerDeprecated;

public class Main {
    public static void main(String[] args) {
        Conector conector = new Conector();
        conector.conectarMySQL();
        conector.conectarOracle();
    }
}
