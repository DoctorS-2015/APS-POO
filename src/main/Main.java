package main;

import ui.TelaPrincipal;

import javax.swing.SwingUtilities;

/**
 * Classe principal responsável por iniciar a aplicação.
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaPrincipal tela = new TelaPrincipal();
            tela.setVisible(true);
        });
    }
}
