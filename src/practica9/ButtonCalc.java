package practica9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonCalc extends JButton {
    private String label;
    private Color color;

    private Font font;

    private boolean isOperator;

    public ButtonCalc(String label, Color color, boolean isOperand, JTextArea screen){

        super(label);
        this.label = label;
        this.font = new Font("Arial", Font.PLAIN, 20);
        setFont(font);
        this.setForeground(color);
        if (isOperand) {
            actionOperand(screen);
        } else {
            actionOperator(screen);
        }

    }

    public void actionOperand (JTextArea screen) {
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String screenText = screen.getText();

                if (screenText.matches("0")) {
                    screen.setText(label);
                } else {
                    screen.setText(screenText+label);
                }

            }
        });
    }

    public void actionOperator (JTextArea screen) {
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String screenText = screen.getText();
                switch (label) {
                    case "+":
                        String currentText = screen.getText();
                        screen.setText(currentText + "+");
                        break;
                    case "-":
                        screen.setText(screen.getText() + "-");
                        break;
                    case "*":
                        screen.setText(screen.getText() + "*");
                        break;
                    case "/":
                        screen.setText(screen.getText() + "/");
                        break;

                }
            }
        });
       }
    }

