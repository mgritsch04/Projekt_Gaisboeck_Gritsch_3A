
import java.io.Serializable;

public class Turm extends Figur implements Serializable {

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
            for (int i = 0; i < felderNachVorne; i++) {
                possibleMoves[position.Reihe - i][position.Spalte] = true;
            }
            //nach links
            for (int i = 0; i <= felderNachLinks; i++) {
                possibleMoves[position.Reihe][position.Spalte - i] = true;
            }

            //nach rechts
            for (int i = 0; i < felderNachRechts; i++) {
                possibleMoves[position.Reihe][position.Reihe + i] = true;
            }

        } else {
            //nach vorne

            for (int i = 0; i <= felderNachVorne + 1; i++) {

                possibleMoves[position.Reihe - i][position.Spalte] = true;
            }

            //nach hintens
            for (int i = 0; i <= felderNachHinten; i++) {
                possibleMoves[position.Reihe + i][position.Spalte] = true;

            }

            //nach links
            for (int i = 0; i < felderNachLinks + 1; i++) {
                possibleMoves[position.Reihe][position.Spalte - i] = true;
            }

            //nach rechts
            for (int i = 0; i <= felderNachRechts; i++) {
                possibleMoves[position.Reihe][position.Spalte + i] = true;

            }
        }

        return possibleMoves;
    }

    @Override
    public String toString() {
        if (isWhite) {
            return "\u2656";
        } else {
            return "\u265c";
        }
    }
}
