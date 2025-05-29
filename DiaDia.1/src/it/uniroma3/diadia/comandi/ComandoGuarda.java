package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando {
	
	public ComandoGuarda() {
		super();
	}
	
	public ComandoGuarda(String parametro, IO io) {
		super(parametro, io);
	}
	
	// stampa le informazioni sulla stanza corrente e sullo stato della partita
	@Override
	public void esegui(Partita partita) {
		getConsole().mostraMessaggio(partita.toString());
	}

	@Override
	public String getNome() {
		return "guarda";
	}
}
