
import java.io.Serializable;

public class Pferd extends Figur implements Serializable {

    boolean white;

    public Pferd(Position position, boolean isWhite) {
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
            //2 vorne 1 links
            if (felderNachHinten > 1 && felderNachLinks > 0) {
                possibleMoves[position.Reihe + 2][position.Spalte - 1] = true;
            }

            //2 vorne 1 rechts
            if (felderNachHinten > 1 && felderNachRechts > 0) {
                possibleMoves[position.Reihe + 2][position.Spalte + 1] = true;

            }

            //1 vorne 2 links
            if (felderNachHinten > 0 && felderNachLinks > 1) {

                possibleMoves[position.Reihe + 1][position.Spalte - 2] = true;

            }

            //1 vorne 2 rechts
            if (felderNachHinten > 0 && felderNachRechts > 1) {

                possibleMoves[position.Reihe + 1][position.Spalte + 2] = true;

            }

            //2 hinten 1 links
            if (felderNachVorne > 1 && felderNachLinks > 0) {

                possibleMoves[position.Reihe - 2][position.Spalte - 1] = true;

            }

            //2 hinten 1 rechts
            if (felderNachVorne > 1 && felderNachRechts > 0) {

                possibleMoves[position.Reihe - 2][position.Spalte + 1] = true;

            }

            //1 hinten 2 links
            if (felderNachVorne > 0 && felderNachLinks > 1) {
                possibleMoves[position.Reihe - 1][position.Spalte - 2] = true;

            }

            //1 hinten 2 rechts
            if (felderNachVorne > 0 && felderNachRechts > 1) {
                possibleMoves[position.Reihe - 1][position.Spalte + 2] = true;
            }
        } else {
            //2 vorne 1 links
            if (felderNachVorne > 1 && felderNachLinks > 0) {

                possibleMoves[position.Reihe - 2][position.Spalte - 1] = true;

            }

            //2 vorne 1 rechts
            if (felderNachVorne > 1 && felderNachRechts > 0) {
                possibleMoves[position.Reihe - 2][position.Spalte + 1] = true;
            }

            //1 vorne 2 links
            if (felderNachVorne > 0 && felderNachLinks > 1) {

                possibleMoves[position.Reihe - 1][position.Spalte - 2] = true;
            }

            //1 vorne 2 rechts
            if (felderNachVorne > 0 && felderNachRechts > 1) {

                possibleMoves[position.Reihe - 1][position.Spalte + 2] = true;

            }

            //2 hinten 1 links
            if (felderNachHinten > 1 && felderNachLinks > 0) {
                possibleMoves[position.Reihe - 2][position.Spalte - 1] = true;

            }

            //2 hinten 1 rechts
            if (felderNachHinten > 1 && felderNachRechts > 0) {
                possibleMoves[position.Reihe - 2][position.Spalte + 1] = true;

            }

            //1 hinten 2 links
            if (felderNachHinten > 0 && felderNachLinks > 1) {

                possibleMoves[position.Reihe - 1][position.Spalte - 2] = true;

            }

            //1 hinten 2 rechts
            if (felderNachHinten > 0 && felderNachRechts > 1) {

                possibleMoves[position.Reihe - 1][position.Spalte + 2] = true;

            }
        }

        return possibleMoves;
    }

    @Override
    public String toString() {
        if (isWhite) {
            return "\u2658";
        } else {
            return "\uu265e";
        }
    }
}
