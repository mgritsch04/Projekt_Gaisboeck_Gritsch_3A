
import java.io.Serializable;

public class Position implements Serializable {

    int Spalte;
    int Reihe;

    public Position(int Reihe, int Spalte) {
        this.Spalte = Spalte;
        this.Reihe = Reihe;
    }
}
