
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author maxim
 */
public class Position implements Serializable {

    int Spalte;
    int Reihe;

    public Position(int Reihe, int Spalte) {
        this.Spalte = Spalte;
        this.Reihe = Reihe;
    }

}
