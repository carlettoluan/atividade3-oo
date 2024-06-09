import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraIMC extends JFrame {
    private JTextField textPeso;
    private JTextField textAltura;
    private JButton calcularButton;
    private JTextArea textAreaResultado;

    public CalculadoraIMC() {
        setTitle("Calculadora de IMC");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(new JLabel("Peso em Kg:"));
        textPeso = new JTextField();
        add(textPeso);

        add(new JLabel("Altura em Cm:"));
        textAltura = new JTextField();
        add(textAltura);

        calcularButton = new JButton("Calcular IMC");
        add(calcularButton);

        textAreaResultado = new JTextArea();
        add(textAreaResultado);

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double peso = Double.parseDouble(textPeso.getText());
                double altura = Double.parseDouble(textAltura.getText()) / 100;
                double imc = peso / (altura * altura);
                textAreaResultado.setText("IMC: " + String.format("%.2f", imc));
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculadoraIMC().setVisible(true);
            }
        });
    }
}
