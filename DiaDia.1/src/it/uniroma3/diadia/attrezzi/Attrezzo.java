package it.uniroma3.diadia.attrezzi;


import it.uniroma3.diadia.ambienti.Stanza;

/**
 * Una semplice classe che modella un attrezzo.
 * Gli attrezzi possono trovarsi all'interno delle stanze
 * del labirinto.
 * Ogni attrezzo ha un nome ed un peso.
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */
public class Attrezzo implements Comparable<Attrezzo>{

	private String nome;
	private int peso;

	/**
	 * Crea un attrezzo
	 * @param nome il nome che identifica l'attrezzo
	 * @param peso il peso dell'attrezzo
	 */
	public Attrezzo(String nome, int peso) {
		this.peso = peso;
		this.nome = nome;
	}

	/**
	 * Restituisce il nome identificatore dell'attrezzo
	 * @return il nome identificatore dell'attrezzo
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce il peso dell'attrezzo
	 * @return il peso dell'attrezzo
	 */
	public int getPeso() {
		return this.peso;
	}
	
	/**
	 * Restituisce una rappresentazione stringa di questo attrezzo
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		return this.getNome()+" ("+this.getPeso()+"kg)";
	}
	
	/** 
	 * Restituisce le caratteristiche dell'attrezzo nome, peso
	 * @return la descrizione dell'attrezzo
	 */
	public String getDescrizioneAttrezzo() {
        return this.toString();
    }
	
	
	@Override
	public int hashCode() {
		return this.getNome().hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if(o==null || this.getClass()!=o.getClass())
			return false;
		Attrezzo that = (Attrezzo)o;
		return this.getNome().equals(that.getNome()); // perche' abbiamo preso per vero che non possono esistere piu' attrezzi con lo stesso nome, quindi il peso e' un controllo in piu'
		
	}

	public int compareTo(Attrezzo a2) {
		return this.getNome().compareTo(a2.getNome());
	}
	
	
}