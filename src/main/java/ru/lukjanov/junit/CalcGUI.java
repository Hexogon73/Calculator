package ru.lukjanov.junit;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcGUI {
    public static void main(String[] args) {
        CalcGUI gui = new CalcGUI();
    }

    private JTextField firstNumber;
    private JTextField secondNumber;
    private JTextField resultNumber;
    private JLabel label4;

    public CalcGUI() {
        JFrame frame = new JFrame("Calculator GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.decode("#cfddce"));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        JPanel panel1 = new JPanel();
        panel1.setBorder(new EmptyBorder(10, 10, 10, 10));
        JPanel panel2 = new JPanel();
        panel2.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel2.setBackground(Color.decode("#c4ceff"));
        JPanel panel3 = new JPanel();

        firstNumber = new JTextField("0", 8);
        secondNumber = new JTextField("0", 8);
        resultNumber = new JTextField(8);
        JLabel label1 = new JLabel("Первое число");
        JLabel label2 = new JLabel("Второе число");
        JLabel label3 = new JLabel("Результат");
        label4 = new JLabel("");

        panel1.setLayout(new GridLayout(3, 1, 10, 10));
        panel1.add(label1);
        panel1.add(firstNumber);
        panel1.add(label2);
        panel1.add(secondNumber);
        panel1.add(label3);
        panel1.add(resultNumber);

        panel2.setLayout(new GridLayout(2, 3, 10, 10));
        panel3.setLayout(new GridLayout(2, 3, 10, 10));
        panel3.add(label4);


        JButton bSum = new JButton("+");
        bSum.addActionListener(new SumListener());
        JButton bSubstract = new JButton("-");
        bSubstract.addActionListener(new SubListener());
        JButton bMultiple = new JButton("*");
        bMultiple.addActionListener(new MultipleListener());
        JButton bDivide = new JButton("/");
        bDivide.addActionListener(new DivideListener());
        JButton bSQRT = new JButton("" + '\u221A');
        bSQRT.addActionListener(new SqrtListener());
        JButton bClean = new JButton("C");
        bClean.addActionListener(new ClearFieldListener());
        bClean.setBackground(Color.red);

        Font BigFontTR = new Font("TimesRoman", Font.BOLD, 20);
        JButton[] operButtons = {bClean, bSum, bSubstract, bMultiple, bDivide, bSQRT};
        for (JButton ob : operButtons) {
            ob.setFont(BigFontTR);
            panel2.add(ob);
        }

        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(350, 350);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    class ClearFieldListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            firstNumber.setText("");
            secondNumber.setText("");
            resultNumber.setText("");
        }
    }

    class SumListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                double a = Double.parseDouble(firstNumber.getText());
                double b = Double.parseDouble(secondNumber.getText());
                resultNumber.setText(String.format("%.2f", getSum(a, b)));
            } catch (NumberFormatException e1) {
                resultNumber.setText("Err");
                label4.setText("Err: Неверный формат числа или пустое поле");
            }
        }
    }

    class SubListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                double a = Double.parseDouble(firstNumber.getText());
                double b = Double.parseDouble(secondNumber.getText());
                resultNumber.setText(String.format("%.2f", getSubtract(a, b)));
            } catch (NumberFormatException e1) {
                resultNumber.setText("Err");
                label4.setText("Err: Неверный формат числа или пустое поле");
            }
        }
    }

    class MultipleListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                double a = Double.parseDouble(firstNumber.getText());
                double b = Double.parseDouble(secondNumber.getText());
                resultNumber.setText(String.format("%.2f", getMultiple(a, b)));
            } catch (NumberFormatException e1) {
                resultNumber.setText("Err");
                label4.setText("Err: Неверный формат числа или пустое поле");
            }
        }
    }

    class DivideListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                double a = Double.parseDouble(firstNumber.getText());
                double b = Double.parseDouble(secondNumber.getText());
                resultNumber.setText(String.format("%.2f", getDivide(a, b)));
            } catch (ArithmeticException e1) {
                resultNumber.setText("Err");
                label4.setText("Err: Деление на ноль");
            } catch (NumberFormatException e1) {
                resultNumber.setText("Err");
                label4.setText("Err: Неверный формат числа или пустое поле");
            }
        }
    }

    class SqrtListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                double a = Double.parseDouble(firstNumber.getText());
                secondNumber.setText("");
                resultNumber.setText(String.format("%.2f", getSQRT(a)));
            } catch (NumberFormatException e1) {
                resultNumber.setText("Err");
                label4.setText("Err: Неверный формат числа или пустое поле");
            }
        }
    }


    public double getSum(double x, double y) {
        return x + y;
    }

    public double getSubtract(double x, double y) {
        return x - y;
    }

    public double getMultiple(double x, double y) {
        return x * y;
    }

    public double getDivide(double x, double y) {
        return x / y;
    }

    public double getSQRT(double x) {
        return Math.sqrt(x);
    }
}
