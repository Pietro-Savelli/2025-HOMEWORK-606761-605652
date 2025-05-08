package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO;

public class ComandoNonValido implements Comando {

	private IO console;
	
	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		console.mostraMessaggio("Il comando utilizzato non esiste, RIPROVA");
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "non valido";
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void setIO(IO io) {
		// TODO Auto-generated method stub
		this.console = io;
	}
}
