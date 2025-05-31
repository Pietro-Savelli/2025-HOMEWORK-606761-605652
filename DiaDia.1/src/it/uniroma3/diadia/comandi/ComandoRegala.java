package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoRegala extends AbstractComando{

	public ComandoRegala() {
		super();
	}
	
	public ComandoRegala(String parametro, IO io) {
		super(parametro, io);
	}
	
	@Override
	public void esegui(Partita partita) {
		if(getParametro()==null) {
			getConsole().mostraMessaggio("Cosa vuoi lasciare?\nDevi specificare un' oggetto");
			return;
		}
		Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(getParametro());
		if(attrezzo == null) {
			getConsole().mostraMessaggio("l'attrezzo cercato non e' presente nella borsa");
			return;
		}

		partita.getStanzaCorrente().getPersonaggio().riceviRegalo(attrezzo, partita);
		partita.getGiocatore().removeAttrezzo(getParametro());
	}

	@Override
	public String getNome() {
		return "regala";
	}

}
