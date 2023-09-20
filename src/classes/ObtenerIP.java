/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ObtenerIP {
    private String ip;

    public ObtenerIP() {
        try {
            InetAddress direccion = InetAddress.getLocalHost();
            ip = direccion.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public String obtenerIP() {
        return ip;
    }
}

