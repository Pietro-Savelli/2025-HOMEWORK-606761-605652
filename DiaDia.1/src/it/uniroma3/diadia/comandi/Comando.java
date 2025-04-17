package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public interface Comando {
	/**
	 * esecuzione del comando, rendendolo astratto
	 * @param partita
	 */
	public void esegui(Partita partita);
	
	/**
	 * set parametro del comando
	 * @param parametro
	 */
	 public void setParametro(String parametro);
}
