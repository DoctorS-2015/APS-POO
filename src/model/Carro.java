package model;

/**
 * Classe Carro herda de Veiculo.
 * Demonstra HERANÇA e POLIMORFISMO por sobrescrever calcularFrete().
 */
public class Carro extends Veiculo {
    private int quantidadePortas;

    public Carro(String placa, String modelo, String cliente, String origem, String destino, int quantidadePortas) {
        super(placa, modelo, cliente, origem, destino);
        this.quantidadePortas = quantidadePortas;
    }

    public int getQuantidadePortas() {
        return quantidadePortas;
    }

    public void setQuantidadePortas(int quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }

    @Override
    public double calcularFrete() {
        return 1500.00;
    }

    @Override
    public String getTipo() {
        return "Carro";
    }
}
