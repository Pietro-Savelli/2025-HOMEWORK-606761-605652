package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO;

public class ComandoNonValido extends AbstractComando {

	public ComandoNonValido() {
	    // costruttore vuoto richiesto per riflessione
		super();
	}
	
	public ComandoNonValido(String parametro, IO io) {
		super(parametro, io);
	}
	
	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		getConsole().mostraMessaggio("Il comando utilizzato non esiste, RIPROVA");
	}
	
	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "non valido";
	}
}
