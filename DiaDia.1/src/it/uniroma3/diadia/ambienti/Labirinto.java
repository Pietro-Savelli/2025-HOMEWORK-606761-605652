package it.uniroma3.diadia.ambienti;


import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
* Questa classe crea un labirinto, memorizza la stanza iniziale(entrata) e finale(uscita)
*
* @author  Pietro Savelli
* @see Partita
* @version v0.0.0
*/

public class Labirinto {
	
	// variabili di istanza Stanza
	private Stanza stanzaIniziale;
	private Stanza stanzaFinale;
	private Stanza atrio;
	private Stanza aulaN11; 
	private Stanza aulaN10;
	private Stanza laboratorio; 
	private Stanza biblioteca;
	// variabili di istanza Attrezzo
	private Attrezzo lanterna;
	private Attrezzo osso;
	
	// Costruttore che attraverso la chiamata init() inizializza il Labirinto
	public Labirinto() {
		init();
	}
	
	private void init() {
		creaStanze();
		collegaStanze();
		creaAttrezzi();
		posizionaAttrezzi();
	}
	
	
	/**
	 * Crea le stanze del labirinto, e memorizza l'ingresso e uscita 
	 */
	private void creaStanze() {
		
		atrio = new Stanza("Atrio");
		aulaN11 = new Stanza("Aula N11");
		aulaN10 = new Stanza("Aula N10");
		laboratorio = new Stanza("Laboratorio Campus");
		biblioteca = new Stanza("Biblioteca");
		
		// assegno la stanza iniziale e finale
		stanzaIniziale = atrio;
        stanzaFinale = biblioteca;
	}
	
	
	/**
	 * crea le porte di collegamento
	 */
	private void collegaStanze() {
		
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);
	}
	
	/**
	 *  crea gli attrezzi
	 */
	private void creaAttrezzi() {
		this.lanterna = new Attrezzo("lanterna",3);
		this.osso = new Attrezzo("osso",1);
	}
	
	
	/**
	 * pone gli attrezzi nelle stanze
	 */
	private void posizionaAttrezzi() {
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
	}
	
	
	public Stanza getStanzaIniziale() {
		return stanzaIniziale;
	}
	
	public Stanza getStanzaFinale() {
		return stanzaFinale;
	}
	
}
