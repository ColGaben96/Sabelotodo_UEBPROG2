package co.edu.unbosque.controller;

import java.net.InetAddress;

public class AddressPair {
    private InetAddress address;
    private int port;

    public AddressPair(InetAddress address, int port) {
        this.address = address;
        this.port = port;
    }

    public InetAddress getAddress() {
        return address;
    }

    public int getPort() {
        return port;
    }
}
