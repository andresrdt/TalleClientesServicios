/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientesyservicios.parte3.parte2;

import java.net.*;
import java.io.*;
import java.lang.NumberFormatException;
/**
 *
 * @author Andres
 */
public class EchoServer {
     public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));
        String inputLine, outputLine;
        String bandera = "cos";
        while ((inputLine = in.readLine()) != null) {
            outputLine = "Respuesta:" + inputLine;
            try {
                Double respuesta = null;
                Double input = Double.parseDouble(inputLine);
                if (bandera.equals("sin")) {
                    respuesta = Math.sin(input);
                } else if (bandera.equals("cos")) {
                    respuesta = Math.cos(input);
                } else {
                    respuesta = Math.tan(input);
                }
                out.println("Respuesta: " + respuesta);
            } catch (NumberFormatException e) {
                if (inputLine.startsWith("fun:")) {
                    if (inputLine.substring(4).equals("sin") || inputLine.substring(4).equals("cos") || inputLine.substring(4).equals("tan")) {
                        bandera = inputLine.substring(4);
                        out.println("Operacion actual: " + bandera);
                    } else {
                        out.println("The operation is invalid, try again");
                    }
                }else {
                    if (outputLine.equals("Respuesta: Bye.")) {
                        break;
                    }
                    out.println("The input is invalid, try again");
                }
            }
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
