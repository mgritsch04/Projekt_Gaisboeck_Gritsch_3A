/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maxim
 */
public abstract class Figur {

    Position position;
    int felderNachVorne;
    int felderNachHinten;
    int felderNachRechts;
    int felderNachLinks;
    boolean[][] possibleMoves;

    public Figur(Position position) {
        this.position = position;
        felderNachVorne = 7 - position.Reihe;
        felderNachHinten = position.Reihe;
        felderNachRechts = 7 - position.Spalte;
        felderNachLinks = position.Spalte;
        this.possibleMoves = possibleMoves();
    }

    public abstract boolean[][] possibleMoves();

}
