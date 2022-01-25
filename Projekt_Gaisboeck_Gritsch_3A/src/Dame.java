/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maxim
 */
public class Dame extends Figur {

    boolean white;

    public Dame(Position position, boolean isWhite) {
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
                possibleMoves[position.Reihe - i][position.Spalte] = true;

            }

            //nach links
            for (int i = 0; i <= felderNachLinks; i++) {
                possibleMoves[position.Reihe][position.Spalte - i] = true;
            }

            //nach rechts
            for (int i = 0; i <= felderNachRechts; i++) {
                possibleMoves[position.Reihe][position.Spalte + i] = true;
            }

            //diagonal links
            for (int i = 0; i <= felderNachHinten && i <= felderNachLinks; i++) {
                possibleMoves[position.Reihe + i][position.Spalte - i] = true;
            }

            //diagonal rechts
            for (int i = 0; i <= felderNachHinten && i <= felderNachRechts; i++) {
                possibleMoves[position.Reihe + i][position.Spalte + i] = true;
            }

            //digonal links hinten
            for (int i = 0; i <= felderNachVorne && i <= felderNachLinks; i++) {
                possibleMoves[position.Reihe - i][position.Spalte - i] = true;
            }

            //diagonal rechts hinten
            for (int i = 0; i <= felderNachVorne && i <= felderNachRechts; i++) {
                possibleMoves[position.Reihe - i][position.Spalte + i] = true;
            }
        } else {
            //nach vorne
            for (int i = 0; i <= felderNachVorne; i++) {
                possibleMoves[position.Reihe - i][position.Spalte] = true;
            }

            //nach hintenss
            for (int i = 0; i <= felderNachHinten; i++) {
                possibleMoves[position.Reihe - i][position.Spalte] = true;

            }

            //nach links
            for (int i = 0; i <= felderNachLinks; i++) {
                possibleMoves[position.Reihe][position.Spalte - i] = true;
            }

            //nach rechts
            for (int i = 0; i <= felderNachRechts; i++) {
                possibleMoves[position.Reihe][position.Spalte + i] = true;
            }

            //diagonal links
            for (int i = 0; i <= felderNachVorne && i <= felderNachLinks; i++) {
                possibleMoves[position.Reihe - i][position.Spalte - i] = true;
            }

            //diagonal rechts
            for (int i = 0; i <= felderNachVorne && i <= felderNachRechts; i++) {
                possibleMoves[position.Reihe - i][position.Spalte + i] = true;
            }

            //digonal links hinten
            for (int i = 0; i <= felderNachHinten && i <= felderNachLinks; i++) {
                possibleMoves[position.Reihe - i][position.Spalte - i] = true;
            }

            //diagonal rechts hinten
            for (int i = 0; i <= felderNachHinten && i <= felderNachRechts; i++) {
                possibleMoves[position.Reihe - i][position.Spalte + i] = true;
            }

        }

        return possibleMoves;
    }

    @Override
    public String toString() {
        if (isWhite) {
            return "WD";
        } else {
            return "SD";
        }
    }

}
