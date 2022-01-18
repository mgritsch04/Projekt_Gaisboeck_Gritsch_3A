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

    public Bauer(Position postion) {
        super(postion);
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
        if (felderNachVorne > 1) {
            possibleMoves[position.Spalte][position.Reihe + 1] = true;
        }

        //2 nach vorne
        if (felderNachVorne > 2) {
            possibleMoves[position.Spalte][position.Reihe + 2] = true;
        }

        //1 nach vorne links
        if (felderNachLinks > 0 && felderNachVorne > 0) {
            possibleMoves[position.Spalte + 1][position.Reihe - 1] = true;
        }
        //1 nach vorne rechts
        if (felderNachRechts < 7 && felderNachVorne > 0) {
            possibleMoves[position.Spalte + 1][position.Reihe + 1] = true;
        }
        return possibleMoves;
    }
}
