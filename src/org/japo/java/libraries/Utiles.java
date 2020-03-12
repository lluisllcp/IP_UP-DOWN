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

import static org.japo.java.app.App.SCN;



/**
 *
 * @author Lluís CP - aw.lluiscerda@gmail.com
 */
public class Utiles {
    
//BANNER
    public static final void banner() {
        System.out.println("    ### ######     #     # ######       ##       ######  ####### #     # #     # ");
        System.out.println("     #  #     #    #     # #     #     #  #      #     # #     # #  #  # ##    # ");
        System.out.println("     #  #     #    #     # #     #      ##       #     # #     # #  #  # # #   # ");
        System.out.println("     #  ######     #     # ######      ###       #     # #     # #  #  # #  #  # ");
        System.out.println("     #  #          #     # #          #   # #    #     # #     # #  #  # #   # # ");
        System.out.println("     #  #          #     # #          #    #     #     # #     # #  #  # #    ## ");
        System.out.println("    ### #           #####  #           ###  #    ######  #######  ## ##  #     # ");
        System.out.println("");
        System.out.println("                                                                  by LLCP(2020)");
        System.out.println("    _____________________________________________________________________________");
        System.out.println("");

    }

    //==========================================
    // Generar hacer pausa + intro
    public static final void hacerPausa() {
        System.out.println("---");
        System.out.print("Pulse Intro para continuar ...");
        SCN.nextLine();
    }

    //opciones + consola > opcion
    public static final char obtenerOpcion(String msgUsr, String msgErr, String opc) {
        char opcion;
        boolean opcionOK = false;
        do {
            opcion = obtenerCaracter(msgUsr, "");
            if (opc.contains(opcion + "")) {
                opcionOK = true;
            } else {
                System.out.println("---");
                System.out.println(msgErr);
                System.out.println("---");
            }
        } while (!opcionOK);
        return opcion;
    }

    public static final char obtenerCaracter(String msgUsr, String msgErr) {
        char caracter = 0;
        try {
            System.out.print(msgUsr);
            caracter = SCN.nextLine().charAt(0);
        } catch (Exception e) {
            System.out.println("---");
            System.out.println(msgErr);
            System.out.println("---");
        }
        return caracter;

    }

}
