package it.uniroma3.diadia;


import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Labirinto
 * @see Stanza
 * @version 0.0.1
 */

public class Partita {

	static final private int CFU_INIZIALI = 20;

	private Stanza stanzaCorrente;
	private boolean finita;
	private int cfu;
	private Labirinto labirinto;
	
	public Partita(){
		creaLabirinto();  
		this.finita = false;
		this.cfu = CFU_INIZIALI;
		this.stanzaCorrente = labirinto.getStanzaIniziale();	// inizializzo la stanza corrente all'ingresso
	}

	
	//PROVA A CREARE IL LABIRITNO NEL MAIN SENZA USARE IL METODO IN QUESTA CLASSE
	//E PASSARE AL COSTRUTTORE PARTITA UN parita(Labirinto labirinto)
	
    /**
     * Crea il labirinto
     */
    private void creaLabirinto() {
    	this.labirinto = new Labirinto();
    }
    
    /**
     * Aggiorna la stanza corrente
     * @param stanzaCorrente stanza in cui ci troviamo in quel momento
     */
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}
	
    /**
     * Restiruisce
     */
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente() == labirinto.getStanzaFinale();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (cfu == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
}
