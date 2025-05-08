package it.uniroma3.diadia.ambienti;


public class StanzaBloccata extends Stanza{
	
	private String chiave;
	private String direzioneBloccata;
	
	public StanzaBloccata(String nome, String direzioneBloccata, String chiave) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.chiave = chiave;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(direzione == null)
			return null;
		if(direzioneBloccata.equals(direzione))	// se la direzione e' quella bloccata allora controllo se ho la chuiave
			if(!hasAttrezzo(chiave))
			 return this;
		return super.getStanzaAdiacente(direzione);
	}
	
	@Override 
	public String getDescrizione() {
	    String descrizione = super.getDescrizione(); // Ottieni la descrizione base della stanza
	    if (!hasAttrezzo(chiave)) {  // Se non hai la chiave, aggiungi il messaggio
	        return descrizione + " La stanza nella direzione " + direzioneBloccata +
	               " è chiusa, ti serve la chiave (" + chiave + ") per sbloccarla.";
	    }
	    return descrizione;  // Se hai la chiave, non aggiungere nulla
	}
}
