package ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import model.Carro;
import model.Moto;
import model.Veiculo;
import service.TransporteService;

/**
 * Interface gráfica simples em Swing.
 * O objetivo é facilitar a apresentação dos conceitos de POO de forma visual.
 */
public class TelaPrincipal extends JFrame {
    private TransporteService transporteService;

    private JTextField campoPlaca;
    private JTextField campoModelo;
    private JTextField campoCliente;
    private JTextField campoOrigem;
    private JTextField campoDestino;
    private JComboBox<String> comboTipo;
    private JTextArea areaResultado;

    public TelaPrincipal() {
        transporteService = new TransporteService();
        configurarJanela();
        montarInterface();
    }

    private void configurarJanela() {
        setTitle("LogAuto - Controle de Transporte via Cegonha");
        setSize(980, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void montarInterface() {
        JPanel painelPrincipal = new JPanel(new BorderLayout(15, 15));
        painelPrincipal.setBorder(new EmptyBorder(20, 20, 20, 20));
        painelPrincipal.setBackground(new Color(245, 247, 250));

        JLabel titulo = new JLabel("LogAuto Transportes", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titulo.setForeground(new Color(20, 45, 80));

        JLabel subtitulo = new JLabel("Sistema didático de POO com Java Swing", SwingConstants.CENTER);
        subtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        subtitulo.setForeground(new Color(80, 90, 105));

        JPanel cabecalho = new JPanel(new GridLayout(2, 1));
        cabecalho.setOpaque(false);
        cabecalho.add(titulo);
        cabecalho.add(subtitulo);

        JPanel formulario = criarFormulario();
        JPanel painelRelatorio = criarPainelRelatorio();

        painelPrincipal.add(cabecalho, BorderLayout.NORTH);
        painelPrincipal.add(formulario, BorderLayout.WEST);
        painelPrincipal.add(painelRelatorio, BorderLayout.CENTER);

        add(painelPrincipal);
    }

    private JPanel criarFormulario() {
        JPanel painel = new JPanel(new GridBagLayout());
        painel.setPreferredSize(new Dimension(320, 0));
        painel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 225, 235)),
                new EmptyBorder(20, 20, 20, 20)
        ));
        painel.setBackground(Color.WHITE);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(6, 0, 6, 0);
        c.gridx = 0;
        c.weightx = 1;

        campoPlaca = criarCampo();
        campoModelo = criarCampo();
        campoCliente = criarCampo();
        campoOrigem = criarCampo();
        campoDestino = criarCampo();
        comboTipo = new JComboBox<>(new String[]{"Carro", "Moto"});
        comboTipo.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        adicionarLinha(painel, c, "Placa", campoPlaca);
        adicionarLinha(painel, c, "Modelo", campoModelo);
        adicionarLinha(painel, c, "Cliente", campoCliente);
        adicionarLinha(painel, c, "Origem", campoOrigem);
        adicionarLinha(painel, c, "Destino", campoDestino);
        adicionarLinha(painel, c, "Tipo do veículo", comboTipo);

        JButton botaoAdicionar = criarBotao("Adicionar veículo");
        botaoAdicionar.addActionListener(e -> adicionarVeiculo());

        JButton botaoTransporte = criarBotao("Gerar transporte");
        botaoTransporte.addActionListener(e -> gerarTransporte());

        c.gridy++;
        painel.add(botaoAdicionar, c);
        c.gridy++;
        painel.add(botaoTransporte, c);

        JButton botaoExemplo = criarBotaoSecundario("Carregar exemplo");
        botaoExemplo.addActionListener(e -> carregarExemplo());
        c.gridy++;
        painel.add(botaoExemplo, c);

