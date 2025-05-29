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
	public ComandoPrendi() {
		super();
	}
		
	public ComandoPrendi(String parametro, IO io) {
		super(parametro, io);
	}
	
	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		if(getParametro()==null) {	// controllo se il comando sia composto da nome comando(raccogli) e nome oggetto
			getConsole().mostraMessaggio("cosa vuoi prendere");
			return;
		}

		Attrezzo attrezzo = partita.getStanzaCorrente().getAttrezzo(getParametro());	// cerco l'attrezzo nella stanza corrente
		if(attrezzo == null) {
			getConsole().mostraMessaggio("l'attrezzo cercato non e' presente nella stanza");
			return;
		}

		if(partita.getGiocatore().addAttrezzo(attrezzo)) {	//aggiungo l'attrezzo nella borsa se ritorna true
			partita.getStanzaCorrente().removeAttrezzo(getParametro()); 	// rimuovo l'attrezzo dalla stanza
			getConsole().mostraMessaggio("attrezzo aggiunto alla borsa");
		} 
		
		else 
			getConsole().mostraMessaggio("La borsa è piena, non e' possibile aggiungere altri attrezzi.");
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "prendi";
	}
}
