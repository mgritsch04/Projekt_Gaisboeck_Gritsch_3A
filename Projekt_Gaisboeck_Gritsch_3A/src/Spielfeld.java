

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author maxim
 */
public class Spielfeld {

    Figur[][] spielfeld = new Figur[8][8];

    public Spielfeld() {
        //Schwarze Figuren
        Bauer b1 = new Bauer(new Position(1, 0), false);
        Bauer b2 = new Bauer(new Position(1, 1), false);
        Bauer b3 = new Bauer(new Position(1, 2), false);
        Bauer b4 = new Bauer(new Position(1, 3), false);
        Bauer b5 = new Bauer(new Position(1, 4), false);
        Bauer b6 = new Bauer(new Position(1, 5), false);
        Bauer b7 = new Bauer(new Position(1, 6), false);
        Bauer b8 = new Bauer(new Position(1, 7), false);
        b1.possibleMoves = b1.possibleMoves();
        b2.possibleMoves = b2.possibleMoves();
        b3.possibleMoves = b3.possibleMoves();
        b4.possibleMoves = b4.possibleMoves();
        b5.possibleMoves = b5.possibleMoves();
        b6.possibleMoves = b6.possibleMoves();
        b7.possibleMoves = b7.possibleMoves();
        b8.possibleMoves = b8.possibleMoves();
        spielfeld[1][0] = b1;
        spielfeld[1][1] = b2;
        spielfeld[1][2] = b3;
        spielfeld[1][3] = b4;
        spielfeld[1][4] = b5;
        spielfeld[1][5] = b6;
        spielfeld[1][6] = b7;
        spielfeld[1][7] = b8;

        Turm t1 = new Turm(new Position(0, 0), false);
        t1.possibleMoves = t1.possibleMoves();
        Pferd p1 = new Pferd(new Position(0, 1), false);
        p1.possibleMoves = p1.possibleMoves();
        Laeufer l1 = new Laeufer(new Position(0, 2), false);
        l1.possibleMoves = l1.possibleMoves();
        Dame d = new Dame(new Position(0, 3), false);
        d.possibleMoves = d.possibleMoves();
        Koenig k = new Koenig(new Position(0, 4), false);
        k.possibleMoves = k.possibleMoves();
        Laeufer l2 = new Laeufer(new Position(0, 5), false);
        l2.possibleMoves = l2.possibleMoves();
        Pferd p2 = new Pferd(new Position(0, 6), false);
        p2.possibleMoves = p2.possibleMoves();
        Turm t2 = new Turm(new Position(0, 7), false);
        t2.possibleMoves = t2.possibleMoves();

        spielfeld[0][0] = t1;
        spielfeld[0][1] = p1;
        spielfeld[0][2] = l1;
        spielfeld[0][3] = d;
        spielfeld[0][4] = k;
        spielfeld[0][5] = l2;
        spielfeld[0][6] = p2;
        spielfeld[0][7] = t2;

        //Weiße Figuren
        Bauer bw1 = new Bauer(new Position(6, 0), true);
        Bauer bw2 = new Bauer(new Position(6, 1), true);
        Bauer bw3 = new Bauer(new Position(6, 2), true);
        Bauer bw4 = new Bauer(new Position(6, 3), true);
        Bauer bw5 = new Bauer(new Position(6, 4), true);
        Bauer bw6 = new Bauer(new Position(6, 5), true);
        Bauer bw7 = new Bauer(new Position(6, 6), true);
        Bauer bw8 = new Bauer(new Position(6, 7), true);
        bw1.possibleMoves = bw1.possibleMoves();
        bw2.possibleMoves = bw2.possibleMoves();
        bw3.possibleMoves = bw3.possibleMoves();
        bw4.possibleMoves = bw4.possibleMoves();
        bw5.possibleMoves = bw5.possibleMoves();
        bw6.possibleMoves = bw6.possibleMoves();
        bw7.possibleMoves = bw7.possibleMoves();
        bw8.possibleMoves = bw8.possibleMoves();
        spielfeld[6][0] = bw1;
        spielfeld[6][1] = bw2;
        spielfeld[6][2] = bw3;
        spielfeld[6][3] = bw4;
        spielfeld[6][4] = bw5;
        spielfeld[6][5] = bw6;
        spielfeld[6][6] = bw7;
        spielfeld[6][7] = bw8;

        Turm tw1 = new Turm(new Position(7, 0), true);
        tw1.possibleMoves = tw1.possibleMoves();
        Pferd pw1 = new Pferd(new Position(7, 1), true);
        pw1.possibleMoves = pw1.possibleMoves();
        Laeufer lw1 = new Laeufer(new Position(7, 2), true);
        lw1.possibleMoves = lw1.possibleMoves();
        Dame dw = new Dame(new Position(7, 3), true);
        dw.possibleMoves = dw.possibleMoves();
        Koenig kw = new Koenig(new Position(7, 4), true);
        kw.possibleMoves = kw.possibleMoves();
        Laeufer lw2 = new Laeufer(new Position(7, 5), true);
        lw2.possibleMoves = lw2.possibleMoves();
        Pferd pw2 = new Pferd(new Position(7, 6), true);
        pw2.possibleMoves = pw2.possibleMoves();
        Turm tw2 = new Turm(new Position(7, 7), true);
        tw2.possibleMoves = tw2.possibleMoves();

        spielfeld[7][0] = tw1;
        spielfeld[7][1] = pw1;
        spielfeld[7][2] = lw1;
        spielfeld[7][3] = dw;
        spielfeld[7][4] = kw;
        spielfeld[7][5] = lw2;
        spielfeld[7][6] = pw2;
        spielfeld[7][7] = tw2;
    }

    public void print() {
        System.out.println(" \u2009    0 \u2009\u2009  1 \u2009\u2009  2 \u2009\u2009  3 \u2009\u2009  4 \u2009\u2009  5  \u2009\u2009 6 \u2009\u2009  7");
        System.out.println("     -------------------------------------");
        for (int i = 0; i < spielfeld.length; i++) {
            System.out.print(i + "   ");
            for (int j = 0; j < spielfeld.length; j++) {
                if (spielfeld[i][j] == null) {
                    System.out.print("\u2009\u2009\u2009\u2009\u2009\u2009\u2009\u2009\u2009\u2009|");
                } else {
                    System.out.print(" " + spielfeld[i][j] + " |");
                }

            }

            System.out.println("");
            System.out.println("     -------------------------------------");
        }
    }

    public void testFigur(Figur figure) {
        for (int i = 0; i < figure.possibleMoves.length; i++) {
            for (int j = 0; j < figure.possibleMoves[i].length; j++) {
                System.out.print(figure.possibleMoves[i][j] + " | ");

            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Spielfeld s = new Spielfeld();
        s.print();
    }
}
