/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maxim
 */
public class Turm extends Figur {

    public Turm(Position position, boolean isWhite) {
        super(position, isWhite);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] possibleMoves = new boolean[8][8];

        //Alle Positionen auf false setzen;
        for (boolean[] possibleMove : possibleMoves) {
            for (boolean b : possibleMove) {
                b = false;
            }
        }

        //nach vorne
        for (int i = 0; i < felderNachVorne; i++) {
            possibleMoves[position.Spalte][position.Reihe + i] = true;
        }

        //nach hintenss
        for (int i = 0; i < felderNachHinten; i++) {
            possibleMoves[position.Spalte][position.Reihe - i] = true;

        }

        //nach links
        for (int i = 0; i < felderNachLinks; i++) {
            possibleMoves[position.Spalte][position.Reihe - i] = true;
        }

        //nach rechts
        for (int i = 0; i < felderNachRechts; i++) {
            possibleMoves[position.Spalte][position.Reihe + i] = true;
        }

        return possibleMoves;
    }

    @Override
    public String toString() {
        if (isWhite) {
            return "WT";
        } else {
            return "ST";
        }
    }

}
