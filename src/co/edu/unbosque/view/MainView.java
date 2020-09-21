package co.edu.unbosque.view;

import co.edu.unbosque.controller.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * @author Laura Chiquillo - Sebastian Cubillos - Gabriel Blanco
 * @version 1.0
 */
public class MainView extends JFrame {

    private Panel_preguntas inGame = new Panel_preguntas();
    private PanelBienvenida mainMenu = new PanelBienvenida();
    private Panel_empate empate = new Panel_empate();
    private Panel_ganador ganador = new Panel_ganador();

    /**
     * @author Gabriel Blanco
     * @param c
     */
    public void start(Controller c) {
        load();
        listen(c);
    }

    /**
     * @author Gabriel Blanco
     */
    public void load() {
        setSize(800, 600);
        setResizable(true);
        setTitle("SABELOTODO");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(mainMenu, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * @author Gabriel Blanco
     * @param c
     */
    public void listen(Controller c) {
        mainMenu.getBotonJugar().addActionListener(c);
        mainMenu.getBotonSalir().addActionListener(c);
        inGame.getUno().addActionListener(c);
        inGame.getDos().addActionListener(c);
        inGame.getTres().addActionListener(c);
        inGame.getCuatro().addActionListener(c);
    }

    /**
     * @author Gabriel Blanco
     */
    public void goGame() {
        remove(mainMenu);
        add(inGame, BorderLayout.CENTER);
        validate();
    }

    /**
     * @author Gabriel Blanco
     */
    public void goMain() {
        remove(inGame);
        add(mainMenu, BorderLayout.CENTER);
        validate();
    }

    /**
     * @author Gabriel Blanco
     */
    public void goWinner() {
        remove(inGame);
        add(ganador, BorderLayout.CENTER);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        remove(ganador);
        add(mainMenu, BorderLayout.CENTER);
    }

    /**
     * @author Gabriel Blanco
     * @return
     */
    public void goTie() {
        remove(inGame);
        add(empate, BorderLayout.CENTER);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        remove(empate);
        add(mainMenu, BorderLayout.CENTER);
    }

    public Panel_preguntas getInGame() {
        return inGame;
    }

    public PanelBienvenida getMainMenu() {
        return mainMenu;
    }

    public Panel_empate getEmpate() {
        return empate;
    }

    public Panel_ganador getGanador() {
        return ganador;
    }

    /**
     * @author Gabriel Blanco
     * @param question
     */
    public void refreshGame(String question) {
        var questionResponse = question.split("Q:");
        var questionStructure = questionResponse[1].split(";");
        getInGame().getPregunta().setText(questionStructure[0]);
        getInGame().getUno().setText(questionStructure[1]);
        getInGame().getDos().setText(questionStructure[2]);
        getInGame().getTres().setText(questionStructure[3]);
        getInGame().getCuatro().setText(questionStructure[4]);

    }



}
