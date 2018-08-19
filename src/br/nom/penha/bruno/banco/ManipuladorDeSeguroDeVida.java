package br.nom.penha.bruno.banco;

import br.nom.penha.bruno.javafx.api.util.Evento;
import br.nom.penha.bruno.banco.modelo.SeguroDeVida;

public class ManipuladorDeSeguroDeVida {

	private SeguroDeVida seguroDeVida;
	
	public void criaSeguro(Evento evento){
		this.seguroDeVida = new SeguroDeVida();
		this.seguroDeVida.setNumeroApolice(evento.getInt("numeroApolice"));
		this.seguroDeVida.setTitular(evento.getString("titular"));
		this.seguroDeVida.setValor(evento.getDouble("valor"));
	}
}
