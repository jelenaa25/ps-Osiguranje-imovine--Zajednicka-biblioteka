/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.ObjectInputStream;
import java.net.Socket;

/**
 *
 * @author Korisnik
 */
public class Primalac {
    private Socket socket;

    public Primalac(Socket socket) {
        this.socket = socket;
    }
    
     public Object primi() throws Exception{
        ObjectInputStream in;
        try {
            in = new ObjectInputStream(socket.getInputStream());
            return in.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw  new Exception("Error receive object:" + ex.getMessage());
        }
       
    }
}
