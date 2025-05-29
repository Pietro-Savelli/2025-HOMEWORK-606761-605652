package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.IO;

public class ComandoPosa extends AbstractComando {
	
	/**
	 * Permette al giocatore di lasciare un attrezzo dalla borsa e aggiungerlo alla stanza corrente,
	 * se presente viene lasciato, stampata la stanza con il nuovo oggeto e rimosso dalla borsa,
	 *  altrimenti viene stampato un messaggio di avviso
	 * 
	 * @param Partita in corso
	 */
	public ComandoPosa() {
		super();
	}
	
	public ComandoPosa(String parametro, IO io) {
		super(parametro, io);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		if(getParametro()==null) {// controllo se il comando sia composto da nome comando(raccogli) e nome oggetto
			getConsole().mostraMessaggio("Cosa vuoi lasciare?\nDevi specificare un' oggetto");
			return;
		}
		Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(getParametro());
		if(attrezzo == null) {
			getConsole().mostraMessaggio("l'attrezzo cercato non e' presente nella borsa");
			return;
		}

		if(partita.getStanzaCorrente().addAttrezzo(attrezzo)) {	// aggiunge l'attrezzo dalla stanza
			getConsole().mostraMessaggio("attrezzo aggiunto alla stanza");
			partita.getGiocatore().removeAttrezzo(getParametro());
		}
		else
			getConsole().mostraMessaggio("la stanza e' piena, l'attrezzo non puo' essere aggiunto");

	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "posa";
	}

}
