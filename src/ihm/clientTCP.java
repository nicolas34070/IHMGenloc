/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Nico
 */
public class clientTCP {

    private boolean etatClient;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public clientTCP() throws IOException {
        etatClient = false;
        this.demarrageClient();
    }

    public void demarrageClient() throws IOException {

       
            socket = new Socket("192.168.1.83", 1234);
            System.out.println("Connexion effectuée");

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());
            etatClient = true;
    }

    public void fermerClient() throws IOException {
        socket.close();
        etatClient = false;
    }

}
