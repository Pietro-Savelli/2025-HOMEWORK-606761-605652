package it.uniroma3.diadia;


import java.util.Scanner;

/**
 * Questa classe modella un comando.
 * Un comando consiste al piu' di due parole:
 * il nome del comando ed un parametro
 * su cui si applica il comando.
 * (Ad es. alla riga digitata dall'utente "vai nord"
 *  corrisponde un comando di nome "vai" e parametro "nord").
 *
 * @author  docente di POO
 * @version base
 */

public class Comando {

    private String nome;
    private String parametro;
    private IOConsole io;

    public Comando(String istruzione) {
		Scanner scannerDiParole = new Scanner(istruzione);
		this.io = new IOConsole();

		// prima parola: nome del comando
		if (scannerDiParole.hasNext())
			this.nome = scannerDiParole.next(); 

		// seconda parola: eventuale parametro(nome del direzione,nome
		if (scannerDiParole.hasNext())
			this.parametro = scannerDiParole.next();
		scannerDiParole.close();
    }
    
    /**
     * 
     * @return il nome del comando
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * 
     * @return parametro su cui si applica il comando
     */
    public String getParametro() {
        return this.parametro;
    }

    public boolean sconosciuto() {
        return this.nome == null;
    }
}