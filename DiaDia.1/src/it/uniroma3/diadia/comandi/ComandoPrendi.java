package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.IO;

public class ComandoPrendi implements Comando {
	private String parametro;
	private IO console;


	/**
	 * Permette al giocatore di raccogliere un attrezzo dalla stanza corrente e aggiungerlo alla propria borsa,
	 * se presente viene aggiunto, stampata la borsa e rimosso dalla stanza, altrimenti viene stampato un messaggio di avviso
	 * 
	 * @param Partita in corso
	 */

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		if(parametro==null) {	// controllo se il comando sia composto da nome comando(raccogli) e nome oggetto
			console.mostraMessaggio("cosa vuoi prendere");
			return;
		}

		Attrezzo attrezzo = partita.getStanzaCorrente().getAttrezzo(parametro);	// cerco l'attrezzo nella stanza corrente
		if(attrezzo == null) {
			console.mostraMessaggio("l'attrezzo cercato non e' presente nella stanza");
			return;
		}

		if(partita.getGiocatore().addAttrezzo(attrezzo)) {	//aggiungo l'attrezzo nella borsa se ritorna true
			partita.getStanzaCorrente().removeAttrezzo(parametro); 	// rimuovo l'attrezzo dalla stanza
			console.mostraMessaggio("attrezzo aggiunto alla borsa");
		} 
		
		else 
			console.mostraMessaggio("La borsa è piena, non e' possibile aggiungere altri attrezzi.");
		
		console.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
	}

	
	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		this.parametro = parametro;
	}


	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "prendi";
	}


	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return parametro;
	}
	
	@Override
	public void setIO(IO io) {
		// TODO Auto-generated method stub
		this.console = io;
	}
}
