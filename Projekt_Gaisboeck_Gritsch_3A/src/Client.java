/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import Kommunikation.*;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author Fabian
 */
public class Client {

    public static void main(String[] args) {
        try {
            Socket soc = new Socket("localhost", 8020);

            OutputStream os = soc.getOutputStream();
            ObjectOutput obj = new ObjectOutputStream(os);

            Spielfeld spielfeldClient = new Spielfeld();
            obj.writeObject(spielfeldClient);

            InputStream is = soc.getInputStream();
            ObjectInput oi = new ObjectInputStream(is);
            Spielfeld emp2 = (Spielfeld) oi.readObject();

            obj.flush();
            obj.close();
            emp2.print();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error during serialization");
            System.exit(1);
        }
    }
}
