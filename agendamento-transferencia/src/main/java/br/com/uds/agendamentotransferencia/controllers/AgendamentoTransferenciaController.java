package br.com.uds.agendamentotransferencia.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.uds.agendamentotransferencia.emtities.Agendamento;
import br.com.uds.agendamentotransferencia.services.AgendamentoService;

@RestController
@RequestMapping("/agendamentosTransferencias")
public class AgendamentoTransferenciaController {
	
	@Autowired
	AgendamentoService agendamentoService;
	
	@GetMapping
	@CrossOrigin
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping("/consultaAgendamentos")
	public List<Agendamento> consultarAgendamentos() {
		return agendamentoService.listarAgendamentos();
	}
	
	@PostMapping
	@CrossOrigin
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping("/agendarTransferencia")
	public ResponseEntity<?> agendarTransferencia(@RequestBody Agendamento agendamento) throws ParseException {
		return agendamentoService.salvarAgendamento(agendamento);
	}
}
