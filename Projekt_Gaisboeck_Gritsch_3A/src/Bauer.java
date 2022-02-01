/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maxim
 */
public class Bauer extends Figur {

    boolean white;
//    boolean isFirstMove;

    public Bauer(Position postion, boolean isWhite) {
        super(postion, isWhite);
        white = isWhite;
        possibleMoves();
        position = postion;
//        isFirstMove = true;
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

        if (white == false) {
            if (felderNachHinten > 0) {
                possibleMoves[position.Reihe + 1][position.Spalte] = true;
            }
            //2 nach vorne
            if (felderNachHinten >= 2 && isFirstMove) {
                possibleMoves[position.Reihe + 2][position.Spalte] = true;
            }

            //1 nach vorne links
            if (felderNachLinks > 0 && felderNachHinten > 0) {
                possibleMoves[position.Reihe + 1][position.Spalte - 1] = true;
            }
            //1 nach vorne rechts
            if (felderNachRechts > 0 && felderNachHinten > 0) {
                possibleMoves[position.Reihe + 1][position.Spalte + 1] = true;
            }

        } else {
            //1 nach vorne
            if (felderNachVorne > 0) {
                possibleMoves[position.Reihe - 1][position.Spalte] = true;
            }

            //2 nach vorne
            if (felderNachVorne > 1 && isFirstMove) {
                possibleMoves[position.Reihe - 2][position.Spalte] = true;
            }

            //1 nach vorne links
            if (felderNachLinks > 0 && felderNachVorne > 0) {
                possibleMoves[position.Reihe - 1][position.Spalte - 1] = true;
            }
            //1 nach vorne rechts
            if (felderNachRechts > 0 && felderNachVorne > 0) {
                possibleMoves[position.Reihe - 1][position.Spalte + 1] = true;
            }
        }

        return possibleMoves;
    }

    @Override
    public String toString() {
        if (isWhite) {
            return "\u2659";
        } else {
            return "\u265f";
        }
    }
}
