package it.uniroma3.diadia.giocatore;


import it.uniroma3.diadia.attrezzi.Attrezzo;


/**
 * Questa classe crea una borsa per poter conservare gli oggetti raccolti dal giocatore
 *
 * @author  Pietro Savelli
 * @see Giocatore
 * @version v0.0.0
 */


public class Borsa {

	public final static int DEFAULT_PESO_MAX_BORSA = 10;	//Costante che definisce il peso massimo predefinito della borsa
	private Attrezzo[] attrezzi;	//Array per memorizzare gli attrezzi presenti nella borsa
	private int numeroAttrezzi;		//Numero attuale di attrezzi nella borsa
	private int pesoMax;			//Peso massimo che la borsa può contenere			


	/**
	 * Costruttore di default che inizializza la borsa con il peso massimo predefinito.
	 * Chiama il costruttore parametrico con il valore DEFAULT_PESO_MAX_BORSA.
	 */
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}


	/**
	 *Imposta il peso massimo, inizializza l'array di attrezzi e imposta il numero di attrezzi a zero.
	 * 
	 * @param pesoMax il peso massimo consentito per la borsa
	 */
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; // speriamo bastino...
		this.numeroAttrezzi = 0;
	}


	/**
	 * Metodo che aggiuge un attrezzo alla borsa
	 * 
	 * @param attrezzo che si trova nella stanza attuale
	 * @return true se l'oggetto e' stato aggiunto corretamente, altrimenti false
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi==10)
			return false;
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
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
		for (int i= 0; i<this.numeroAttrezzi; i++)
			peso += this.attrezzi[i].getPeso();
		return peso;
	}

	//verifica se la borsa e' vuota
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}


	/**
	 * Restituisce l'attrezzo con il nome specificato se presente nella borsa
	 * 
	 * @param nomeAttrezzo il nome dell'attrezzo da cercare
	 * @return il riferimento all'attrezzo corrispondente se presente, altrimenti null
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
				a = attrezzi[i];
		return a;
	}
	
	

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}


	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		// --->  TODO (implementare questo metodo) <--
		return a;
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
			for (int i= 0; i<this.numeroAttrezzi; i++)
				s.append(attrezzi[i].toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
}
