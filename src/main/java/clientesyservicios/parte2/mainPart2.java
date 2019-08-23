/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientesyservicios.parte2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author 2112076
 */
public class mainPart2 {

    public static void main(String[] args) throws MalformedURLException {
        String url;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite un url");
        url = teclado.nextLine();
        URL uri = new URL(url);
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(uri.openStream()));
            File archivo = new File("texto.html");
            FileWriter escribir = new FileWriter(archivo, true);
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                escribir.write(inputLine);
            }
            escribir.close();
        } catch (Exception e) {
            System.out.println("Error al escribir");
        }
    }

}
