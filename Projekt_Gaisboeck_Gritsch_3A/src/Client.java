
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
        try {
            Socket soc = new Socket("localhost", 8020);
            Scanner sc = new Scanner(System.in);

            OutputStream os = soc.getOutputStream();
            ObjectOutput obj = new ObjectOutputStream(os);

            InputStream is = soc.getInputStream();
            ObjectInput oi = new ObjectInputStream(is);

            int tmp = 0;

            while (tmp < 10) {
                Spielfeld spielfeldClient = (Spielfeld) oi.readObject();
                spielfeldClient.print();

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

                spielfeldClient.moveFigure(reiheFigure, spalteFigure, reiheMove, SpalteMove);
                spielfeldClient.print();

                obj.writeObject(spielfeldClient);
                obj.flush();
            }

            obj.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error during serialization");
            System.exit(1);
        }
    }
}
