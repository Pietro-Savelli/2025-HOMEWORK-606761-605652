package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio{
	
	Attrezzo attrezzo;
	public Cane(String nome, String presentazione) {
		super(nome, presentazione);
	}

	public Cane(String nome, String presentazione, Attrezzo attrezzo) {
		super(nome, presentazione);
		this.attrezzo = attrezzo;
	}
	
	@Override
	public String agisci(Partita partita) {
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu() - 1);
	    return "TI HO MORSO";
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		
	    if (attrezzo.getNome().equals("osso")) {
	        partita.getStanzaCorrente().addAttrezzo(this.attrezzo);
	        return "BAU BAU";
	    }
	    this.agisci(partita);
	    return "BAU BAU";
	}


}
