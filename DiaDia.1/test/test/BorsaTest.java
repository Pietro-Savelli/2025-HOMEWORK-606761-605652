package test;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.giocatore.Borsa;

import static org.junit.Assert.*;

import org.junit.Test;

public class BorsaTest {
	
	private final Attrezzo a = new Attrezzo("prova", 3);
	private final Borsa borsa = new Borsa();
	private final Attrezzo spada = new Attrezzo("spada", 4);
	private final Attrezzo lama = new Attrezzo("lama", 11);
	
	
	@Test
	public void testAddAttrezzo() {
		assertTrue(borsa.addAttrezzo(a));
	}
	
	@Test
	public void testAddAttrezzoNull() {
		assertFalse(borsa.addAttrezzo(null));
	}
	
	@Test
	public void testAddAttrezzoDiversoNull() {
		assertNotNull(borsa.addAttrezzo(a));
	}
	
	@Test
	public void testGetPesoMax() {
		assertFalse(borsa.getPesoMax()== 4);		
	}
	
	@Test
	public void testAddAttrezzoPesoMinoreDiDieci() {
		assertTrue(borsa.addAttrezzo(spada));
	}
	
	@Test
	public void testAddAttrezzoPesoMaggioreDiDieci() {
		assertFalse(borsa.addAttrezzo(lama));
	}

}
