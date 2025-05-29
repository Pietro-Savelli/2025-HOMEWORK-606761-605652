package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;

import it.uniroma3.diadia.Partita;

public class ComandoFine extends AbstractComando {
	

	public ComandoFine() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ComandoFine(String parametro, IO io) {
		super(parametro, io);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		getConsole().mostraMessaggio("Grazie di aver giocato!"); 
		partita.setFinita();
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "fine";
	}
}
