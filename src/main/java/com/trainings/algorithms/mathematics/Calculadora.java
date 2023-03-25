package com.trainings.algorithms.mathematics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora {
    public static void main(String[] args) {

        JFrame f = new JFrame();
        f.setLayout(new BorderLayout());
        final JPanel p = new JPanel();

        p.add(new JLabel("Calculadora"));
        p.add(new JLabel("Primeiro programa do SAMUEL."));
        p.add(new JLabel("Soma: " + calcular(3, 4, Operacao.SOMA)));
        p.add(new JLabel("Multiplicacao: " + multiplicar(3, 4)));
        p.add(new JLabel("Subtracao: " + subtrair(4, 1)));
        p.add(new JLabel("Divisao: " + calcular(4, 1, Operacao.DIVISAO)));

        f.add(p, BorderLayout.CENTER);

        JButton b = new JButton("Esconder o Resultado");
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                p.setVisible(!p.isVisible());
                String mensagemBotao = p.isVisible() ? "Esconder o Resultado" : "Mostrar o Resultado";
                b.setText(mensagemBotao);
            }
        });

        f.add(b, BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);


    }

    private static int calcular(int a, int b, Operacao operacao) {
        int resultado = 0;

        switch (operacao) {
            case SOMA: {
                resultado = somar(a, b);
                break;
            }
            case SUBTRACAO: {
                resultado = subtrair(a, b);
                break;
            }
            case MULTIPLICACAO: {
                resultado = multiplicar(a, b);
                break;
            }
            case DIVISAO: {
                resultado = dividir(a, b);
                break;
            }
            default:
                throw new IllegalArgumentException("Unexpected value: " + operacao);
        }

        return resultado;
    }

    private static int somar(int a, int b) {
        return a + b;
    }

    private static int multiplicar(int a, int b) {
        return a * b;
    }

    private static int subtrair(int a, int b) {
        return a - b;
    }

    private static int dividir(int a, int b) {
        return a / b;
    }

    enum Operacao {
        SOMA, SUBTRACAO, MULTIPLICACAO, DIVISAO
    }
}
