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
	private Map<String,Attrezzo> attrezzi;

	public Stanza(String nome) {
		this.nome = nome;
		this.stanzeAdiacenti = new HashMap<>();
		this.attrezzi =  new HashMap<>();
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
		if(attrezzi.size()<NUMERO_MASSIMO_ATTREZZI) {
			attrezzi.put(attrezzo.getNome(), attrezzo);
			return true; 
		}
			
		return false;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
	    return this.attrezzi.containsKey(nomeAttrezzo);
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}

	public boolean removeAttrezzo(String nomeAttrezzo) {
		if (nomeAttrezzo == null) 
			return false; // per gestire la stringa null
		
		return this.attrezzi.remove(nomeAttrezzo)!=null;
	}

	public List<Attrezzo> getAttrezzi() {
		return new ArrayList<Attrezzo>(this.attrezzi.values()); // crea una nuovo set che raccolgie tutti i valori dei valori della mappa
	}

	public Set<String> getDirezioni() {
		return new HashSet<>(this.stanzeAdiacenti.keySet()); // crea una nuovo set che e' una copia del parametro (usa il costuttore sovracacrico)
	}
	
	public Map<String,Stanza> getMapStanzeAdiacenti() {
		return this.stanzeAdiacenti;
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
		for(Attrezzo a : getAttrezzi()) {
			if(a!=null)
				risultato.append(" "+a.getDescrizioneAttrezzo());
		}
		return risultato.toString();
	}




}
