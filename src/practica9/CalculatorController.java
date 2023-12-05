package practica9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CalculatorController extends JFrame {

    private JTextArea screen;
    private JPanel panelContenedor;
    private JPanel panelBotones1;
    private JPanel panelBotones2;

    private CalculatorLogic calculatorLogic = new CalculatorLogic();


    public CalculatorController() {

        super("Calculadora");
        init();

    }



    private void init() {

        int width = 1000; // Ancho deseado
        int height = 2000; // Altura deseada

        JPanel panelContenedor = new JPanel();
        panelContenedor.setLayout(new GridBagLayout());
        panelContenedor.setSize(width, height);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH; // Ajustar tanto horizontal como verticalmente
        constraints.weightx = 1.0; // Estirar horizontalmente
        constraints.weighty = 1.0; // Estirar verticalmente

        // Pantalla
        screen = new JTextArea();
        Font screenFont = new Font(screen.getFont().getName(), Font.PLAIN, 40); // Tamaño de fuente de 20 (cambia según sea necesario)
        screen.setFont(screenFont);
        screen.setText("0");
            //Voy a setear la orientación del texto a la derecha
            //screen.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        screen.setEditable(false);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 5;
        constraints.weighty = 0.1;
        panelContenedor.add(screen, constraints);

        // Panel superior
        JPanel panelSuperior = createFirstPanel(width, height, screen);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 5;
        constraints.weighty = 0.1;
        panelContenedor.add(panelSuperior, constraints);

        // Panel de botones
        JPanel panelBotones = createButtonsPanel(width, height, screen);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 5;
        constraints.weighty = 1.0;
        panelContenedor.add(panelBotones, constraints);

        add(panelContenedor);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    /**
     * Crea el panel superior de la calculadora
     * Dicho panel contiene:
     * <p>
     * - Pantalla para visualizar si hay algún número almacenado en la memoria de la calculadora
     * <p>
     * - Botones de retroceso, CE, C
     *
     * @param width  del panel contenedor de todos los componentes de la calculadora
     * @param height del panel contenedor de todos los componentes de la calculadora
     * @return JPanel con los componentes del panel superior
     */
    private JPanel createFirstPanel(int width, int height, JTextArea screen) {

        JPanel firstPanel = new JPanel();

        firstPanel.setLayout(new GridLayout(1,4,5,5));
        firstPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        // Pantalla memoria

        JTextArea memoryScreen = new JTextArea(" ");
        memoryScreen.setEditable(false);
        memoryScreen.setPreferredSize(new Dimension(width/4, 10));
        firstPanel.add(memoryScreen);

        // Botones del panel Superior

        JButton[] buttons = new JButton[3];

        String[] buttonLabels = {"Retroceso", "CE", "C"};

        int i = 0;
        for (String label : buttonLabels) {
          buttons[i] = new JButton();
          buttons[i].setText(label);
          buttons[i].setForeground(Color.RED);
          if (label.equals("C")) {
            setActionListenerToJButtonOperator(buttons[i]);
          }
          firstPanel.add(buttons[i]);
          i++;
        }


        return firstPanel;

    }

        

    private JPanel createButtonsPanel(int width, int height, JTextArea screen){
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4,6,5,5));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        String[] buttonLabels = {
                "MC", "7", "8", "9", "/", "sqrt",
                "MR", "4", "5", "6", "*", "%",
                "MS", "1", "2", "3", "-", "1/x",
                "M+", "0", "+/-", ".", "+", "="
        };

        for (String label : buttonLabels) {

            if (label.matches("[0-9]")){
                JButton button = new JButton();
                button.setText(label);
                button.setForeground(Color.BLUE);
                setActionListenerToJButtonNumber(button);
                buttonPanel.add(button);
            }

            // Creación de los botones de operaciones

            else {

                if (label.equals("+/-") || label.equals("sqrt") || label.equals("%") || label.equals("1/x") || label.equals(".")) {
                    JButton button = new JButton();
                    button.setText(label);
                    button.setForeground(Color.BLUE);
                    setActionListenerToJButtonOperator(button);
                    buttonPanel.add(button);

                } else {
                    JButton button = new JButton();
                    button.setText(label);
                    button.setForeground(Color.RED);
                    setActionListenerToJButtonOperator(button);
                    buttonPanel.add(button);
                }

            }


        }

        return buttonPanel;


    }

    private void setActionListenerToJButtonOperator(JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String currentText = screen.getText();

                String currentOperator = button.getText();

                if (currentOperator.equals("=")) {
                    calculatorLogic.setOperator(currentOperator);
                    Double result = calculatorLogic.getResult();
                    screen.setText(currentText + currentOperator + result.toString());
                }
                else {
                    if (currentOperator.equals("C")) {
                        calculatorLogic.resetLogic();
                        screen.setText("0");
                    }
                    else {
                        calculatorLogic.setOperator(currentOperator);
                        if (currentText.contains("=")) {
                            Double result = calculatorLogic.getResult();
                            screen.setText(result.toString() + currentOperator);
                        } else {
                            screen.setText(currentText + currentOperator);
                        }
                    }
                }

            }
        });
    }



    private void setActionListenerToJButtonNumber(JButton button) {
            button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Modificar el operando actual
                String numberClicked = button.getText();
                calculatorLogic.assignOperand(numberClicked);
                String currentOperand = calculatorLogic.getOperand();

                // Modifico la pantalla
                if (screen.getText().equals("0")) {
                    screen.setText(currentOperand);
                } else {
                    screen.setText(screen.getText() + numberClicked);
                }

            }
        });
    }


    public static void main(String[] args) {
        new CalculatorController();

    }


}
