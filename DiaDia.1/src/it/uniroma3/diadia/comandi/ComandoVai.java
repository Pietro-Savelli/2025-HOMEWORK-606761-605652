package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.IO;

public class ComandoVai extends AbstractComando{



	/**
	 * Sposta il giocatore nella direzione specificata, se possibile.
	 * <p>
	 * Se esiste una stanza adiacente nella direzione indicata il giocatore si sposta in quella stanza,
	 * aggiornando la stanza corrente e decrementando il numero di CFU,
	 * se la direzione non è valida o non viene specificata, viene stampato un messaggio di errore.
	 *
	 * @param Partita in corso
	 */
	
	public ComandoVai() {
	    // costruttore vuoto richiesto per riflessione
		super();
	}
	public ComandoVai(String parametro, IO io) {
		super(parametro, io);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		if(getParametro()==null) {
			getConsole().mostraMessaggio("Dove vuoi andare?\nDevi specificare una direzione");
			return;
		}
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(getParametro());
		if(prossimaStanza==null) {
			getConsole().mostraMessaggio("Direzione inesistente");
			return;
		}
		partita.setStanzaCorrente(prossimaStanza);
		getConsole().mostraMessaggio(partita.getStanzaCorrente().getNome());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "vai";
	}
}
