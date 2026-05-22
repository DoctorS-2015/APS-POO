package model;

/**
 * Classe Moto herda de Veiculo.
 * Possui comportamento diferente de Carro no cálculo do frete.
 */
public class Moto extends Veiculo {
    private int cilindradas;

    public Moto(String placa, String modelo, String cliente, String origem, String destino, int cilindradas) {
        super(placa, modelo, cliente, origem, destino);
        this.cilindradas = cilindradas;
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    @Override
    public double calcularFrete() {
        return 850.00;
    }

    @Override
    public String getTipo() {
        return "Moto";
    }
}
