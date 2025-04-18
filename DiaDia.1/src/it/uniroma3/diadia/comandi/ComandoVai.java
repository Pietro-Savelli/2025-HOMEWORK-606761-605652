package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando{
	
	private String direzione;
	private IOConsole io = new IOConsole ();
	
	/**
	 * Sposta il giocatore nella direzione specificata, se possibile.
	 * <p>
	 * Se esiste una stanza adiacente nella direzione indicata il giocatore si sposta in quella stanza,
	 * aggiornando la stanza corrente e decrementando il numero di CFU,
	 * se la direzione non è valida o non viene specificata, viene stampato un messaggio di errore.
	 *
	 * @param Partita in corso
	 */
	
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		if(direzione==null) {
			io.mostraMessaggio("Dove vuoi andare?\nDevi specificare una direzione");
			return;
		}
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(direzione);
		if(prossimaStanza==null) {
			io.mostraMessaggio("Direzione inesistente");
			return;
		}
		partita.setStanzaCorrente(prossimaStanza);
		io.mostraMessaggio(partita.getStanzaCorrente().getNome());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
	}
	
	// uso un metodo sovracarico per poter settare i parametri di un qualsiasi comando
	@Override
	public void setParametro(String parametro) {
		direzione = parametro;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "vai";
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return direzione;
	}
}
