package br.nom.penha.bruno.banco;

import br.nom.penha.bruno.javafx.api.util.Evento;
import br.nom.penha.bruno.banco.modelo.Tributavel;

public class ManipuladorDeTributaveis {
	
	private double total;
	
	public void calculaImpostos(Evento evento){
		total = 0;
		for (int i = 0; i < evento.getTamanhoDaLista("listaTributaveis"); i++) {
			Tributavel t = evento.getTributavel("listaTributaveis", i);
			total += t.getValorImposto();
		}
	}
	
	public double getTotal() {
		return total;
	}
}
