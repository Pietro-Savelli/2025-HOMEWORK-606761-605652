package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando {
	
	public ComandoAiuto() {
		super();
	}
	
	public ComandoAiuto(String parametro, IO io) {
		super(parametro, io);
	}

	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "guarda"};
	
	/**
	 * Stampa informazioni di aiuto.
	 */
	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		for(int i=0; i< elencoComandi.length; i++) 
			getConsole().mostraMessaggio(elencoComandi[i]+" ");
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "aiuto";
	}
}
