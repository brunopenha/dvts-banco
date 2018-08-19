package br.nom.penha.bruno.banco;

import java.util.Collections;
import java.util.List;

import br.nom.penha.bruno.javafx.api.util.Evento;
import br.nom.penha.bruno.banco.modelo.Conta;
import br.nom.penha.bruno.banco.modelo.ContaCorrente;
import br.nom.penha.bruno.banco.modelo.ContaPoupanca;

public class ManipuladorDeContas {

	private Conta conta;

	public void criaConta(Evento evento) {
		String tipo = evento.getSelecionadoNoRadio("tipo");
		this.conta = tipo.equals("Conta Corrente") ? new ContaCorrente() : new ContaPoupanca();
		this.conta.setAgencia(evento.getString("agencia"));
		this.conta.setNumero(evento.getInt("numero"));
		this.conta.setTitular(evento.getString("titular"));
	}

	public void saca(Evento evento) {
		double valor = evento.getDouble("valorOperacao");
		conta.saca(valor);
	}

	public void deposita(Evento evento) {
		double valor = evento.getDouble("valorOperacao");
		conta.deposita(valor);
	}

	public void transfere(Evento evento) {
		Conta destino = (Conta) evento.getSelecionadoNoCombo("destino");
		conta.transfere(evento.getDouble("valorTransferencia"), destino);
	}

	public void salvaDados(Evento evento){
		List<Conta> contas = evento.getLista("listaContas");
		RepositorioDeContas repositorio = new RepositorioDeContas();
		repositorio.salva(contas);
	}
	
	public List<Conta> carregaDados() {
		RepositorioDeContas repositorio = new RepositorioDeContas();
		return repositorio.carrega();
	}
	
	public void ordenaLista(Evento evento) {
		List<Conta> contas = evento.getLista("destino");
		Collections.sort(contas);
	}
}
