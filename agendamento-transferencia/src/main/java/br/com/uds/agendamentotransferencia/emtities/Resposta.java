package br.com.uds.agendamentotransferencia.emtities;

import org.springframework.stereotype.Component;

@Component
public class Resposta {

	private String mensagem;

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