        return painel;
    }

    private JPanel criarPainelRelatorio() {
        JPanel painel = new JPanel(new BorderLayout());
        painel.setBackground(Color.WHITE);
        painel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 225, 235)),
                new EmptyBorder(15, 15, 15, 15)
        ));

        JLabel tituloRelatorio = new JLabel("Demonstração dos objetos e conceitos de POO");
        tituloRelatorio.setFont(new Font("Segoe UI", Font.BOLD, 16));
        tituloRelatorio.setForeground(new Color(20, 45, 80));

        areaResultado = new JTextArea();
        areaResultado.setEditable(false);
        areaResultado.setFont(new Font("Consolas", Font.PLAIN, 14));
        areaResultado.setForeground(new Color(35, 40, 50));
        areaResultado.setBackground(new Color(250, 251, 253));
        areaResultado.setText("Bem-vindo ao sistema LogAuto.\n\n" +
                "Use o formulário para criar objetos do tipo Carro ou Moto.\n" +
                "Depois gere o transporte para visualizar herança, polimorfismo, encapsulamento e abstração.");

        painel.add(tituloRelatorio, BorderLayout.NORTH);
        painel.add(new JScrollPane(areaResultado), BorderLayout.CENTER);
        return painel;
    }

    private JTextField criarCampo() {
        JTextField campo = new JTextField();
        campo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        campo.setPreferredSize(new Dimension(240, 32));
        return campo;
    }

    private JButton criarBotao(String texto) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Segoe UI", Font.BOLD, 14));
        botao.setBackground(new Color(25, 85, 180));
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        botao.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return botao;
    }

    private JButton criarBotaoSecundario(String texto) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        botao.setBackground(new Color(235, 240, 248));
        botao.setForeground(new Color(20, 45, 80));
        botao.setFocusPainted(false);
        botao.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return botao;
    }

    private void adicionarLinha(JPanel painel, GridBagConstraints c, String label, JComponent componente) {
        JLabel texto = new JLabel(label);
        texto.setFont(new Font("Segoe UI", Font.BOLD, 13));
        texto.setForeground(new Color(60, 70, 85));
        c.gridy++;
        painel.add(texto, c);
        c.gridy++;
        painel.add(componente, c);
    }

    private void adicionarVeiculo() {
        if (campoPlaca.getText().isBlank() || campoModelo.getText().isBlank() || campoCliente.getText().isBlank()
                || campoOrigem.getText().isBlank() || campoDestino.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos antes de adicionar o veículo.");
            return;
        }

        Veiculo veiculo;
        String tipo = (String) comboTipo.getSelectedItem();

        if ("Carro".equals(tipo)) {
            veiculo = new Carro(campoPlaca.getText(), campoModelo.getText(), campoCliente.getText(),
                    campoOrigem.getText(), campoDestino.getText(), 4);
        } else {
            veiculo = new Moto(campoPlaca.getText(), campoModelo.getText(), campoCliente.getText(),
                    campoOrigem.getText(), campoDestino.getText(), 160);
        }

        boolean adicionado = transporteService.adicionarVeiculo(veiculo);
        if (!adicionado) {
            JOptionPane.showMessageDialog(this, "Capacidade máxima da cegonha atingida.");
            return;
        }

        areaResultado.setText("Objeto criado com sucesso:\n\n" + veiculo.resumoBasico()
                + "\nFrete calculado por polimorfismo: R$ " + String.format("%.2f", veiculo.calcularFrete())
                + "\n\nClique em 'Gerar transporte' para visualizar o relatório completo.");
        limparCampos();
    }

    private void gerarTransporte() {
        transporteService.iniciarTransporte();
        areaResultado.setText(transporteService.gerarRelatorio());
    }

    private void carregarExemplo() {
        transporteService.adicionarVeiculo(new Carro("ABC1D23", "Toyota Corolla", "Mariana Souza", "Fortaleza", "São Paulo", 4));
        transporteService.adicionarVeiculo(new Moto("MOT9A87", "Honda CG 160", "Rafael Lima", "Recife", "Salvador", 160));
        transporteService.adicionarVeiculo(new Carro("LOG7B45", "Jeep Compass", "Carla Mendes", "Natal", "Belo Horizonte", 4));
        areaResultado.setText("Exemplos carregados com sucesso.\n\nClique em 'Gerar transporte' para visualizar o polimorfismo no relatório.");
    }

    private void limparCampos() {
        campoPlaca.setText("");
        campoModelo.setText("");
        campoCliente.setText("");
        campoOrigem.setText("");
        campoDestino.setText("");
        campoPlaca.requestFocus();
    }
}
