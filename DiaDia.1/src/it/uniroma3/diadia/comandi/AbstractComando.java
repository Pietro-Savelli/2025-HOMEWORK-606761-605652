package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public abstract class AbstractComando implements Comando{

	private String parametro;
	private IO console;

	public AbstractComando(String parametro, IO io) {
		setParametro(parametro);
		setIO(io);
	}

	public AbstractComando() {
		// TODO Auto-generated constructor stub
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	public void setIO(IO console) {
		this.console = console;
	}

	public IO getConsole() {
		return console;
	}

	public String getParametro() {
		return parametro;
	}

	/**
	 * esecuzione del comando, rendendolo astratto
	 * @param partita
	 */
	public abstract void esegui(Partita partita);

	/* metodi per i test */
	public abstract String getNome();


}
