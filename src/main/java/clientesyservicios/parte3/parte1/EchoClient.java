/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientesyservicios.parte3.parte1;

/**
 *
 * @author Andres
 */
import java.io.*;
import java.net.*;

public class EchoClient {

    public static void main(String[] args) throws IOException {

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            echoSocket = new Socket("127.0.0.1", 35000);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("DonÅft know about host!.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("CouldnÅft get I/O for "
                    + "the connection to: localhost.");
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(
                new InputStreamReader(System.in));
        String userInput,outputLine;

        while ((userInput = stdIn.readLine()) != null) {
            outputLine = "Cudrado :" + (int)Math.pow(Integer.parseInt(userInput),2);
            out.println(outputLine);
        }
        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();
    }
}
