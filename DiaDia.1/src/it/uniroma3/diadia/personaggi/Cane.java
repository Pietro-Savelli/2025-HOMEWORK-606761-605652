package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio{

	public Cane(String nome, String presentazione) {
		super(nome, presentazione);
	}

	@Override
	public String agisci(Partita partita) {
		return null;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		// TODO Auto-generated method stub
		return null;
	}

}
