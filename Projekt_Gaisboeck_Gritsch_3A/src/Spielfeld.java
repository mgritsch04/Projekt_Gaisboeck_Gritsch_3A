
import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

public class Spielfeld implements Serializable {

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
                    System.out.print(" " + spielfeld[i][j].toString() + " |");
                }
            }
            System.out.println("");
            System.out.println("     -------------------------------------");
        }
    }

    public boolean checkPositionForFigure(int reihe, int spalte) {
        if (spielfeld[reihe][spalte] != null) {
            return true;
        } else {
            return false;
        }
    }

    public String moveFigure(int reiheAkt, int spalteAkt, int reiheNeu, int spalteNeu) {
        String successMove = "true";
        boolean moveMade = false;

        //Bauer schlagen
        if (spielfeld[reiheAkt][spalteAkt].getClass().equals(Bauer.class)) {
            if (spielfeld[reiheAkt][spalteAkt].isWhite) {
                //weiß
                if (spielfeld[reiheAkt][spalteAkt].felderNachHinten > 0 && spielfeld[reiheAkt][spalteAkt].felderNachLinks > 0 && !checkPositionForFigure(reiheAkt - 1, spalteAkt - 1)) {
                    spielfeld[reiheAkt][spalteAkt].possibleMoves[reiheAkt - 1][spalteAkt - 1] = false;
                }
                if (spielfeld[reiheAkt][spalteAkt].felderNachHinten > 0 && spielfeld[reiheAkt][spalteAkt].felderNachRechts > 0 && ! !checkPositionForFigure(reiheAkt - 1, spalteAkt + 1)) {
                    spielfeld[reiheAkt][spalteAkt].possibleMoves[reiheAkt - 1][spalteAkt + 1] = false;
                }
            } else {
                //schwarz
                if (spielfeld[reiheAkt][spalteAkt].felderNachVorne > 0 && spielfeld[reiheAkt][spalteAkt].felderNachRechts > 0 && ! !checkPositionForFigure(reiheAkt + 1, spalteAkt + 1)) {
                    spielfeld[reiheAkt][spalteAkt].possibleMoves[reiheAkt + 1][spalteAkt + 1] = false;
                }
                if (spielfeld[reiheAkt][spalteAkt].felderNachVorne > 0 && spielfeld[reiheAkt][spalteAkt].felderNachLinks > 0 && ! !checkPositionForFigure(reiheAkt + 1, spalteAkt - 1)) {
                    spielfeld[reiheAkt][spalteAkt].possibleMoves[reiheAkt + 1][spalteAkt - 1] = false;
                }
            }

        }

        OUTER:
        if (checkPositionForFigure(reiheNeu, spalteNeu)) {
            if (Objects.equals(spielfeld[reiheAkt][spalteAkt].isWhite, spielfeld[reiheNeu][spalteNeu].isWhite)) {
                System.out.println("Feld besetzt.");
                successMove = "false";
            } else {
                if (spielfeld[reiheAkt][spalteAkt].possibleMoves[reiheNeu][spalteNeu] == true && figureBetweenMove(reiheAkt, spalteAkt, reiheNeu, spalteNeu) == false) {
                    if (spielfeld[reiheNeu][spalteNeu].getClass().equals(Koenig.class)) {

                        spielfeld[reiheNeu][spalteNeu] = spielfeld[reiheAkt][spalteAkt];
                        spielfeld[reiheNeu][spalteNeu].position = new Position(reiheNeu, spalteNeu);
                        spielfeld[reiheNeu][spalteNeu].felderBerechnen();
                        spielfeld[reiheNeu][spalteNeu].possibleMoves = spielfeld[reiheNeu][spalteNeu].possibleMoves();
                        spielfeld[reiheAkt][spalteAkt] = null;

                        successMove = "Schachmatt";
                        break OUTER;
                    }
                    spielfeld[reiheNeu][spalteNeu] = spielfeld[reiheAkt][spalteAkt];
                    spielfeld[reiheNeu][spalteNeu].position = new Position(reiheNeu, spalteNeu);
                    spielfeld[reiheNeu][spalteNeu].felderBerechnen();
                    spielfeld[reiheNeu][spalteNeu].possibleMoves = spielfeld[reiheNeu][spalteNeu].possibleMoves();
                    spielfeld[reiheAkt][spalteAkt] = null;
                    spielfeld[reiheNeu][spalteNeu].isFirstMove = false;

                } else {
                    successMove = "false";
                    System.out.println("Ungütliger Spielzug");
                }

            }
        } else {
            //rochade
            //weißer linker turm
            if (reiheAkt == 7 && spalteAkt == 0 && spielfeld[reiheAkt][spalteAkt].getClass().equals(Turm.class) && spielfeld[reiheAkt][spalteAkt].isFirstMove && spielfeld[7][4].getClass().equals(Koenig.class) && spielfeld[7][4].isFirstMove && reiheAkt == reiheNeu && spalteNeu == 3) {
                spielfeld[reiheNeu][spalteNeu] = spielfeld[reiheAkt][spalteAkt];
                spielfeld[reiheNeu][spalteNeu].position = new Position(reiheNeu, spalteNeu);
                spielfeld[reiheNeu][spalteNeu].felderBerechnen();
                spielfeld[reiheNeu][spalteNeu].possibleMoves = spielfeld[reiheNeu][spalteNeu].possibleMoves();
                spielfeld[reiheAkt][spalteAkt] = null;
                spielfeld[reiheNeu][spalteNeu].isFirstMove = false;

                spielfeld[7][2] = spielfeld[7][4];
                spielfeld[7][2].position = new Position(7, 2);
                spielfeld[7][2].felderBerechnen();
                spielfeld[7][2].possibleMoves = spielfeld[7][spalteNeu].possibleMoves();
                spielfeld[7][4] = null;
                spielfeld[7][2].isFirstMove = false;
                moveMade = true;

            } //weißer rechter turm
            else if (reiheAkt == 7 && spalteAkt == 7 && spielfeld[reiheAkt][spalteAkt].getClass().equals(Turm.class) && spielfeld[reiheAkt][spalteAkt].isFirstMove && spielfeld[7][4].getClass().equals(Koenig.class) && spielfeld[7][4].isFirstMove && reiheAkt == reiheNeu && spalteNeu == 5) {
                spielfeld[reiheNeu][spalteNeu] = spielfeld[reiheAkt][spalteAkt];
                spielfeld[reiheNeu][spalteNeu].position = new Position(reiheNeu, spalteNeu);
                spielfeld[reiheNeu][spalteNeu].felderBerechnen();
                spielfeld[reiheNeu][spalteNeu].possibleMoves = spielfeld[reiheNeu][spalteNeu].possibleMoves();
                spielfeld[reiheAkt][spalteAkt] = null;
                spielfeld[reiheNeu][spalteNeu].isFirstMove = false;

                spielfeld[7][6] = spielfeld[7][4];
                spielfeld[7][6].position = new Position(7, 5);
                spielfeld[7][6].felderBerechnen();
                spielfeld[7][6].possibleMoves = spielfeld[7][spalteNeu].possibleMoves();
                spielfeld[7][4] = null;
                spielfeld[7][6].isFirstMove = false;
                moveMade = true;
            } //schwarzer linker turm
            else if (reiheAkt == 0 && spalteAkt == 0 && spielfeld[reiheAkt][spalteAkt].getClass().equals(Turm.class) && spielfeld[reiheAkt][spalteAkt].isFirstMove && spielfeld[0][4].getClass().equals(Koenig.class) && spielfeld[0][4].isFirstMove && reiheAkt == reiheNeu && spalteNeu == 3) {
                spielfeld[reiheNeu][spalteNeu] = spielfeld[reiheAkt][spalteAkt];
                spielfeld[reiheNeu][spalteNeu].position = new Position(reiheNeu, spalteNeu);
                spielfeld[reiheNeu][spalteNeu].felderBerechnen();
                spielfeld[reiheNeu][spalteNeu].possibleMoves = spielfeld[reiheNeu][spalteNeu].possibleMoves();
                spielfeld[reiheAkt][spalteAkt] = null;
                spielfeld[reiheNeu][spalteNeu].isFirstMove = false;

                spielfeld[0][2] = spielfeld[7][4];
                spielfeld[0][2].position = new Position(0, 2);
                spielfeld[0][2].felderBerechnen();
                spielfeld[0][2].possibleMoves = spielfeld[0][spalteNeu].possibleMoves();
                spielfeld[0][4] = null;
                spielfeld[0][2].isFirstMove = false;
                moveMade = true;
            } //schwarzer rechter turm
            else if (reiheAkt == 0 && spalteAkt == 7 && spielfeld[reiheAkt][spalteAkt].getClass().equals(Turm.class) && spielfeld[reiheAkt][spalteAkt].isFirstMove && spielfeld[0][4].getClass().equals(Koenig.class) && spielfeld[0][4].isFirstMove && reiheAkt == reiheNeu && spalteNeu == 5) {
                spielfeld[reiheNeu][spalteNeu] = spielfeld[reiheAkt][spalteAkt];
                spielfeld[reiheNeu][spalteNeu].position = new Position(reiheNeu, spalteNeu);
                spielfeld[reiheNeu][spalteNeu].felderBerechnen();
                spielfeld[reiheNeu][spalteNeu].possibleMoves = spielfeld[reiheNeu][spalteNeu].possibleMoves();
                spielfeld[reiheAkt][spalteAkt] = null;
                spielfeld[reiheNeu][spalteNeu].isFirstMove = false;

                spielfeld[0][6] = spielfeld[0][4];
                spielfeld[0][6].position = new Position(0, 5);
                spielfeld[0][6].felderBerechnen();
                spielfeld[0][6].possibleMoves = spielfeld[7][spalteNeu].possibleMoves();
                spielfeld[0][4] = null;
                spielfeld[0][6].isFirstMove = false;
                moveMade = true;
            }

            if (moveMade == false && spielfeld[reiheAkt][spalteAkt].possibleMoves[reiheNeu][spalteNeu] == true && figureBetweenMove(reiheAkt, spalteAkt, reiheNeu, spalteNeu) == false) {

                spielfeld[reiheNeu][spalteNeu] = spielfeld[reiheAkt][spalteAkt];
                spielfeld[reiheNeu][spalteNeu].position = new Position(reiheNeu, spalteNeu);
                spielfeld[reiheNeu][spalteNeu].felderBerechnen();
                spielfeld[reiheNeu][spalteNeu].possibleMoves = spielfeld[reiheNeu][spalteNeu].possibleMoves();
                spielfeld[reiheAkt][spalteAkt] = null;
                spielfeld[reiheNeu][spalteNeu].isFirstMove = false;

            } else {
                if (moveMade == false) {
                    successMove = "false";
                    System.out.println("Ungütliger Spielzug");
                }

            }
        }

        if (successMove.equals("true")) {
            if (spielfeld[reiheNeu][spalteNeu].isWhite) {
                if (spielfeld[reiheNeu][spalteNeu].getClass().equals(Bauer.class) && reiheNeu == 0) {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Bauer durch Dame (d), Turm (t), Läufer (l), oder Springer (s) tauschen?");
                    String newFigure = sc.nextLine();

                    OUTER:
                    while (true) {
                        newFigure = sc.nextLine();
                        switch (newFigure) {
                            case "d":
                            case "t":
                            case "l":
                            case "s":
                                break OUTER;
                            default:
                                break;
                        }
                    }

                    upgradeFigure(reiheNeu, spalteNeu, newFigure);
                }
            } else {
                if (spielfeld[reiheNeu][spalteNeu].getClass().equals(Bauer.class) && reiheNeu == 7) {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Bauer durch Dame (d), Turm (t), Läufer (l), oder Springer (s) tauschen?");
                    String newFigure = "";

                    OUTER:
                    while (true) {
                        newFigure = sc.nextLine();
                        switch (newFigure) {
                            case "d":
                            case "t":
                            case "l":
                            case "s":

                                break OUTER;
                            default:
                                break;
                        }
                    }
                    upgradeFigure(reiheNeu, spalteNeu, newFigure);
                }
            }
        }
        return successMove;
    }

    public void upgradeFigure(int reihe, int spalte, String newFigure) {
        if (spielfeld[reihe][spalte].isWhite) {
            switch (newFigure) {
                case "d":
                    spielfeld[reihe][spalte] = new Dame(new Position(reihe, spalte), true);
                    break;
                case "t":
                    spielfeld[reihe][spalte] = new Turm(new Position(reihe, spalte), true);
                    break;
                case "l":
                    spielfeld[reihe][spalte] = new Laeufer(new Position(reihe, spalte), true);
                    break;
                case "s":
                    spielfeld[reihe][spalte] = new Pferd(new Position(reihe, spalte), true);
                    break;
            }
        } else {
            switch (newFigure) {
                case "d":
                    spielfeld[reihe][spalte] = new Dame(new Position(reihe, spalte), false);
                    break;
                case "t":
                    spielfeld[reihe][spalte] = new Turm(new Position(reihe, spalte), false);
                    break;
                case "l":
                    spielfeld[reihe][spalte] = new Laeufer(new Position(reihe, spalte), false);
                    break;
                case "s":
                    spielfeld[reihe][spalte] = new Pferd(new Position(reihe, spalte), false);
                    break;
            }
        }

    }

    public boolean figureBetweenMove(int reiheAkt, int spalteAkt, int reiheNeu, int spalteNeu) {
        boolean figurebetween = false;

        if (spielfeld[reiheAkt][spalteAkt].isWhite) {
            if (spalteAkt == spalteNeu) {
                //vorne
                if (reiheAkt > reiheNeu) {
                    for (int i = reiheAkt - 1; i > reiheNeu; i--) {
                        if (checkPositionForFigure(i, spalteAkt)) {
                            figurebetween = true;
                        }
                    }
                } else {
                    //hinten
                    for (int i = reiheAkt + 1; i < reiheNeu; i++) {
                        if (checkPositionForFigure(i, spalteAkt)) {
                            figurebetween = true;
                        }
                    }
                }

            }

            if (reiheAkt == reiheNeu) {
                //links
                if (spalteAkt > spalteNeu) {
                    for (int i = spalteAkt - 1; i > spalteNeu; i--) {
                        if (checkPositionForFigure(reiheAkt, i)) {
                            figurebetween = true;
                        }

                    }
                } else {
                    //rechts wip
                    for (int i = spalteAkt + 1; i < spalteNeu; i++) {
                        if (checkPositionForFigure(reiheAkt, i)) {
                            figurebetween = true;
                        }
                    }
                }

            }

            //diagonal rechts vorne
            if (reiheAkt > reiheNeu && spalteAkt < spalteNeu) {
                for (int i = reiheAkt; i <= reiheNeu; i++) {
                    for (int j = spalteAkt; j <= spalteNeu; j++) {
                        if (checkPositionForFigure(i, j)) {
                            figurebetween = true;
                        }
                    }
                }
            }

            //diagonal links vorne
            if (reiheAkt > reiheNeu && spalteAkt > spalteNeu) {
                for (int i = reiheAkt; i <= reiheNeu; i++) {
                    for (int j = spalteAkt; j >= spalteNeu; j--) {
                        if (checkPositionForFigure(i, j)) {
                            figurebetween = true;
                        }
                    }
                }
            }

            //diagonal rechts hinten
            if (reiheAkt < reiheNeu && spalteAkt > spalteNeu) {
                for (int i = reiheAkt; i >= reiheNeu; i--) {
                    for (int j = spalteAkt; j <= spalteNeu; j++) {
                        if (checkPositionForFigure(i, j)) {
                            figurebetween = true;
                        }
                    }
                }
            }

            //diagonal links hinten
            if (reiheAkt < reiheNeu && spalteAkt < spalteNeu) {
                for (int i = reiheAkt; i >= reiheNeu; i--) {
                    for (int j = spalteAkt; j >= spalteNeu; j--) {
                        if (checkPositionForFigure(i, j)) {
                            figurebetween = true;
                        }
                    }
                }
            }

        } else {

            if (spalteAkt == spalteNeu) {
                //vorne
                if (reiheAkt < reiheNeu) {
                    for (int i = reiheAkt + 1; i < reiheNeu; i++) {
                        if (checkPositionForFigure(i, spalteAkt)) {
                            figurebetween = true;
                        }
                    }
                } else {
                    //hinten
                    for (int i = reiheAkt - 1; i > reiheNeu; i--) {
                        if (checkPositionForFigure(i, spalteAkt)) {
                            figurebetween = true;
                        }
                    }
                }

            }

            if (reiheAkt == reiheNeu) {
                //links
                if (spalteAkt < spalteNeu) {
                    for (int i = spalteAkt + 1; i < spalteNeu; i++) {
                        if (checkPositionForFigure(reiheAkt, i)) {
                            figurebetween = true;
                        }

                    }
                } else {
                    //rechts wip
                    for (int i = spalteAkt - 1; i > spalteNeu; i--) {
                        if (checkPositionForFigure(reiheAkt, i)) {
                            figurebetween = true;
                        }
                    }
                }

            }

            //diagonal rechts vorne
            if (reiheAkt < reiheNeu && spalteAkt < spalteNeu) {
                for (int i = reiheAkt; i >= reiheNeu; i--) {
                    for (int j = spalteAkt; j <= spalteNeu; j++) {
                        if (checkPositionForFigure(i, j)) {
                            figurebetween = true;
                        }
                    }
                }
            }

            //diagonal links vorne
            if (reiheAkt < reiheNeu && spalteAkt > spalteNeu) {
                for (int i = reiheAkt; i >= reiheNeu; i--) {
                    for (int j = spalteAkt; j >= spalteNeu; j--) {
                        if (checkPositionForFigure(i, j)) {
                            figurebetween = true;
                        }
                    }
                }
            }

            //diagonal rechts hinten
            if (reiheAkt > reiheNeu && spalteAkt > spalteNeu) {
                for (int i = reiheAkt; i <= reiheNeu; i++) {
                    for (int j = spalteAkt; j <= spalteNeu; j++) {
                        if (checkPositionForFigure(i, j)) {
                            figurebetween = true;
                        }
                    }
                }
            }

            //diagonal links hinten
            if (reiheAkt > reiheNeu && spalteAkt < spalteNeu) {
                for (int i = reiheAkt; i <= reiheNeu; i++) {
                    for (int j = spalteAkt; j >= spalteNeu; j--) {
                        if (checkPositionForFigure(i, j)) {
                            figurebetween = true;
                        }
                    }
                }
            }

        }

        return figurebetween;
    }
}
