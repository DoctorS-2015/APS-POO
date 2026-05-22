package service;

import model.CaminhaoCegonha;
import model.Transporte;
import model.Veiculo;

/**
 * Camada de serviço responsável por regras simples do sistema.
 * Ajuda a manter a interface separada da lógica principal.
 */
public class TransporteService {
    private Transporte transporteAtual;

    public TransporteService() {
        CaminhaoCegonha caminhao = new CaminhaoCegonha("LOG-2026", "Carlos Andrade", 6);
        this.transporteAtual = new Transporte(1001, caminhao);
    }

    public Transporte getTransporteAtual() {
        return transporteAtual;
    }

    public boolean adicionarVeiculo(Veiculo veiculo) {
        if (transporteAtual.getVeiculos().size() >= transporteAtual.getCaminhao().getCapacidadeMaxima()) {
            return false;
        }
        transporteAtual.adicionarVeiculo(veiculo);
        return true;
    }

    public void iniciarTransporte() {
        if (transporteAtual.getVeiculos().isEmpty()) {
            transporteAtual.setStatus("Aguardando veículos");
        } else {
            transporteAtual.setStatus("Transporte iniciado");
        }
    }

    public String gerarRelatorio() {
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("==== RELATÓRIO LOGAUTO ====\n");
        relatorio.append("Transporte Nº: ").append(transporteAtual.getNumero()).append("\n");
        relatorio.append("Status: ").append(transporteAtual.getStatus()).append("\n");
        relatorio.append(transporteAtual.getCaminhao().dadosCaminhao()).append("\n\n");
        relatorio.append("Veículos cadastrados:\n");

        if (transporteAtual.getVeiculos().isEmpty()) {
            relatorio.append("Nenhum veículo cadastrado.\n");
        } else {
            for (Veiculo veiculo : transporteAtual.getVeiculos()) {
                relatorio.append("- ").append(veiculo.resumoBasico())
                        .append(" | Origem: ").append(veiculo.getOrigem())
                        .append(" | Destino: ").append(veiculo.getDestino())
                        .append(" | Frete: R$ ").append(String.format("%.2f", veiculo.calcularFrete()))
                        .append("\n");
            }
        }

        relatorio.append("\nValor total: R$ ").append(String.format("%.2f", transporteAtual.calcularValorTotal()));
        return relatorio.toString();
    }
}
