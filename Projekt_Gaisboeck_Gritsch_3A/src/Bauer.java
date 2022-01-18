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

        Position aktPos = this.position;
        int felderNachVorne = 7 - aktPos.Reihe;

        //1 nach vorne
        if (aktPos.Reihe < 7) {
            possibleMoves[aktPos.Spalte][aktPos.Reihe + 1] = true;
        }

        //2 nach vorne
        if (felderNachVorne < 6) {
            possibleMoves[aktPos.Spalte][aktPos.Reihe + 2] = true;
        }

        //1 nach vorne links
        if (aktPos.Spalte > 0) {
            possibleMoves[aktPos.Spalte + 1][aktPos.Reihe - 1] = true;
        }
        //1 nach vorne rechts
        if (aktPos.Reihe < 7) {
            possibleMoves[aktPos.Spalte + 1][aktPos.Reihe + 1] = true;
        }
        return possibleMoves;
    }
}
