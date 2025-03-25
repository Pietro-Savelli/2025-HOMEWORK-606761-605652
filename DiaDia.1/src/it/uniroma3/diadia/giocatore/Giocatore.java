package it.uniroma3.diadia.giocatore;


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
	
	public Giocatore() {
		this(CFU_INIZIALI);	
	}
	
	public Giocatore(int cfu_iniziali) {
		this.cfu = cfu_iniziali;
		borsa = new Borsa();
	}

	public int getCfu() {
		return cfu;
	}
	
	/** 
	 * ogni volta che il Giocatore cambia stanza perde un cfu
	 * @param cfu nuovo numero di cfu rimasti
	 */
	public void setCfu(int cfu) {
		this.cfu = cfu;	
	}
}
