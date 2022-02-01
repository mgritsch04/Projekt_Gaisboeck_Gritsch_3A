package Kommunikation;

import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try {
            Socket soc = new Socket("localhost", 8020);

            OutputStream os = soc.getOutputStream();
            ObjectOutput obj = new ObjectOutputStream(os);

            String feld[] = {"1", "2", "3"};
            SpielfeldTest emp = new SpielfeldTest(feld);
            obj.writeObject(emp);

            InputStream is = soc.getInputStream();
            ObjectInput oi = new ObjectInputStream(is);
            SpielfeldTest emp2 = (SpielfeldTest) oi.readObject();

            obj.flush();
            obj.close();

            System.out.println(emp2.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error during serialization");
            System.exit(1);
        }
    }
}
