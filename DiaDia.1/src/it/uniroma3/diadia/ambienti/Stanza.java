package it.uniroma3.diadia.ambienti;


import java.util.*;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version map e set
 */


public class Stanza {

	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	static final private int NUMERO_MASSIMO_ATTREZZI = 10;
	private String nome;
	private Map<String, Stanza> stanzeAdiacenti;
	private Set<Attrezzo> attrezzi;

	public Stanza(String nome) {
		this.nome = nome;
		this.stanzeAdiacenti = new HashMap<>();
		this.attrezzi = new HashSet<>();
	}

	public String getNome() {
		return nome;
	}

	public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
		this.stanzeAdiacenti.put(direzione, stanza);
	}

	public Stanza getStanzaAdiacente(String direzione) {
		return this.stanzeAdiacenti.get(direzione);
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		return attrezzi.size()<NUMERO_MASSIMO_ATTREZZI && attrezzi.add(attrezzo);
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		for(Attrezzo a : attrezzi) {
			if(a.getNome().equals(nomeAttrezzo))
				return true;
		}
		return false;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		for (Attrezzo a : this.attrezzi)
			if (a.getNome().equals(nomeAttrezzo))
				return a;
		return null;
	}

	public boolean removeAttrezzo(String nomeAttrezzo) {
		if (nomeAttrezzo == null) return false; // per gestire la stringa null(anche prima funzionava ma ora è più chiaro)
		Iterator<Attrezzo> i = attrezzi.iterator();

		while(i.hasNext()) {
			Attrezzo a = i.next();
			if(a.getNome().equals(nomeAttrezzo)) {
				i.remove();
				return true;
			}	
		}
		return false; // Se l'attrezzo non è presente
	}

	public Set<Attrezzo> getAttrezzi() {
		return new HashSet<>(this.attrezzi); // crea una nuovo set che e' una copia del parametro (usa il costuttore sovracacrico)
	}

	public Set<String> getDirezioni() {
		return new HashSet<>(this.stanzeAdiacenti.keySet()); // crea una nuovo set che e' una copia del parametro (usa il costuttore sovracacrico)
	}

	/**
	 * Restituisce la descrizione della stanza.
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

	/**
	 * Restituisce una rappresentazione stringa di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return la rappresentazione stringa
	 */
	@Override
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.nome);
		risultato.append("\nUscite: ");
		
		for(String s : getDirezioni()){
			if(s!=null)
				risultato.append(" "+s);
		}
		
		risultato.append("\nAttrezzi nella stanza: ");
		for(Attrezzo a : attrezzi) {
			if(a!=null)
				risultato.append(" "+a.getDescrizioneAttrezzo());
		}
		return risultato.toString();
	}


}
