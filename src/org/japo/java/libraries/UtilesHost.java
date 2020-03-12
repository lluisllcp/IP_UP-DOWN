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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

/**
 *
 * @author Lluís CP - aw.lluiscerda@gmail.com
 */
public class UtilesHost {

//CUAL ES MI IP y host
    public static void miip() throws UnknownHostException {

// Devuelve la instancia de InetAddress que contiene localhost e ip
        InetAddress localhost = InetAddress.getLocalHost();
        java.net.InetAddress localMachine = java.net.InetAddress.getLocalHost();

        System.out.println("_____");
        System.out.println("");
        System.out.println("Nombre de host de la máquina local: " + localMachine.getHostName());
        System.out.println("");
        System.out.println("Dirección IP privada: "
                + (localhost.getHostAddress()).trim());
        System.out.println("");

// Encuentra la dirección IP pública
        String iprivada = "";
        try {
            URL url_name = new URL("http://bot.whatismyipaddress.com");

            BufferedReader sc
                    = new BufferedReader(new InputStreamReader(url_name.openStream()));

// lee la dirección IP del sistema
            iprivada = sc.readLine().trim();
        } catch (IOException e) {
            iprivada = "No se puede ejecutar correctamente";
        }
        System.out.println("Dirección IP pública: " + iprivada + "\n");
        System.out.println("");
        System.out.println("-----");
    }
}
