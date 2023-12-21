package br.com.uds.agendamentotransferencia.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.uds.agendamentotransferencia.emtities.Agendamento;
import br.com.uds.agendamentotransferencia.emtities.Resposta;
import br.com.uds.agendamentotransferencia.repotories.AgendamentoRepository;

@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	@Autowired
	private Resposta resposta;
	
	public List<Agendamento> listarAgendamentos() {
		return agendamentoRepository.findAll();
	}
	
	public ResponseEntity<?> salvarAgendamento(Agendamento agendamento) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//capturando data atual e formatando
		Date dataAtual = new Date();
		String dataAgendamento = sdf.format(dataAtual);
		agendamento.setDataAgendamento(dataAgendamento);
		
		//calculando taxa
	    Date dataRecebida = sdf.parse(agendamento.getDataTransferencia());
	    Date dataAtualParse = sdf.parse(dataAgendamento);
	    
	    long difEmMil = Math.abs(dataRecebida.getTime() - dataAtualParse.getTime());
	    long dif = TimeUnit.DAYS.convert(difEmMil, TimeUnit.MILLISECONDS);
	    if (dif == 0) {
			agendamento.setTaxa(2.5);
		} else if (dif > 0 && dif < 11) {
			agendamento.setTaxa(0.0);
		} else if (dif > 10 && dif < 21) {
			agendamento.setTaxa(8.2);
		} else if (dif > 20 && dif < 31) {
			agendamento.setTaxa(6.9);
		} else if (dif > 30 && dif < 41) {
			agendamento.setTaxa(4.7);
		} else if (dif > 41 && dif < 51) {
			agendamento.setTaxa(1.7);
		} else {
			resposta.setMensagem("Data Limite Excedida");
			return new ResponseEntity<Resposta>(resposta, HttpStatus.BAD_REQUEST);
		}
	    resposta.setMensagem("Agendamento Cadastrado com Sucesso!");
		return new ResponseEntity<Agendamento>(agendamentoRepository.save(agendamento), HttpStatus.CREATED);
	}
}
