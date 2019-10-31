package factorymethod;

public class Opiskelija extends AterioivaOtus {

    public Juoma createJuoma(){
        return new Olut();
    };
}
