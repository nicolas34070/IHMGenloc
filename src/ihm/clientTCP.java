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
        //  this.demarrageClient();
    }

    public void demarrageClient() throws IOException {

        setSocket(new Socket("192.168.0.55", 1234));
        System.out.println("Connexion effectuée");

        in = new BufferedReader(new InputStreamReader(getSocket().getInputStream()));
        out = new PrintWriter(getSocket().getOutputStream());
        etatClient = true;
    }

    public void fermerClient() throws IOException {

                try {
                    getSocket().close();
                    System.out.println("The server is shut down!");
                    etatClient = false;
                } catch (IOException e) {
                    /* failed */ }
    }
    
        /**
     * @return the socket
     */
    public Socket getSocket() {
        return socket;
    }

    /**
     * @param socket the socket to set
     */
    public void setSocket(Socket socket) {
        this.socket = socket;
    }

}
