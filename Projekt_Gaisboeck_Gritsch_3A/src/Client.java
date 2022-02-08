
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        OUTER:

        try {
            Spielfeld spielfeldClient = null;
            boolean isWhiteClient = false;
            Scanner sc = new Scanner(System.in);
            System.out.println("Gib die gewünschte IP-Adresse ein:");
            String ipAdress = sc.nextLine();
            System.out.println("Gib den gewünschten Port ein:");
            int port = Integer.parseInt(sc.nextLine());
            Socket soc = new Socket(ipAdress, port);

            System.out.println("Du bist schwarz");

            OutputStream os = soc.getOutputStream();
            ObjectOutput obj = new ObjectOutputStream(os);

            InputStream is = soc.getInputStream();
            ObjectInput oi = new ObjectInputStream(is);

            int tmp = 0;

            String check = "false";

            while (!check.equals("Schachmatt")) {
                spielfeldClient = (Spielfeld) oi.readObject();
                if (spielfeldClient == null) {
                    System.out.println("Schachmatt");
                    break OUTER;
                }
                tmp = 1;
                check = "false";

                while (!check.equals("true") && !check.equals("Schachmatt")) {
                    spielfeldClient.print();

                    System.out.println("Welche Figur willst du bewegen?");

                    try {
                        System.out.println("Reihe: ");
                        int reiheFigure = Integer.parseInt(sc.nextLine());
                        System.out.println("Spalte: ");
                        int spalteFigure = Integer.parseInt(sc.nextLine());

                        System.out.println("Wohin willst du sie bewegen?");

                        System.out.println("Reihe: ");
                        int reiheMove = Integer.parseInt(sc.nextLine());
                        System.out.println("Spalte: ");
                        int SpalteMove = Integer.parseInt(sc.nextLine());

                        if (checkMove(reiheFigure, spalteFigure, reiheMove, SpalteMove)) {
                            if (spielfeldClient.spielfeld[reiheFigure][spalteFigure].isWhite != isWhiteClient) {
                                System.out.println("Nicht deine Farbe");
                                check = "false";
                            } else {
                                check = spielfeldClient.moveFigure(reiheFigure, spalteFigure, reiheMove, SpalteMove);
                                spielfeldClient.print();
                            }
                        } else {
                            System.out.println("Bitte bleibe im Feld");
                        }
                    } catch (Exception e) {
                        System.out.println("ERROR");
                    }

                }
                if (!check.equals("Schachmatt")) {
                    obj.writeObject(spielfeldClient);
                    obj.flush();
                }
            }

            spielfeldClient.print();
            spielfeldClient = null;
            obj.writeObject(spielfeldClient);
            obj.flush();
            System.out.println("Schachmatt");
            obj.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error during serialization");
            System.exit(1);
        }
    }

    public static boolean checkMove(int a, int b, int c, int d) {
        boolean check = true;
        if (a > 7 || b > 7 || c > 7 || d > 7) {
            check = false;
        } else if (a < 0 || b < 0 || c < 0 || d < 0) {
            check = false;
        }
        return check;
    }
}
