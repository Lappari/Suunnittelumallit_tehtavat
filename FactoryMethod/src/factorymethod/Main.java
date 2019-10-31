package factorymethod;

public class Main {

    public static void main(String[] args) {
        AterioivaOtus opettaja = new Opettaja();
        AterioivaOtus opiskelija = new Opiskelija();
        AterioivaOtus kokki = new Kokki();
        opettaja.aterioi();
        opiskelija.aterioi();
        kokki.aterioi();
        
    }
}
