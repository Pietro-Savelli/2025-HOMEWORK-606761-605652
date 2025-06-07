package it.uniroma3.diadia.personaggi;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.ComparatoreStanzePerNumeroAttrezzi;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio{
		
	private static final String MESSAGGIO_SPOSTATO = "ti ho spostato nella stanza a mio piacere in base alla tua educazione";

	public Strega(String nome, String presentazione) {
		super(nome, presentazione);
	}

	@Override
	public String agisci(Partita partita) {
		TreeSet<Stanza> stanzePerNumeroAttrezzi = new TreeSet<Stanza>(new ComparatoreStanzePerNumeroAttrezzi());
		for(Direzione direzione : partita.getStanzaCorrente().getDirezioni())
			stanzePerNumeroAttrezzi.add(partita.getStanzaCorrente().getStanzaAdiacente(direzione));
		if(super.haSalutato())
			partita.setStanzaCorrente(stanzePerNumeroAttrezzi.first());
		else
			partita.setStanzaCorrente(stanzePerNumeroAttrezzi.last());
		return MESSAGGIO_SPOSTATO;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		return "ahahahahahah hai perso il tuo oggetto per sempre";
	}

}
