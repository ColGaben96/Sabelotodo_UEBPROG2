package co.edu.unbosque.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class IPControl {
    private String ip = "";
    public final String PRODUCCION = "186.31.44.159";
    public final String PRUEBAS = "127.0.0.1";

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
