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
        spielfeld[1][0] = new Bauer(new Position(1, 0), true);
        spielfeld[1][1] = new Bauer(new Position(1, 1), true);
        spielfeld[1][2] = new Bauer(new Position(1, 2), true);
        spielfeld[1][3] = new Bauer(new Position(1, 3), true);
        spielfeld[1][4] = new Bauer(new Position(1, 4), true);
        spielfeld[1][5] = new Bauer(new Position(1, 5), true);
        spielfeld[1][6] = new Bauer(new Position(1, 6), true);
        spielfeld[1][7] = new Bauer(new Position(1, 7), true);

        spielfeld[6][0] = new Bauer(new Position(6, 0), false);
        spielfeld[6][1] = new Bauer(new Position(6, 1), false);
        spielfeld[6][2] = new Bauer(new Position(6, 2), false);
        spielfeld[6][3] = new Bauer(new Position(6, 3), false);
        spielfeld[6][4] = new Bauer(new Position(6, 4), false);
        spielfeld[6][5] = new Bauer(new Position(6, 5), false);
        spielfeld[6][6] = new Bauer(new Position(6, 6), false);
        spielfeld[6][7] = new Bauer(new Position(6, 7), false);

        spielfeld[0][0] = new Turm(new Position(0, 0), true);
//        spielfeld[0][1] = new Bauer(new Position(1, 0), true);
//        spielfeld[0][2] = new Bauer(new Position(1, 0), true);
//        spielfeld[0][3] = new Bauer(new Position(1, 0), true);
//        spielfeld[0][4] = new Bauer(new Position(1, 0), true);
//        spielfeld[0][5] = new Bauer(new Position(1, 0), true);
//        spielfeld[0][6] = new Bauer(new Position(1, 0), true);
//        spielfeld[0][7] = new Bauer(new Position(1, 0), true);
//
//        spielfeld[7][0] = new Bauer(new Position(1, 0), false);
//        spielfeld[7][1] = new Bauer(new Position(1, 0), false);
//        spielfeld[7][2] = new Bauer(new Position(1, 0), false);
//        spielfeld[7][3] = new Bauer(new Position(1, 0), false);
//        spielfeld[7][4] = new Bauer(new Position(1, 0), false);
//        spielfeld[7][5] = new Bauer(new Position(1, 0), false);
//        spielfeld[7][6] = new Bauer(new Position(1, 0), false);
//        spielfeld[7][7] = new Bauer(new Position(1, 0), false);
    }

    public void print() {
        System.out.println("        0    1    2    3    4    5    6    7");
        System.out.println("     -----------------------------------------");
        for (int i = 0; i < spielfeld.length; i++) {
            System.out.print(i + "    |");
            for (int j = 0; j < spielfeld.length; j++) {
//                System.out.print("   ");
                if (spielfeld[i][j] == null) {
                    System.out.print("    |");
                } else {
                    System.out.print(" " + spielfeld[i][j] + " |");
                }

            }

            System.out.println("");
            System.out.println("     -----------------------------------------");

        }
    }

    public static void main(String[] args) {
        Spielfeld s = new Spielfeld();
        s.print();
    }
}
