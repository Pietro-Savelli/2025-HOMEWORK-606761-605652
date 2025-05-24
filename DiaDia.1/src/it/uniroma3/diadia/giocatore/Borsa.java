package it.uniroma3.diadia.giocatore;



import java.rmi.StubNotFoundException;
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
	private Map<String, Attrezzo> attrezzi;
	private int pesoAttuale;


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
		this.attrezzi = new HashMap<>();
		this.pesoAttuale = 0;
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

		if (attrezzi.containsKey(attrezzo.getNome()))
			return false; // l'attrezzo è già presente, non possiamo aggiungerlo di nuovo


		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;

		attrezzi.put(attrezzo.getNome(), attrezzo);
		this.pesoAttuale += attrezzo.getPeso(); 

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
		return this.pesoAttuale;
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
		return attrezzi.get(nomeAttrezzo);

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
	public boolean removeAttrezzo(String nome) {
		Attrezzo a = attrezzi.remove(nome);
		if (a != null) {
			pesoAttuale -= a.getPeso();
			return true;
		}
		return false;
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
			for (Attrezzo a : attrezzi.values())
				s.append(a.toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}


	// HW C ES3
	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
		List<Attrezzo> ordinata = new LinkedList<Attrezzo>(attrezzi.values());
		Collections.sort(ordinata, new ComparatorePeso());
		return ordinata;
	}


	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
		SortedSet<Attrezzo> albero = new TreeSet<Attrezzo>(attrezzi.values());
		return albero;
	}


	public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
		Set<Attrezzo> tmp;
		Map<Integer, Set<Attrezzo>> mappaOrdinata = new HashMap<>(); // crea una nuova mappa da peso a set di attrezzi

		for (Attrezzo a : this.attrezzi.values()) {
			tmp = mappaOrdinata.get(a.getPeso()); // cerca se già esiste un set per quel peso

			if (tmp == null) {
				tmp = new HashSet<>(); // se non esiste, creane uno nuovo
			}

			tmp.add(a); // aggiungi l’attrezzo al set (che ora sicuramente esiste)
			mappaOrdinata.put(a.getPeso(), tmp); // aggiorna la mappa con il set aggiornato
		}

		return mappaOrdinata; // ritorna la mappa finale
	}
	
	//  HW C ES4
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		SortedSet<Attrezzo> albero2 = new TreeSet<Attrezzo>(new ComparatorePeso());
		albero2.addAll(attrezzi.values());
		return albero2;
	}
}
