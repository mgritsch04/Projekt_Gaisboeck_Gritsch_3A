package Kommunikation;

import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket soc = null;
        String str = null;
        Date d = null;

        try {
            server = new ServerSocket(8020);
            soc = server.accept();
            InputStream is = soc.getInputStream();
            ObjectInput oi = new ObjectInputStream(is);
            SpielfeldTest emp = (SpielfeldTest) oi.readObject();

            OutputStream os = soc.getOutputStream();
            ObjectOutput obj = new ObjectOutputStream(os);

            String feld[] = {"3", "2", "1"};
            SpielfeldTest emp2 = new SpielfeldTest(feld);
            obj.writeObject(emp2);
            obj.flush();
            obj.close();

            System.out.println(emp.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Eroor during serialization");
            System.exit(1);
        }
    }
}
