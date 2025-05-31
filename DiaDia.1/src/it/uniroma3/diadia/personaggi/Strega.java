package it.uniroma3.diadia.personaggi;

import java.util.List;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio{
		
	public Strega(String nome, String presentazione) {
		super(nome, presentazione);
	}

	@Override
	public String agisci(Partita partita) {
		
	    List<Stanza> stanze = partita.getStanzaCorrente().getStanzeAdiacenti();
	    Stanza max = null;
		Stanza min = null;
		int M = Integer.MIN_VALUE;
		int m = Integer.MAX_VALUE;
	    
	    if (stanze == null || stanze.isEmpty()) {
	        return "Non ci sono stanze adiacenti dove spostarti!";
	    }
		
		for(Stanza s : stanze) {
			if(s.getAttrezzi().size()> M) {
				max = s;
				M = s.getAttrezzi().size();
			}
				
			if(s.getAttrezzi().size()< m) {
				min = s;
				m = s.getAttrezzi().size();
			}
				
		}
		
		if(this.haSalutato())
			partita.setStanzaCorrente(max);
		else
			partita.setStanzaCorrente(min);
		
		return "ti ho spostato nella stanza a mio piacere in base alla tua educazione";
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		return "ahahahahahah hai perso il tuo oggetto per sempre";
	}

}
