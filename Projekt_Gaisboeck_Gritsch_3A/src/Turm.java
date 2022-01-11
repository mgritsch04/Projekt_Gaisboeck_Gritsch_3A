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

    public Turm(Position position) {
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

        Position aktPos = this.position;

        //nach vorne
        int felderNachVorne = 7 - aktPos.Reihe;

        for (int i = 0; i < felderNachVorne; i++) {
            possibleMoves[aktPos.Spalte][aktPos.Reihe + i] = true;
        }

        //nach hinten
        int felderNachHinten = aktPos.Reihe;
        for (int i = 0; i < felderNachHinten; i++) {
            possibleMoves[aktPos.Spalte][aktPos.Reihe - i] = true;

        }

        //nach links
        int felderNachLinks = aktPos.Spalte;

        for (int i = 0; i < felderNachVorne; i++) {
            possibleMoves[aktPos.Spalte][aktPos.Reihe - i] = true;
        }

        //nach rechts
        int felderNachRechts = 7 - aktPos.Spalte;
        for (int i = 0; i < felderNachRechts; i++) {
            possibleMoves[aktPos.Spalte][aktPos.Reihe + i] = true;
        }

        return possibleMoves;
    }

}
