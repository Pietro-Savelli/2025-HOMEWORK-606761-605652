package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio{

	private static final String MESSAGGIO_DONO = "Sei un vero simpaticone, " +
			"con una mia magica azione, troverai un nuovo oggetto " +
			"per il tuo borsone!";
	private static final String MESSAGGIO_SCUSE = "Mi spiace, ma non ho piu' nulla...";
	private static final String MESSAGGIO_SCUSE2 = "Mi spiace, ma ho gia' un attrezzo in tasca non posso prenderlo...";
	private static final String MESSAGGIO_RINGRAZIAMENTO = "Grazie per questo bellissimo oggetto";
	
	private Attrezzo attrezzo;
	
	
	public Mago(String nome, String presentazione, Attrezzo attrezzo) {
		super(nome, presentazione);
		this.attrezzo = attrezzo;
	}
	
	
	@Override
	public String agisci(Partita partita) {
		String msg;
		if (this.attrezzo!=null) {
			partita.getStanzaCorrente().addAttrezzo(this.attrezzo);
			this.attrezzo = null;
			msg = MESSAGGIO_DONO;
		}
		else {
			msg = MESSAGGIO_SCUSE;
		}
		return msg;
	}


	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita){
		if(this.attrezzo!=null)
			return MESSAGGIO_SCUSE2;
		
		this.attrezzo = attrezzo;
		return MESSAGGIO_RINGRAZIAMENTO;
	}
}
