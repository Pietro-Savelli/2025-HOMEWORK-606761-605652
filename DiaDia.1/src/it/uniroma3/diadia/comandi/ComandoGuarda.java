package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {
	
	private IO console;
	
	// stampa le informazioni sulla stanza corrente e sullo stato della partita
	@Override
	public void esegui(Partita partita) {
		console.mostraMessaggio(partita.toString());
	}

	@Override
	public void setParametro(String parametro) {
	}

	@Override
	public String getNome() {
		return "guarda";
	}

	@Override
	public String getParametro() {
		return null;
	}

	@Override
	public void setIO(IO io) {
		this.console = io;
	}

}
