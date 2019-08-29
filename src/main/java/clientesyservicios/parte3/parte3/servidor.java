/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientesyservicios.parte3.parte3;

/**
 *
 * @author Andres
 */

import java.net.*;
import java.io.*;

public class servidor {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        Socket clientSocket = null;
        while (true) {
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine, outputLine;
            String inputu = null;
            while ((inputLine = in.readLine()) != null) {
                try {
                    if (inputLine.startsWith("GET")) {
                        if (!inputLine.startsWith("GET / ")) {
                            inputu = inputLine;
                        }
                    }
                } catch (java.lang.StringIndexOutOfBoundsException e) {
                }
                //System.out.println(inputLine);
                if (!in.ready()) {
                    break;
                }
            }
            if (inputu != null) {
                String[] temp;
                temp = inputu.split(" ");
                System.out.println(temp[1]);
                File f = new File(temp[1].substring(1));
                BufferedReader entrada;
                String flag="";
                try {
                    entrada = new BufferedReader(new FileReader(f));
                    while (entrada.ready()) {
                        flag += entrada.readLine();
                    }
                    
                } catch (IOException e) {
                    e.printStackTrace();
                }
                inputu=flag;
            }
            outputLine = "HTTP/1.1 200 OK\r\n"
                    + "Content-Type: text/html\r\n"
                    + "\r\n"
                    + inputu
                    + inputLine;
            out.println(outputLine);
        }
    }
}