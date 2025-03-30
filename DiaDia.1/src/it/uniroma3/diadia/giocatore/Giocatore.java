package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Questa classe si occupa di creare un giocatore e gestire i cfu e la borsa a disposizione
 *
 * @author  Pietro Savelli
 * @see Borsa
 * @see Partita
 * @version v0.0.0
 */

public class Giocatore {
	
	static final private int CFU_INIZIALI = 20;
	
	private int cfu;
	private Borsa borsa;
	
	// cotruttore base
	public Giocatore() {
		this(CFU_INIZIALI);	
	}
	
	/**
	 * cotruttore giocatore
	 * 
	 * @param cfu_iniziali che sono una variabile fissa
	 */
	public Giocatore(int cfu_iniziali) {
		this.cfu = cfu_iniziali;
		borsa = new Borsa();
	}
	
	/**
	 * 
	 * @return numero cfu attuali
	 */
	public int getCfu() {
		return cfu;
	}
	
	/** 
	 * 	aggiornato ad ogni spostamento
	 * @param cfu rimasti (attuali-1)
	 */
	public void setCfu(int cfu) {
		this.cfu = cfu;	
	}
	
	/**
	 * Restituisce la borsa del giocatore
	 * @return borsa del giocatore
	 */
	public Borsa getBorsa() {
		return this.borsa;
	}
	
    /**
     * Tenta di aggiungere un attrezzo alla borsa del giocatore.
     *
     * @param attrezzo l'attrezzo da aggiungere alla borsa
     * @return  true se l'attrezzo è stato aggiunto con successo, false altrimenti
     */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		return this.borsa.addAttrezzo(attrezzo);
	}
	
	/**
	 * Rimuove un attrezzo dalla borsa del giocatore
	 * @param nomeAttrezzo il nome dell'attrezzo da rimuovere
	 * @return l'attrezzo rimosso, o null se non presente
	 */
	public boolean removeAttrezzo(String nomeAttrezzo) {
		return this.borsa.removeAttrezzo(nomeAttrezzo);
	}
	
	/**
	 * Controlla se un attrezzo è presente nella borsa
	 * @param nomeAttrezzo il nome dell'attrezzo da cercare
	 * @return true se l'attrezzo è presente, false altrimenti
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.borsa.hasAttrezzo(nomeAttrezzo);
	}
	
}

