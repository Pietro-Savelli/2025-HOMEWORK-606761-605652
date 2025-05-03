package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {
	
	private StanzaBloccata partenza;
	private Stanza arrivo;
	
	
	@BeforeEach
	public void setUp() {
		partenza = new StanzaBloccata("partenza", "sud", "chiave");
		arrivo = new Stanza("arrivo");
		partenza.impostaStanzaAdiacente("sud", arrivo);
	}
	
	@Test
	public void TestGetStanzaAdiacenteNonSbloccata() {
		assertSame(partenza, partenza.getStanzaAdiacente("sud"));
	}
	
	@Test
	public void TestGetStanzaAdiacenteSbloccata() {
		partenza.addAttrezzo(new Attrezzo("chiave", 3));
		assertSame(arrivo, partenza.getStanzaAdiacente("sud"));
	}
	
	@Test
	public void TestGetStanzaAdiacenteNonSbloccataNull() {
		assertNull(partenza.getStanzaAdiacente(null));
	}
	
	@Test
	public void TestGetStanzaAdiacenteSbloccataNull() {
		partenza.addAttrezzo(new Attrezzo("chiave", 3));
		assertNull(partenza.getStanzaAdiacente(null));
	}
	
	@Test
	public void TestGetStanzaAdiacenteNonSbloccataDirezioneInesistente() {
		assertNull(partenza.getStanzaAdiacente("est"));
	}
	
	@Test
	public void TestGetStanzaAdiacenteSbloccataDirezioneInesistente() {
		partenza.addAttrezzo(new Attrezzo("chiave", 3));
		assertNull(partenza.getStanzaAdiacente("est"));
	}
	
	@Test
	public void TestGetStanzaAdiacenteSbloccataDirezioneNonBLoccata() {
		partenza.addAttrezzo(new Attrezzo("chiave", 3));
		Stanza arrivo2 =new Stanza("arrivo2");
		partenza.impostaStanzaAdiacente("nord", arrivo2);
		assertSame( arrivo2, partenza.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void TestGetStanzaAdiacenteNonSbloccataDirezioneNonBLoccata() {
		Stanza arrivo2 =new Stanza("arrivo2");
		partenza.impostaStanzaAdiacente("nord", arrivo2);
		assertSame(arrivo2, partenza.getStanzaAdiacente("nord"));
	}
}
