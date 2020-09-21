package co.edu.unbosque.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * <h1>Description</h1>
 * <p>This class is intended for client's uses. Literally is just to check their's IP</p>
 * @author Gabriel Blanco
 * @version 1.0
 */
public class IPControl {
    private String ip = "";
    public final String PRUEBAS = "127.0.0.1";

    /**
     * <h1>Description</h1><br>
     * <p>Method to check IP</p>
     * @author Gabriel Blanco
     * @throws IOException
     */
    public void checkIP() throws IOException {
        try {
            URL amazonIP = new URL("https://checkip.amazonaws.com/");
            BufferedReader in = new BufferedReader(new InputStreamReader(amazonIP.openStream()));
            ip = in.readLine();
        } catch (IOException e) {
            checkIP();
        }
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
