/*
 * Copyright 2020 Lluís Cerdà Pascual - aw.lluiscerda@gmail.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.libraries;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Lluís CP - aw.lluiscerda@gmail.com
 */
public class UtilesPuertos {

//ESCANER ESTADO PUERTOS
//    public static void servidorPuerto(String[] args) {
//        Socket Skt;
//        String host = "localhost";
//
//        if (args.length > 0) {
//            host = args[0];
//        }
//        for (int i = 0; i < 1024; i++) {
//            try {
//                System.out.println("Buscando " + i);
//                Skt = new Socket(host, i);
//                System.out.println("Hay un servidor en el puerto " + i + " de " + host);
//            } catch (UnknownHostException e) {
//                System.out.println("Error...." + e);
//                break;
//            } catch (IOException e) {
//            }
//        }
//    }

    public static void escanearPuertos() {

        System.out.println("---");
        System.out.println("- Escanear Puertos   -");
        System.out.println("======================");
        System.out.print("");

        //Ip Escucha (entrada)
        String host = "127.0.0.1";

        //inicio busqueda
        int puerto;
        //bucle recorrido + final busqueda
        for (puerto = 0; puerto < 11024; puerto++) {
            try {
                Socket s = new Socket(host, puerto);
                System.out.println("Puerto " + puerto + " Abierto ");

            } catch (UnknownHostException e) {
                System.out.println("Error...");

            } catch (IOException e) {
                System.out.println("Puerto " + puerto + " Cerrado ");
            }
        }

        //Guardar archivo con resultado
        try {

            File archivo = new File("Puertos.log");

            //Escribimos en el archivo con el metodo write
            try (FileWriter escribir = new FileWriter(archivo, true)) {
                //Escribimos en el archivo con el metodo write
                for (puerto = 0; puerto < 11024; puerto++) {
                    escribir.write("Puerto " + puerto + " Abierto ");
                    escribir.write("\r\n");
                }
                escribir.write("Puerto " + puerto + " Cerrado ");
                escribir.write("\r\n");
            }
        } //Si existe un problema al escribir cae aqui //Si existe un problema al escribir cae aqui
        catch (IOException e) {
            System.out.println("");
            System.out.println("Error al escribir");
        }

//    separador
        System.out.println("");
        System.out.println("_____");
    }

//    public static void otra(){
//                String host = "localhost";
//        InetAddress inetAddress = InetAddress.getByName(host);
//
//        String hostName = inetAddress.getHostName();
//        for (int port = 0; port <= 65535; port++) {
//            try {
//                Socket socket = new Socket(hostName, port);
//                String text = hostName + " is listening on port " + port;
//                System.out.println(text);
//                socket.close();
//            } catch (IOException e) {
//    }
}


