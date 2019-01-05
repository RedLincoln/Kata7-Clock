package Clock;

import Model.Model;
import Presenter.Presenter;
import View.ModelDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JFrame  {
    private Model model;
    private ModelDisplay modelDisplay;
    
    public Main() throws HeadlessException {
        setupClock();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setResizable(false);
        this.setTitle("Clock");
        this.setLocationRelativeTo(null);
        this.add(modelDisplay);
    }

    private void setupClock() {
        model = new Model();
        modelDisplay = new ModelDisplay();
        modelDisplay.addKeyListener(keyListener());
        new Presenter(model, modelDisplay);
    }

    public void execute() {
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Main().execute();
    }

    private KeyListener keyListener() {
        return new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE)
                model.updateTimer();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
    }

    private Component button() {
        JButton jButton = new JButton();
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        return jButton;
    }

}

