package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
	private String parametro;
	private IOConsole io = new IOConsole();


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
			io.mostraMessaggio("cosa vuoi prendere");
			return;
		}

		Attrezzo attrezzo = partita.getStanzaCorrente().getAttrezzo(parametro);	// cerco l'attrezzo nella stanza corrente
		if(attrezzo == null) {
			io.mostraMessaggio("l'attrezzo cercato non e' presente nella stanza");
			return;
		}

		if(partita.getGiocatore().addAttrezzo(attrezzo)) {	//aggiungo l'attrezzo nella borsa se ritorna true
			partita.getStanzaCorrente().removeAttrezzo(parametro); 	// rimuovo l'attrezzo dalla stanza
			io.mostraMessaggio("attrezzo aggiunto alla borsa");
		} 
		
		else 
			io.mostraMessaggio("La borsa è piena, non e' possibile aggiungere altri attrezzi.");
		
		io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
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

}
