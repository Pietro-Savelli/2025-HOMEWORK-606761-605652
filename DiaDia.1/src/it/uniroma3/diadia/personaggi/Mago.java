package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio{

	private static final String MESSAGGIO_DONO = "Sei un vero simpaticone, " +
			"con una mia magica azione, troverai un nuovo oggetto " +
			"per il tuo borsone!";
	private static final String MESSAGGIO_SCUSE = "Mi spiace, ma non ho piu' nulla...";
	private static final String MESSAGGIO_RINGRAZIAMENTO = "Grazie per questo bellissimo oggetto, gli ho"+
			"dimezzato il peso e messo nella stanza";
	
	private Attrezzo attrezzo;
	
	
	public Mago(String nome, String presentazione, Attrezzo attrezzo) {
		super(nome, presentazione);
		this.attrezzo = attrezzo;
	}
	
	
	public Mago(String mago, String presentazione, String attrezzo2, Integer toInt) {
		super(mago, presentazione);
		this.attrezzo = new Attrezzo(attrezzo2, toInt);
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
		Attrezzo a = new Attrezzo(attrezzo.getNome(), attrezzo.getPeso()/2);
		partita.getStanzaCorrente().addAttrezzo(a);
		return MESSAGGIO_RINGRAZIAMENTO;
	}
}
