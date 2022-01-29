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

    boolean white;

    public Turm(Position position, boolean isWhite) {
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
            //nach vorne

            for (int i = 0; i <= felderNachHinten; i++) {
                possibleMoves[position.Reihe + i][position.Spalte] = true;
            }

            //nach hintenss
            for (int i = 0; i <= felderNachVorne; i++) {
                possibleMoves[position.Reihe + i][position.Spalte] = true;
            }
            for (int i = 0; i < felderNachHinten; i++) {
                possibleMoves[position.Spalte][position.Reihe + i] = true;
            }

            //nach hintenss
            for (int i = 0; i < felderNachVorne; i++) {
                possibleMoves[position.Spalte][position.Reihe - i] = true;

            }

            //nach links
            for (int i = 0; i <= felderNachLinks; i++) {
                possibleMoves[position.Reihe][position.Spalte - i] = true;
            }

            //nach rechts
            for (int i = 0; i <= felderNachRechts; i++) {
                possibleMoves[position.Reihe][position.Reihe + i] = true;
            }
            for (int i = 0; i < felderNachLinks; i++) {
                possibleMoves[position.Spalte - 1][position.Reihe] = true;
            }

            //nach rechts
            for (int i = 0; i < felderNachRechts; i++) {
                possibleMoves[position.Spalte + i][position.Reihe] = true;

            }
        } else {
            //nach vorne
            for (int i = 0; i < felderNachVorne; i++) {

                possibleMoves[position.Reihe - i][position.Spalte] = true;
            }

            //nach hintenss
            for (int i = 0; i <= felderNachHinten; i++) {
                possibleMoves[position.Reihe - i][position.Spalte] = true;

            }

            //nach hintenss
            for (int i = 0; i < felderNachHinten; i++) {
                possibleMoves[position.Spalte][position.Reihe - i] = true;

            }

            //nach links
            for (int i = 0; i < felderNachLinks; i++) {

                possibleMoves[position.Reihe][position.Spalte - 1] = true;
            }

            //nach rechts
            for (int i = 0; i <= felderNachRechts; i++) {
                possibleMoves[position.Reihe][position.Spalte + i] = true;

            }

            //nach rechts
            for (int i = 0; i < felderNachRechts; i++) {
                possibleMoves[position.Spalte + i][position.Reihe] = true;
            }
        }

        return possibleMoves;
    }

    @Override
    public String toString() {
        if (white) {
            return "WT";
        } else {
            return "ST";
        }
    }

}
