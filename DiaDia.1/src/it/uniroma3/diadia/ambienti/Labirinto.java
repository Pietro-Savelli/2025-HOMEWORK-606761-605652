package it.uniroma3.diadia.ambienti;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Labirinto {

	public static LabirintoBuilder newBuilder() {
		return new LabirintoBuilder();
	}

	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;

	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}

	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}

	public void setStanzaIniziale(Stanza stanzaIniziale) {
		this.stanzaIniziale = stanzaIniziale;
	}

	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}

	public static class LabirintoBuilder {

		private Labirinto labirinto;
		private Stanza ultimaAggiunta;
		private Map<String,Stanza> nome2stanza;

		public LabirintoBuilder() {
			this.labirinto = new Labirinto();
			this.nome2stanza = new HashMap<String, Stanza>();
		}

		public LabirintoBuilder addStanzaIniziale(String nomeStanzaIniziale) {
			Stanza iniziale = new Stanza(nomeStanzaIniziale);
			this.labirinto.setStanzaIniziale(iniziale);
			System.out.println("2");
			System.out.println(iniziale);
			System.out.println(labirinto.getStanzaIniziale());
			this.aggiungiAMappaEAggiornaUltima(iniziale);
			return this;
		}

		public LabirintoBuilder addStanzaVincente(String nomeStanzaVincente) {
			Stanza vincente = new Stanza(nomeStanzaVincente);
			this.labirinto.setStanzaVincente(vincente);
			this.aggiungiAMappaEAggiornaUltima(vincente);
			return this;
		}
		
		public boolean direzioneValida(String direzione) {
		    try {
		        Direzione.valueOf(direzione.toLowerCase()); // solo se enum usa minuscole
		        return true;
		    } catch (IllegalArgumentException e) {
		        return false;
		    }
		}

		public LabirintoBuilder addAdiacenza(String partenza, String adiacente, String direzione) {
			Stanza stanzaPartenza = this.nome2stanza.get(partenza);
			Stanza stanzaAdiacente = this.nome2stanza.get(adiacente);
			if(direzioneValida(direzione)) { 
				stanzaPartenza.impostaStanzaAdiacente(null, stanzaAdiacente);
				return this;}
			if (stanzaPartenza == null || stanzaAdiacente == null) {
				throw new IllegalArgumentException("Stanza non trovata: " + partenza + " o " + adiacente);
			}
			stanzaPartenza.impostaStanzaAdiacente(Direzione.valueOf(direzione.toUpperCase()), stanzaAdiacente);
			return this;
		}

		public LabirintoBuilder addAttrezzo(String nomeStanza, String nome, int peso) {
			Attrezzo a= new Attrezzo(nome, peso);
			this.nome2stanza.get(nomeStanza).addAttrezzo(a);
			return this;
		}

		public LabirintoBuilder addAttrezzo(String nome, int peso) {
			Attrezzo a= new Attrezzo(nome, peso);
			this.ultimaAggiunta.addAttrezzo(a);
			return this;
		}

		public LabirintoBuilder addStanza(String nome) {
			Stanza stanza = new Stanza(nome);
			this.aggiungiAMappaEAggiornaUltima(stanza);
			return this;
		}

		public LabirintoBuilder addStanzaMagica(String nome) {
			Stanza stanza = new StanzaMagica(nome);
			this.aggiungiAMappaEAggiornaUltima(stanza);
			return this;
		}
		
		public LabirintoBuilder addStanzaMagica(String nome, int s) {
			Stanza stanza = new StanzaMagica(nome);
			this.aggiungiAMappaEAggiornaUltima(stanza);
			return this;
		}

		public LabirintoBuilder addStanzaBuia(String nome, String attrezzoPerVedere) {
			Stanza stanza = new StanzaBuia(nome,attrezzoPerVedere);
			this.aggiungiAMappaEAggiornaUltima(stanza);
			return this;
		}

		public LabirintoBuilder addStanzaBloccata(String nome, String attrezzoSbloccante, Direzione direzioneBloccata) {
			Stanza stanza = new StanzaBloccata(nome, attrezzoSbloccante, direzioneBloccata);
			this.aggiungiAMappaEAggiornaUltima(stanza);
			return this;
		}

		public Labirinto getLabirinto() {
			return this.labirinto;
		}

		private void aggiungiAMappaEAggiornaUltima(Stanza stanza) {
			this.ultimaAggiunta = stanza;
			this.nome2stanza.put(stanza.getNome(), stanza);
		}

		public Map<String,Stanza> getListaStanze() {
			return nome2stanza;
		}
	}
}