package co.edu.unbosque.controller;

import java.net.InetAddress;

/**
 * <h1>Description</h1><br>
 *     <p>Class to save each ip</p>
 * @author Gabriel Blanco
 */
public class AddressPair {
    private InetAddress address;
    private int port;
    private boolean playing;

    /**
     * Constructor to define AddressPair
     * @author Gabriel Blanco
     * @param address
     * @param port
     * @param playing
     */
    public AddressPair(InetAddress address, int port, boolean playing) {
        this.address = address;
        this.port = port;
        this.playing = playing;
    }

    public InetAddress getAddress() {
        return address;
    }

    public int getPort() {
        return port;
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }
}
