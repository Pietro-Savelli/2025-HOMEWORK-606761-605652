package test;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.giocatore.Borsa;

import static org.junit.Assert.*;

import org.junit.Test;

public class BorsaTest {
	
	private final Attrezzo prova = new Attrezzo("prova", 3);
	private final Borsa borsa = new Borsa();
	private final Attrezzo spada = new Attrezzo("spada", 3);
	private final Attrezzo lama = new Attrezzo("lama", 9);
	private final Attrezzo osso = new Attrezzo("osso", 3);
	private final Attrezzo chiave = new Attrezzo("osso", 11);
	
	// AddAttrezzo
	@Test
	public void testAddAttrezzo() {
		assertTrue(borsa.addAttrezzo(prova));
	}
	
	@Test
	public void testAddAttrezzoNull() {
		assertFalse(borsa.addAttrezzo(null));
	}
	
	@Test
	public void testAddAttrezzoDiversoNull() {
		assertNotNull(borsa.addAttrezzo(prova));
	}
	
	
	@Test
	public void testAddAttrezzoBorsaPiena() {
		borsa.addAttrezzo(lama);
		assertEquals(9, borsa.getPeso());
		assertFalse(borsa.addAttrezzo(prova));
	}
	
	@Test
	public void testAddAttrezzoPesoMinoreDiDieci() {
		assertTrue(borsa.addAttrezzo(spada));
	}
	
	@Test
	public void testAddAttrezzoPesoMaggioreDiDieci() {
		assertFalse(borsa.addAttrezzo(chiave));
	}
	
	//RemoveAttrezzo
	@Test 
	public void testRemoveAttrezzoNUll() {
		assertFalse(borsa.removeAttrezzo(null));
	}
	
	@Test 
	public void testRemoveAttrezzoBorsaVuotaOSenzaOggetto() {
		assertFalse(borsa.removeAttrezzo(spada.getNome()));
	}
	
	@Test
	public void testRemoveAttrezzoPresente() {
		borsa.addAttrezzo(spada);
		assertTrue(borsa.removeAttrezzo(spada.getNome()));
	}
	
	@Test
	public void testRemoveAttrezzoPresenteTraTanti() {
		borsa.addAttrezzo(spada);
		borsa.addAttrezzo(prova);
		borsa.addAttrezzo(osso);
		assertTrue(borsa.removeAttrezzo(prova.getNome()));
	}
	
	@Test
	public void testRemoveAttrezzoUltimo() {
		borsa.addAttrezzo(spada);
		borsa.addAttrezzo(prova);
		borsa.addAttrezzo(osso);
		assertTrue(borsa.removeAttrezzo(osso.getNome()));
	}
		
	
	//
	@Test
	public void testGetPesoMax() {
		assertFalse(borsa.getPesoMax()== 4);		
	}
}
