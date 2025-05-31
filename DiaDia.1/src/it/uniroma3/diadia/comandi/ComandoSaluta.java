package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoSaluta extends AbstractComando{

	@Override
	public void esegui(Partita partita) {
		if(partita.getStanzaCorrente().getPersonaggio()==null) {
			getConsole().mostraMessaggio("non esiste nessun personaggio dentro questa stanaza");
			return ;
		}
			
		partita.getStanzaCorrente().getPersonaggio().saluta();
	}

	@Override
	public String getNome() {
		return "saluta";
	}

}
