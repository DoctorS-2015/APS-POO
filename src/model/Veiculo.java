package model;

/**
 * Classe abstrata que representa o conceito geral de um veículo.
 * Demonstra ABSTRAÇÃO: não criamos um Veiculo genérico, apenas especializações.
 */
public abstract class Veiculo {
    private String placa;
    private String modelo;
    private String cliente;
    private String origem;
    private String destino;

    public Veiculo(String placa, String modelo, String cliente, String origem, String destino) {
        this.placa = placa;
        this.modelo = modelo;
        this.cliente = cliente;
        this.origem = origem;
        this.destino = destino;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * Método abstrato sobrescrito pelas subclasses.
     * Demonstra POLIMORFISMO quando chamado por uma referência do tipo Veiculo.
     */
    public abstract double calcularFrete();

    public abstract String getTipo();

    public String resumoBasico() {
        return getTipo() + " | Placa: " + placa + " | Modelo: " + modelo + " | Cliente: " + cliente;
    }
}
