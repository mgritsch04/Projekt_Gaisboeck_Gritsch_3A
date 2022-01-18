/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maxim
 */
public class König extends Figur {

    public König(Position position) {
        super(position);
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

        //1 nach vorne
        if (felderNachVorne > 0) {
            possibleMoves[position.Spalte][position.Reihe + 1] = true;
        }

        //1 nach hinten
        if (felderNachHinten > 0) {
            possibleMoves[position.Spalte][position.Reihe - 1] = true;
        }

        //1 nach rechts
        if (felderNachRechts > 0) {
            possibleMoves[position.Spalte + 1][position.Reihe] = true;
        }

        //1 nach links
        if (felderNachLinks > 0) {
            possibleMoves[position.Spalte - 1][position.Reihe] = true;
        }

        return possibleMoves;
    }

}
