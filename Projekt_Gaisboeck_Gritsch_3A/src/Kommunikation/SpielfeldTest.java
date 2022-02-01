package Kommunikation;

import java.io.Serializable;

public class SpielfeldTest implements Serializable {

    private String[] feld;

    public SpielfeldTest(String[] feld) {
        this.feld = feld;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < feld.length; i++) {
            String string = feld[i];
            s += string;
        }
        return s;
    }
}
