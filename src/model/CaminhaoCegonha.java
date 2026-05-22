package model;

/**
 * Representa o caminhão cegonha utilizado pela transportadora.
 * Demonstra ENCAPSULAMENTO por proteger seus atributos com private.
 */
public class CaminhaoCegonha {
    private String codigo;
    private String motorista;
    private int capacidadeMaxima;

    public CaminhaoCegonha(String codigo, String motorista, int capacidadeMaxima) {
        this.codigo = codigo;
        this.motorista = motorista;
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMotorista() {
        return motorista;
    }

    public void setMotorista(String motorista) {
        this.motorista = motorista;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public String dadosCaminhao() {
        return "Cegonha " + codigo + " | Motorista: " + motorista + " | Capacidade: " + capacidadeMaxima + " veículos";
    }
}
