
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {

        InetAddress ip = null;
        try {
            ip = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        System.out.println("IP-Adresse Server = " + ip.getHostAddress());

        ServerSocket server = null;
        Socket soc = null;
        String str = null;
        Date d = null;
        OUTER:

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Gib den gewünschten Port ein:");
            int port = Integer.parseInt(sc.nextLine());
            boolean isWhiteServer = true;
            server = new ServerSocket(port);
            soc = server.accept();

            System.out.println("Du bist weiß");

            //input
            InputStream is = soc.getInputStream();
            ObjectInput oi = new ObjectInputStream(is);
            //output
            OutputStream os = soc.getOutputStream();
            ObjectOutput obj = new ObjectOutputStream(os);
            //inputUser
            Spielfeld spielfeld = new Spielfeld();

            int tmp = 0;

            String check = "false";

            while (!check.equals("Schachmatt")) {
                if (tmp != 0) {
                    spielfeld = (Spielfeld) oi.readObject();
                }
                if (spielfeld == null) {
                    System.out.println("Schachmatt");
                    break OUTER;
                }
                tmp = 1;
                check = "false";

                while (!check.equals("true") && !check.equals("Schachmatt")) {
                    spielfeld.print();

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
                            if (spielfeld.spielfeld[reiheFigure][spalteFigure].isWhite != isWhiteServer) {
                                System.out.println("Nicht deine Farbe");
                                check = "false";
                            } else {
                                check = spielfeld.moveFigure(reiheFigure, spalteFigure, reiheMove, SpalteMove);
                                spielfeld.print();
                            }
                        } else {
                            System.out.println("Falsche Eingabe");
                        }
                    } catch (Exception e) {
                        System.out.println("ERROR");
                        e.printStackTrace();
                    }
                }
                if (!check.equals("Schachmatt")) {
                    obj.writeObject(spielfeld);
                    obj.flush();
                }
            }
            spielfeld.print();
            spielfeld = null;
            obj.writeObject(spielfeld);
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
