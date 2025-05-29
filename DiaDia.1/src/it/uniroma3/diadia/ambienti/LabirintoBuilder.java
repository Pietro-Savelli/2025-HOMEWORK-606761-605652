package it.uniroma3.diadia.ambienti;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder {

    private Labirinto labirinto;
    private Map<String, Stanza> listaStanze;
    private Stanza ultimaStanzaAggiunta;
    private final static List<String> direzioni = Arrays.asList("nord", "sud", "est", "ovest");

    public LabirintoBuilder() {
        this.labirinto = new Labirinto();
        this.listaStanze = new HashMap<>();
    }

    public LabirintoBuilder addStanzaIniziale(String nome) {
        Stanza stanza = new Stanza(nome);
        this.labirinto.setStanzaIniziale(stanza);
        this.listaStanze.put(nome, stanza);
        this.ultimaStanzaAggiunta = stanza;
        return this;
    }

    public LabirintoBuilder addStanzaVincente(String nome) {
        Stanza stanza = new Stanza(nome);
        this.labirinto.setStanzaFinale(stanza);
        this.listaStanze.put(nome, stanza);
        this.ultimaStanzaAggiunta = stanza;
        return this;
    }

    public LabirintoBuilder addStanza(String nome) {
        Stanza stanza = new Stanza(nome);
        this.listaStanze.put(nome, stanza);
        this.ultimaStanzaAggiunta = stanza;
        return this;
    }

    public LabirintoBuilder addStanzaMagica(String nome, int sogliaMagica) {
        StanzaMagica stanza = new StanzaMagica(nome, sogliaMagica);
        this.listaStanze.put(nome, stanza);
        this.ultimaStanzaAggiunta = stanza;
        return this;
    }

    public LabirintoBuilder addStanzaBloccata(String nome, String direzioneBloccata, String attrezzoSbloccante) {
        StanzaBloccata stanza = new StanzaBloccata(nome, direzioneBloccata, attrezzoSbloccante);
        this.listaStanze.put(nome, stanza);
        this.ultimaStanzaAggiunta = stanza;
        return this;
    }

    public LabirintoBuilder addAttrezzo(String nomeAttrezzo, int peso) {
        if (this.ultimaStanzaAggiunta != null) {
            Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
            this.ultimaStanzaAggiunta.addAttrezzo(attrezzo);
        }
        return this;
    }

    public LabirintoBuilder addAdiacenza(String nomeStanzaDa, String nomeStanzaA, String direzione) {
    	if (nomeStanzaA == null || nomeStanzaDa == null || !direzioni.contains(direzione)) {
            return this;
        }
        Stanza stanzaDa = this.listaStanze.get(nomeStanzaDa);
        Stanza stanzaA = this.listaStanze.get(nomeStanzaA);
        if (stanzaDa != null && stanzaA != null ) {
            stanzaDa.impostaStanzaAdiacente(direzione, stanzaA);
        }
        return this;
    }
    
	public LabirintoBuilder addStanzaBuia(String attrezzo, String nome) {
	      StanzaBuia stanza = new StanzaBuia(attrezzo, nome);
	        this.listaStanze.put(nome, stanza);
	        this.ultimaStanzaAggiunta = stanza;
	        return this;
	}
	
    public Labirinto getLabirinto() {
        return this.labirinto;
    }

    public Map<String, Stanza> getListaStanze() {
        return this.listaStanze;
    }


}
