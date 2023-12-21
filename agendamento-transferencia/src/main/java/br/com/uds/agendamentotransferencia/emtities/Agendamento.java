package br.com.uds.agendamentotransferencia.emtities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Agendamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long idAgendamento;
	
	@Column(name = "CONTA_ORIGEM", nullable = false)
	private Long contaOrigem;
	
	@Column(name = "CONTA_DESTINO", nullable = false)
	private Long contaDestino;
	
	@Column(name = "VALOR_TRANSFERENCIA", nullable = false)
	private double valorTransferencia;
	
	@Column(name = "TAXA", nullable = false)
	private double taxa;
	
	@Column(name = "DATA_TRANSFERENCIA", nullable = false)
	private String dataTransferencia;
	
	@Column(name = "DATA_AGENDAMENTO", nullable = false)
	private String dataAgendamento;
	
	public Long getIdAgendamento() {
		return idAgendamento;
	}
	public void setIdAgendamento(Long idAgendamento) {
		this.idAgendamento = idAgendamento;
	}
	public Long getContaOrigem() {
		return contaOrigem;
	}
	public void setContaOrigem(Long contaOrigem) {
		this.contaOrigem = contaOrigem;
	}
	public Long getContaDestino() {
		return contaDestino;
	}
	public void setContaDestino(Long contaDestino) {
		this.contaDestino = contaDestino;
	}
	public double getValorTransferencia() {
		return valorTransferencia;
	}
	public void setValorTransferencia(double valorTransferencia) {
		this.valorTransferencia = valorTransferencia;
	}
	public double getTaxa() {
		return taxa;
	}
	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}
	public String getDataTransferencia() {
		return dataTransferencia;
	}
	public void setDataTransferencia(String dataTransferencia) {
		this.dataTransferencia = dataTransferencia;
	}
	public String getDataAgendamento() {
		return dataAgendamento;
	}
	public void setDataAgendamento(String dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}
}
