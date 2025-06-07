package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoRegala extends AbstractComando{

	private static final String NOME = "regala";
	
	public ComandoRegala() {
		super.setNome(NOME);
	}
	
	@Override
	public void esegui(Partita partita) {
		if(getParametro()==null) {
			getIO().mostraMessaggio("Cosa vuoi lasciare?\nDevi specificare un' oggetto");
			return;
		}
		Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(getParametro());
		if(attrezzo == null) {
			getIO().mostraMessaggio("l'attrezzo cercato non e' presente nella borsa");
			return;
		}

		partita.getStanzaCorrente().getPersonaggio().riceviRegalo(attrezzo, partita);
		partita.getGiocatore().getBorsa().removeAttrezzo(getParametro());
	}
}
