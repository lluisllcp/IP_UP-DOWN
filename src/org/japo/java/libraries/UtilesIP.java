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
import static org.japo.java.app.App.SCN;

/**
 *
 * @author Lluís CP - aw.lluiscerda@gmail.com
 */
public class UtilesIP {

//ESCANER ESTADO IP
    public static void escanearip() {

        try {
            System.out.println("---");
            System.out.println("-    Escanear IP     -");
            System.out.println("======================");
            System.out.print("Ingresa el rango de IP (por ejemplo, 192.168.0)... ");

            //entrada
            String IP = SCN.nextLine();

            //inicio busqueda
            int i = 0;
            //bucle recorrido + final busqueda
            while (i < 256) {
                //string ip + punto + busqueda incremento
                InetAddress address = InetAddress.getByName(IP + "." + i);

                // Intenta alcanzar la dirección especificada dentro del tiempo de espera (250s)
                // punto Si durante este período la dirección no puede ser
                // alcanzar entonces el método devuelve falso.
                boolean accesible;
                //salida en consola conjunto ip + accesible (estado)
                if (accesible = address.isReachable(60)) {
                    System.out.println(IP + "." + i + " " + "UP");
                } else {
                    System.out.println(IP + "." + i + " " + "DOWN");
                }
                //incremento octeto final ip
                i++;

                //Guardar archivo con resultado
                try {
                    //Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
                    File archivo = new File("IP.log");

                    //Escribimos en el archivo con el metodo write
                    try ( //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
                            FileWriter escribir = new FileWriter(archivo, true)) {
                        //Escribimos en el archivo con el metodo write
                        for (int e = 0; i < 0; i++) {
                            escribir.write(IP + "." + i + " " + accesible);
                            escribir.write("\r\n");
                        }
                        escribir.write(IP + "." + i + " " + accesible);
                        escribir.write("\r\n");
                    }
                } //Si existe un problema al escribir cae aqui //Si existe un problema al escribir cae aqui
                catch (IOException e) {
                    System.out.println("");
                    System.out.println("Error al escribir");
                }
            }
        } catch (IOException e) {
            System.out.println("");
            System.out.println("ERROR: Formato Incorrecto!");
        }

        //separador
        System.out.println("");
        System.out.println("_____");
    }

}
