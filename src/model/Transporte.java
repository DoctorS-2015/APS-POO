package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma operação de transporte da LogAuto.
 * Demonstra interação entre objetos: Transporte possui CaminhaoCegonha e vários Veiculos.
 */
public class Transporte {
    private int numero;
    private String status;
    private CaminhaoCegonha caminhao;
    private List<Veiculo> veiculos;

    public Transporte(int numero, CaminhaoCegonha caminhao) {
        this.numero = numero;
        this.caminhao = caminhao;
        this.status = "Em preparação";
        this.veiculos = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CaminhaoCegonha getCaminhao() {
        return caminhao;
    }

    public void setCaminhao(CaminhaoCegonha caminhao) {
        this.caminhao = caminhao;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        if (veiculos.size() < caminhao.getCapacidadeMaxima()) {
            veiculos.add(veiculo);
        }
    }

    public double calcularValorTotal() {
        double total = 0;
        for (Veiculo veiculo : veiculos) {
            total += veiculo.calcularFrete();
        }
        return total;
    }
}
