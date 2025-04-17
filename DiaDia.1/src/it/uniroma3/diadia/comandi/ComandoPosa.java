package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {
	private IOConsole io = new IOConsole ();
	private String parametro;
	
	/**
	 * Permette al giocatore di lasciare un attrezzo dalla borsa e aggiungerlo alla stanza corrente,
	 * se presente viene lasciato, stampata la stanza con il nuovo oggeto e rimosso dalla borsa,
	 *  altrimenti viene stampato un messaggio di avviso
	 * 
	 * @param Partita in corso
	 */
	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		if(parametro==null) {// controllo se il comando sia composto da nome comando(raccogli) e nome oggetto
			io.mostraMessaggio("cosa vuoi lasciare/nDevi specificare un' oggetto");
			return;
		}
		Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(parametro);
		if(attrezzo == null) {
			io.mostraMessaggio("l'attrezzo cercato non e' presente nella borsa");
			return;
		}

		if(partita.getStanzaCorrente().addAttrezzo(attrezzo)) {	// aggiunge l'attrezzo dalla stanza
			io.mostraMessaggio("attrezzo aggiunto alla stanza");
			partita.getGiocatore().removeAttrezzo(parametro);
		}
		else
			io.mostraMessaggio("la stanza e' piena, l'attrezzo non puo' essere aggiunto");

		io.mostraMessaggio(partita.getStanzaCorrente().toString());
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		this.parametro = parametro;
	}

}
