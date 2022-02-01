
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket soc = null;
        String str = null;
        Date d = null;

        try {
            server = new ServerSocket(8020);
            soc = server.accept();

            //input
            InputStream is = soc.getInputStream();
            ObjectInput oi = new ObjectInputStream(is);
            //output
            OutputStream os = soc.getOutputStream();
            ObjectOutput obj = new ObjectOutputStream(os);
            //inputUser
            Scanner sc = new Scanner(System.in);
            Spielfeld spielfeld = new Spielfeld();

            int tmp = 0;

            while (tmp < 10) {
                if (tmp != 0) {
                    spielfeld = (Spielfeld) oi.readObject();
                }
                spielfeld.print();

                tmp++;
                System.out.println("Welche Figur wollen Sie bewegen?");

                System.out.println("Reihe: ");
                int reiheFigure = Integer.parseInt(sc.nextLine());
                System.out.println("Spalte: ");
                int spalteFigure = Integer.parseInt(sc.nextLine());

                System.out.println("Wohin wollen Sie sie hinbewegen?");

                System.out.println("Reihe: ");
                int reiheMove = Integer.parseInt(sc.nextLine());
                System.out.println("Spalte: ");
                int SpalteMove = Integer.parseInt(sc.nextLine());

                spielfeld.moveFigure(reiheFigure, spalteFigure, reiheMove, SpalteMove);
                spielfeld.print();

                obj.writeObject(spielfeld);
                obj.flush();
            }

            obj.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Eroor during serialization");
            System.exit(1);
        }
    }
}
