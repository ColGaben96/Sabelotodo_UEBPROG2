package co.edu.unbosque.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ExternalIP {
    private String ip = "";

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
}
