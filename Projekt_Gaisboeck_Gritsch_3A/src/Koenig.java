/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maxim
 */
public class Koenig extends Figur {

    boolean white;

    public Koenig(Position position, boolean isWhite) {
        super(position, isWhite);
        white = isWhite;
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

        if (!white) {
            //1 nach vorne

            if (felderNachHinten >= 0) {
                possibleMoves[position.Reihe + 1][position.Spalte] = true;
            }

            //1 nach hinten
            if (felderNachVorne >= 0) {
                possibleMoves[position.Reihe - 1][position.Spalte] = true;
            }

            //1 nach rechts
            if (felderNachRechts >= 0) {
                possibleMoves[position.Reihe][position.Spalte + 1] = true;
            }

            //1 nach links
            if (felderNachLinks >= 0) {
                possibleMoves[position.Reihe][position.Spalte - 1] = true;
            }

            //1 diagonal rechts
            if (felderNachHinten >= 0 && felderNachRechts >= 0) {
                possibleMoves[position.Reihe + 1][position.Spalte + 1] = true;
            }

            //1 diagonal links
            if (felderNachHinten >= 0 && felderNachLinks >= 0) {
                possibleMoves[position.Reihe + 1][position.Spalte - 1] = true;
            }

            //diagonal rechts hinten
            if (felderNachVorne >= 0 && felderNachRechts >= 0) {
                possibleMoves[position.Reihe - 1][position.Spalte + 1] = true;
            }

            //diagonal links hinten
            if (felderNachVorne >= 0 && felderNachLinks >= 0) {
                possibleMoves[position.Reihe - 1][position.Spalte - 1] = true;
            }
        } else {
            //1 nach vorne
            if (felderNachVorne >= 0) {
                possibleMoves[position.Reihe - 1][position.Spalte] = true;
            }

            //1 nach hinten
            if (felderNachHinten >= 0) {
                possibleMoves[position.Reihe - 1][position.Spalte] = true;
            }

            //1 nach rechts
            if (felderNachRechts >= 0) {
                possibleMoves[position.Reihe][position.Spalte + 1] = true;
            }

            //1 nach links
            if (felderNachLinks >= 0) {
                possibleMoves[position.Reihe][position.Spalte - 1] = true;
            }

            //1 diagonal rechts
            if (felderNachVorne >= 0 && felderNachRechts >= 0) {
                possibleMoves[position.Reihe - 1][position.Spalte + 1] = true;
            }

            //1 diagonal links
            if (felderNachVorne >= 0 && felderNachLinks >= 0) {
                possibleMoves[position.Reihe - 1][position.Spalte - 1] = true;
            }

            //diagonal rechts hinten
            if (felderNachHinten >= 0 && felderNachRechts >= 0) {
                possibleMoves[position.Reihe - 1][position.Spalte + 1] = true;
            }

            //diagonal links hinten
            if (felderNachHinten >= 0 && felderNachLinks >= 0) {
                possibleMoves[position.Reihe - 1][position.Spalte - 1] = true;
            }
        }

        return possibleMoves;
    }

    @Override
    public String toString() {
        if (white) {
            return "WK";
        } else {
            return "SK";
        }
    }

}
