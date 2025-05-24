package test;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.giocatore.Borsa;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

import org.junit.Test;

public class BorsaTest {

	private final Attrezzo prova = new Attrezzo("prova", 3);
	private final Borsa borsa = new Borsa();
	private final Attrezzo spada = new Attrezzo("spada", 3);
	private final Attrezzo lama = new Attrezzo("lama", 9);
	private final Attrezzo osso = new Attrezzo("osso", 3);
	private final Attrezzo chiave = new Attrezzo("chiave", 11);
	private final Attrezzo penna = new Attrezzo("penna", 1);

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


	//
	@Test
	public void testGetContenutoOrdinatoPerPesoDiverso() {
		borsa.addAttrezzo(spada);
		borsa.addAttrezzo(penna);

		List <Attrezzo> ordinata = borsa.getContenutoOrdinatoPerPeso();
		assertEquals(0, ordinata.indexOf(penna));		
		assertEquals(1, ordinata.indexOf(spada));
	}

	@Test
	public void testGetContenutoOrdinatoPerPesoUguale() {
		borsa.addAttrezzo(osso);
		borsa.addAttrezzo(spada);


		List <Attrezzo> ordinata = borsa.getContenutoOrdinatoPerPeso();
		assertEquals(0, ordinata.indexOf(osso));		
		assertEquals(1, ordinata.indexOf(spada));
	}

	@Test
	public void testGetContenutoOrdinatoPerPesoVuota() {
		borsa.addAttrezzo(null);
		List <Attrezzo> ordinata = borsa.getContenutoOrdinatoPerPeso();
		assertEquals(0, ordinata.size());		
	}


	//

	@Test 
	public void testGetContenutoOrdinatoPerNome() {
		borsa.addAttrezzo(spada);
		borsa.addAttrezzo(penna);
		borsa.addAttrezzo(osso);
		SortedSet<Attrezzo> albero = borsa.getContenutoOrdinatoPerNome();

		assertEquals(osso, albero.first());
		assertEquals(spada, albero.last());
	}

	@Test
	public void testGetContenutoOrdinatoPerNomeBorsaVuota() {
		SortedSet<Attrezzo> albero = borsa.getContenutoOrdinatoPerNome();
		assertTrue(albero.isEmpty());
	}

	@Test 
	public void testGetContenutoOrdinatoPerNomeTuttaSeguenzaOrdinata() {
		borsa.addAttrezzo(spada);
		borsa.addAttrezzo(penna);
		borsa.addAttrezzo(osso);
		borsa.addAttrezzo(prova);
		SortedSet<Attrezzo> albero = borsa.getContenutoOrdinatoPerNome();

		Iterator<Attrezzo> i = albero.iterator();
		assertEquals(osso, i.next());
		assertEquals(penna, i.next());
		assertEquals(prova, i.next());
		assertEquals(spada, i.next());
		assertFalse(i.hasNext());
	}


	@Test
	public void testGetContenutoOrdinatoPerNomeClone() {
		borsa.addAttrezzo(spada);
		borsa.addAttrezzo(spada);

		SortedSet<Attrezzo> albero = borsa.getContenutoOrdinatoPerNome();
		assertEquals(1, albero.size());
	}

	//
	@Test
	public void testGetContenutoRaggruppatoPerPeso() {
		Borsa borsone = new Borsa(50);
		Map<Integer,Set<Attrezzo>> pesati = borsone.getContenutoRaggruppatoPerPeso();

		//vuoto
		assertEquals(0, pesati.size());

		//aggiungo attrezzi e li ordino
		borsone.addAttrezzo(spada);//3
		borsone.addAttrezzo(penna);//1
		borsone.addAttrezzo(osso);//3
		borsone.addAttrezzo(prova);//3
		borsone.addAttrezzo(chiave);//11
		borsone.addAttrezzo(lama);//9

		pesati = borsone.getContenutoRaggruppatoPerPeso();

		//numero di chiavi giuste
		assertEquals(4, pesati.size());

		// la chiave 3 contine tutti gli attrezzi 3
		assertTrue(pesati.get(3).contains(spada));
		assertTrue(pesati.get(3).contains(osso));
		assertTrue(pesati.get(3).contains(prova));
		assertFalse(pesati.get(3).contains(chiave));
		assertFalse(pesati.get(3).contains(lama));
		assertFalse(pesati.get(3).contains(penna));

		// grandezze giuste dei set
		assertEquals(3, pesati.get(3).size());
		assertEquals(1, pesati.get(11).size());
		assertEquals(1, pesati.get(9).size());
		assertEquals(1, pesati.get(1).size());

		// aggiungo uno stesso attrezzo(non e' ammesso)
		borsone.addAttrezzo(spada);//3
		assertTrue(pesati.get(3).contains(spada));
		assertEquals(3, pesati.get(3).size());
	} 

	//
	@Test
	public void testGetSortedSetOrdinatoPerPeso() {
		borsa.addAttrezzo(osso);
		borsa.addAttrezzo(penna);

		SortedSet<Attrezzo> ordinati = borsa.getSortedSetOrdinatoPerPeso();
		Iterator<Attrezzo> it = ordinati.iterator();

		assertEquals("penna", it.next().getNome());  // 1
		assertEquals("osso", it.next().getNome());  // 2
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPesoVuoto() {
	    SortedSet<Attrezzo> ordinati = borsa.getSortedSetOrdinatoPerPeso();
	    assertTrue(ordinati.isEmpty());
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPesoNome() {
		borsa.addAttrezzo(penna);
		borsa.addAttrezzo(spada);
		borsa.addAttrezzo(osso);
		
		SortedSet<Attrezzo> ordinati = borsa.getSortedSetOrdinatoPerPeso();
		Iterator<Attrezzo> it = ordinati.iterator();

		assertEquals("penna", it.next().getNome());  // 1
		assertEquals("osso", it.next().getNome());  // 2
		assertEquals("spada", it.next().getNome());
	}
	
	



































}
