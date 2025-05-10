
package it.uniroma3.diadia;

public class IOSimulator implements IO {
	
    private String[] comandiInIngresso;
    private int indiceComandoCorrente;
    private String[] messaggiStampati;
    private int numeroMessaggiStampati;
    private int indiceMessaggioLetti;

    public IOSimulator(String[] comandiInIngresso) {
        this.comandiInIngresso = comandiInIngresso;
        this.indiceComandoCorrente = 0;
        this.messaggiStampati = new String[100];
        this.numeroMessaggiStampati = 0;
        this.indiceMessaggioLetti = 0;
        
    }

    @Override
    public void mostraMessaggio(String messaggio) {
        this.messaggiStampati[this.numeroMessaggiStampati] = messaggio;
        this.numeroMessaggiStampati++;
        
    }

    @Override
    public String leggiRiga() {
        String comando = this.comandiInIngresso[this.indiceComandoCorrente];
        this.indiceComandoCorrente++;
        return comando;
        
    }

    // Metodo per ottenere il prossimo messaggio stampato
    public String leggiNextMessaggio() {
        String messaggio = this.messaggiStampati[this.indiceMessaggioLetti];
        this.indiceMessaggioLetti++;
        return messaggio;
        
    }

    // Verifica se ci sono ancora messaggi da leggere
    public boolean hasNextMessaggio() {
        return this.indiceMessaggioLetti < this.numeroMessaggiStampati;
    }
}