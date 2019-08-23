/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientesyservicios.parte1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author 2112076
 */
public class urlParts {
        static URL google;
    public static void main(String[] args) throws Exception {
        google = new URL("http://www.google.com:8080/test.html?name=prueba#elcapi");
        try (BufferedReader reader
                = new BufferedReader(new InputStreamReader(google.openStream()))) {
             String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);
            }
             } catch (IOException x) {
            System.err.println(x);
            }
        getMethods();
    }

    public static void getMethods() {
        System.out.println("metodo getProtocol() " + google.getProtocol());
        System.out.println("metodo getAuthority() " + google.getAuthority());
        System.out.println("metodo getHost() " + google.getHost());
        System.out.println("metodo getPort() " + google.getPort());
        System.out.println("metodo getPath() " + google.getPath());
        System.out.println("metodo getQuery() " + google.getQuery());
        System.out.println("metodo getFile() " + google.getFile());
        System.out.println("metodo getRef() " + google.getRef());
    }
}
