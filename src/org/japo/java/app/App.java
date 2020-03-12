/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.app;

import java.net.UnknownHostException;
import java.util.Scanner;
import org.japo.java.libraries.Utiles;
import org.japo.java.libraries.UtilesHost;
import static org.japo.java.libraries.UtilesHost.miip;
import org.japo.java.libraries.UtilesIP;
import org.japo.java.libraries.UtilesPuertos;

/**
 *
 * @author Lluís CP - aw.lluiscerda@gmail.com
 */
public final class App {
    // Scanner + Codificación Windows

    public static final Scanner SCN = new Scanner(System.in, "ISO-8859-1");

    //separador LS
    public static final String LS = System.getProperty("line.separator");

    //menu error
    public static final String TXT_MENU_ERROR = "Error: Opción Erronea";

    //opciones menu
    public static final String OPC_MENU_PPAL = "IiPpHhXx";

    public final void launchApp() throws UnknownHostException {

        Utiles.banner();

        // BUECLES MENU
        //semaforo
        boolean salirOK = false;
        //bucle menu

        do {
            //mostrar menu
            char opcion = Utiles.obtenerOpcion(
                    TXT_MENU_PPAL, TXT_MENU_ERROR, OPC_MENU_PPAL);
            switch (opcion) {
                case 'h':
                case 'H':
                    UtilesHost.miip();
                    break;
                case 'i':
                case 'I':
                    UtilesIP.escanearip();
                    break;
                case 'p':
                case 'P':
                    UtilesPuertos.escanearPuertos();
                    break;

                default:
                    salirOK = true;
            }
        } while (!salirOK);
        Utiles.hacerPausa();

        System.out.println(
                "---");
        System.out.println(
                "Sesión de Trabajo Terminada");
        System.out.println(
                "Gracias por utilizar nuestros servicios");
        System.out.println(
                "Hasta la próxima");
    }

    public static final String TXT_MENU_PPAL
            = "[H] Cual es mi IP" + LS
            + "[I] Escanear IP" + LS
            + "[P] Escanear Puertos" + LS
            //            + "[S] Escanear Servicio" + LS
            + "---" + LS
            + "[X] Salir" + LS
            + "---" + LS
            + "Introducir opción: ";

}
