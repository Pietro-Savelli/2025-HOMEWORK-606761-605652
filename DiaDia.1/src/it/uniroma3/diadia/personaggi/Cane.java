package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio{
	
	Attrezzo attrezzo;
	String ciboPreferito = "osso";
	public Cane(String nome, String presentazione) {
		super(nome, presentazione);
	}

	public Cane(String nome, String presentazione, Attrezzo attrezzo) {
		super(nome, presentazione);
		this.attrezzo = attrezzo;
	}
	
	public Cane(String cane, String presentazione, String attrezzo, int peso, String ciboPreferito) {
		super(cane, presentazione);
		this.attrezzo = new Attrezzo(attrezzo, peso);
		this.ciboPreferito = ciboPreferito;
	}

	@Override
	public String agisci(Partita partita) {
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu() - 1);
	    return "TI HO MORSO";
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		
	    if (attrezzo.getNome().equals(ciboPreferito)) {
	        partita.getStanzaCorrente().addAttrezzo(this.attrezzo);
	        return "BAU BAU";
	    }
	    this.agisci(partita);
	    return "BAU BAU";
	}


}
