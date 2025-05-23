package it.uniroma3.diadia.giocatore;



import java.util.*;

import it.uniroma3.diadia.attrezzi.Attrezzo;


/**
 * Questa classe crea una borsa per poter conservare gli oggetti raccolti dal giocatore
 *
 * @author  Pietro Savelli
 * @see Giocatore
 * @version v.Set
 */


public class Borsa {

	public final static int DEFAULT_PESO_MAX_BORSA = 10;	//Costante che definisce il peso massimo predefinito della borsa
	private int pesoMax;			//Peso massimo che la borsa può contenere
	private Set<Attrezzo> attrezzi;


	/**
	 * Costruttore di default che inizializza la borsa con il peso massimo predefinito.
	 * Chiama il costruttore parametrico con il valore DEFAULT_PESO_MAX_BORSA.
	 */
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}


	/**
	 *Imposta il peso massimo, inizializza l'array di attrezzi e imposta il numero di attrezzi a zero
	 * 
	 * @param pesoMax il peso massimo consentito per la borsa
	 */
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashSet<>();
	}


	/**
	 * Metodo che aggiuge un attrezzo alla borsa
	 * 
	 * @param attrezzo che si trova nella stanza attuale
	 * @return true se l'oggetto e' stato aggiunto corretamente, altrimenti false
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (attrezzo == null) // non funzionava il test perche ammatteva attrezzi null
	        return false;
		
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		
		return attrezzi.add(attrezzo); 
	}

	/**
	 * 
	 * @return pesoMax che la borsa puo' avere
	 */
	public int getPesoMax() {
		return pesoMax;
	}


	/**
	 * Calcola il peso totale degli attrezzi contenuti nella borsa.
	 * 
	 * @return il peso attuale della borsa
	 */
	public int getPeso() {
		int peso = 0;
		for(Attrezzo a : attrezzi) {
			peso += a.getPeso();
		}
		return peso;
	}

	//verifica se la borsa e' vuota
	public boolean isEmpty() {
		return this.getPeso() == 0;
	}

	//verifica se la borsa e' piena
	public boolean isFull() {
		return this.getPeso() == 10;
	}

	/**
	 * Restituisce l'attrezzo con il nome specificato se presente nella borsa
	 * 
	 * @param nomeAttrezzo il nome dell'attrezzo da cercare
	 * @return il riferimento all'attrezzo corrispondente se presente, altrimenti null
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		
	    for (Attrezzo a : attrezzi) {
	        if (nomeAttrezzo.equals(a.getNome())) 
	            return a;
	    }
	    return null;
	}
	
	/**
	 * 
	 * @param nomeAttrezzo
	 * @return true se esiste l'attrezzo cercatro, false altrimenti
	 */

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	/**
	 * 
	 * questa funzione scorre la borsa fino a trovare un attrezzo con il nome indicato,
	 * rimuove quell attrezzo e fa scalare tutti gli altri di 1.
	 * 
	 */
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


	/**
	 * Se la borsa non è vuota, mostra il peso attuale e il peso massimo, insieme ai dettagli degli attrezzi contenuti.
	 * Se la borsa è vuota, indica che non contiene attrezzi.
	 * 
	 * @return una stringa che rappresenta il contenuto della borsa
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (Attrezzo a : attrezzi)
				s.append(a.toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
}
