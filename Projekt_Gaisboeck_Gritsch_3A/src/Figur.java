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

    Boolean isWhite;
    Position position;
    int felderNachVorne;
    int felderNachHinten;
    int felderNachRechts;
    int felderNachLinks;
    boolean[][] possibleMoves;

    public Figur(Position position, Boolean isWhite) {
        this.position = position;
        felderNachVorne = position.Reihe - 1;
        felderNachHinten = 7 - position.Reihe;
        felderNachRechts = 7 - position.Spalte;
        felderNachLinks = position.Spalte;
//        this.possibleMoves = possibleMoves();
        this.isWhite = isWhite;
    }

    public abstract boolean[][] possibleMoves();

    public abstract String toString();

}
