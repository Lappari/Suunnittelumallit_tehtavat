package factorymethod;

public class Kokki extends AterioivaOtus {

    public Juoma createJuoma(){
        return new Viini();
    };
}
