package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
	private String luce;
	
	public StanzaBuia(String attrezzo, String nome) {
		super(nome);
		luce = attrezzo;
	}
	
	@Override
	public String getDescrizione() {
		if(hasAttrezzo(luce))
			return super.getDescrizione();
		else
			return  "qui c'è un buio pesto";
	}
}
