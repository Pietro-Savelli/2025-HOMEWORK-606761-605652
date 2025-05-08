package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
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

	 /* metodi per i test */
	 public String getNome();
	 public String getParametro();
	 
	 /* per esercizio 9 hw2*/
	 public void setIO(IO io);
}
