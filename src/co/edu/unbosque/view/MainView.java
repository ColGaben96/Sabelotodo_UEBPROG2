package co.edu.unbosque.view;

import co.edu.unbosque.controller.Controller;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {

    private Panel_preguntas inGame = new Panel_preguntas();
    private PanelBienvenida mainMenu = new PanelBienvenida();

    public void start(Controller c) {
        load();
        listen(c);
    }

    public void load() {
        setSize(800, 600);
        setResizable(false);
        setTitle("SABELOTODO");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(mainMenu, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void listen(Controller c) {
        mainMenu.getBotonJugar().addActionListener(c);
        mainMenu.getBotonSalir().addActionListener(c);
        inGame.getUno().addActionListener(c);
        inGame.getDos().addActionListener(c);
        inGame.getTres().addActionListener(c);
        inGame.getCuatro().addActionListener(c);
    }

    public void goGame() {
        remove(mainMenu);
        add(inGame, BorderLayout.CENTER);
        validate();
    }

    public void goMain() {
        remove(inGame);
        add(mainMenu, BorderLayout.CENTER);
        validate();
    }

    public Panel_preguntas getInGame() {
        return inGame;
    }

    public PanelBienvenida getMainMenu() {
        return mainMenu;
    }
}
