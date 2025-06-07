package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.IO;

public class ComandoPrendi extends AbstractComando {

	/**
	 * Permette al giocatore di raccogliere un attrezzo dalla stanza corrente e aggiungerlo alla propria borsa,
	 * se presente viene aggiunto, stampata la borsa e rimosso dalla stanza, altrimenti viene stampato un messaggio di avviso
	 * 
	 * @param Partita in corso
	 */
	private static final String NOME = "prendi";

	public ComandoPrendi() {
		super.setNome(NOME);
	}
	
	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		if(getParametro()==null) {	// controllo se il comando sia composto da nome comando(raccogli) e nome oggetto
			getIO().mostraMessaggio("cosa vuoi prendere");
			return;
		}

		Attrezzo attrezzo = partita.getStanzaCorrente().getAttrezzo(getParametro());	// cerco l'attrezzo nella stanza corrente
		if(attrezzo == null) {
			getIO().mostraMessaggio("l'attrezzo cercato non e' presente nella stanza");
			return;
		}

		if(partita.getGiocatore().getBorsa().addAttrezzo(attrezzo)) {	//aggiungo l'attrezzo nella borsa se ritorna true
			partita.getStanzaCorrente().removeAttrezzo(attrezzo); 	// rimuovo l'attrezzo dalla stanza
			getIO().mostraMessaggio("attrezzo aggiunto alla borsa");
		} 
		
		else 
			getIO().mostraMessaggio("La borsa è piena, non e' possibile aggiungere altri attrezzi.");
	}
}
