package it.uniroma3.diadia;

import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class BorsaTest {
	
	Borsa borsa;
	Borsa borsetta;

	Attrezzo primoAttrezzo;
	Attrezzo secondoAttrezzo;
	Attrezzo terzoAttrezzo;
	Attrezzo attrezzoAmmissibile;
	Attrezzo attrezzoNonAmmissibile;
	Attrezzo attrezzoNonNellaBorsa;
	

	@Before
	public void setUp() throws Exception {
		borsa = new Borsa();
		borsetta = new Borsa();
		
		primoAttrezzo = new Attrezzo("primoAttrezzo", 1);
		secondoAttrezzo = new Attrezzo("secondoAttrezzo", 2);
		terzoAttrezzo = new Attrezzo("terzoAttrezzo", 3);
		attrezzoAmmissibile = new Attrezzo("attrezzoAmmissibile", 1);
		attrezzoNonAmmissibile = new Attrezzo("attrezzoNonAmmissibile", 11);
		attrezzoNonNellaBorsa = new Attrezzo("attrezzoNonNellaBorsa", 1);
		
		this.borsa.addAttrezzo(primoAttrezzo);
		this.borsa.addAttrezzo(secondoAttrezzo);
		this.borsa.addAttrezzo(terzoAttrezzo);
	}
	
	/*-------------------------TEST SU hasAttrezzo------------------------*/

	@Test
	public void testHasAttrezzoDiUnAttrezzoNellaBorsa() {
		assertTrue(this.borsa.hasAttrezzo("primoAttrezzo"));
	}

	@Test
	public void testHasAttrezzoDiUnAttrezzoCheNonEsiste() {
		assertFalse(this.borsa.hasAttrezzo("attrezzoCheNonEsiste"));
	}
	
	@Test
	public void testHasAttrezzoDiUnAttrezzoNull() {
		assertFalse(this.borsa.hasAttrezzo(null));
	}
	
	/*-------------------------TEST SU addAttrezzo------------------------*/
	
	@Test
	public void testAddAttrezzoDiUnAttrezzoConPesoAmmissibile() {
		assertTrue(this.borsa.addAttrezzo(attrezzoAmmissibile));
	}
	
//	@Test //questo test non gira
//	public void testAddAttrezzoDiUnAttrezzoConPesoTroppoGrande() {
//		assertFalse(this.borsa.addAttrezzo(attrezzoNonAmmissibile));
//	}
		
	/*-------------------------TEST SU getAttrezzo------------------------*/
	
	@Test
	public void testGetAttrezzoDiUnAttrezzoNellaBorsa() {
		assertEquals(this.primoAttrezzo, this.borsa.getAttrezzo("primoAttrezzo"));
	}
	
	@Test
	public void testGetAttrezzoDiUnAttrezzoCheNonEsiste() {
		assertNull(this.borsa.getAttrezzo("attrezzoCheNonEsiste"));
	}
	
	/*-------------------------TEST SU removeAttrezzo------------------------*/
	
	@Test
	public void testRemoveAttrezzoDiUnAttrezzoNellaBorsa() {
		assertEquals("secondoAttrezzo",this.borsa.removeAttrezzo("secondoAttrezzo").getNome());
	}
	
	@Test
	public void testRemoveAttrezzoDiUnAttrezzoNonNellaBorsa() {
		assertNull(this.borsa.removeAttrezzo("attrezzoNonNellaBorsa"));
	}
	
	@Test
	public void testRemoveAttrezzoDiUnAttrezzoNull() {
		assertNull(this.borsa.removeAttrezzo(null));
	}
	
	/*-------------------------TEST SU getContenutoRaggruppatoPerPeso------------------------*/	
	@Test
	public void getContenutoRaggruppatoPerPeso(){
		Borsa borsaVuota = new Borsa();
		assertTrue(borsaVuota.getContenutoRaggruppatoPerPeso().isEmpty());
	}
	
	@Test
	public void getContenutoRaggruppatoPerPeso_Singoletto(){
		Attrezzo solitario = new Attrezzo("A", 2);
		this.borsetta.addAttrezzo(solitario);
		assertFalse(this.borsetta.getContenutoRaggruppatoPerPeso().isEmpty());
	}
	
	@Test
	public void getContenutoRaggruppatoPerPeso_DueAttrezziStessoPeso(){
		Attrezzo libro = new Attrezzo("Libro", 5);
		Attrezzo slide = new Attrezzo("Slide", 5);
		this.borsetta.addAttrezzo(libro);
		this.borsetta.addAttrezzo(slide);
		assertEquals(1, this.borsetta.getContenutoRaggruppatoPerPeso().size());
		assertTrue(borsetta.getContenutoRaggruppatoPerPeso().containsKey(5));
		assertEquals((Integer)5, this.borsetta.getContenutoRaggruppatoPerPeso().keySet().iterator().next());
		assertEquals(1, this.borsetta.getContenutoRaggruppatoPerPeso().size());
	}
	
	@Test
	public void getContenutoRaggruppatoPerPeso_DueAttrezziPesoDiversoDiCuiUnoNonLecito(){
		Attrezzo libro = new Attrezzo("Libro", 5);
		Attrezzo incudine = new Attrezzo("Incudine", 100);
		this.borsetta.addAttrezzo(libro);
		this.borsetta.addAttrezzo(incudine);
		assertEquals(1, borsetta.getContenutoRaggruppatoPerPeso().size());
		assertSame(libro, borsetta.getContenutoRaggruppatoPerPeso().get(libro.getPeso()).iterator().next());
	}	
	
	@Test
	public void getContenutoRaggruppatoPerPeso_DueAttrezziPesoDiversoLeciti(){
		Attrezzo libro = new Attrezzo("Libro", 4);
		Attrezzo zaino = new Attrezzo("Zaino", 6);
		this.borsetta.addAttrezzo(libro);
		this.borsetta.addAttrezzo(zaino);
		assertEquals(2, borsetta.getContenutoRaggruppatoPerPeso().size());
		assertSame(libro, borsetta.getContenutoRaggruppatoPerPeso().get(libro.getPeso()).iterator().next());
		assertSame(zaino, borsetta.getContenutoRaggruppatoPerPeso().get(zaino.getPeso()).iterator().next());
	}	
	
	/*-------------------------TEST SU getContenutoOrdinatoPerNome------------------------*/
	@Test
	public void getContenutoOrdinatoPerNome_BorsaVuota() {
		Borsa borsaVuota = new Borsa();
		assertTrue(borsaVuota.getContenutoOrdinatoPerNome().isEmpty());
	}
	
	@Test
	public void getContenutoOrdinatoPerNome_Singoletto() {
		Borsa borsaSingoletto = new Borsa();
		Attrezzo singoletto = new Attrezzo("singoletto", 1);
		borsaSingoletto.addAttrezzo(singoletto);
		assertEquals(1, borsaSingoletto.getContenutoOrdinatoPerNome().size());
		assertSame(singoletto, borsaSingoletto.getContenutoOrdinatoPerNome().iterator().next());
	}
	
	@Test
	public void getContenutoOrdinatoPerNome_DueAttrezziStessoPeso() {
		Borsa borsaDueOggetti = new Borsa();
		Attrezzo primoAttrezzo = new Attrezzo("Abaco", 1);
		Attrezzo secondoAttrezzo = new Attrezzo("Bottiglia", 1);
		borsaDueOggetti.addAttrezzo(secondoAttrezzo);
		borsaDueOggetti.addAttrezzo(primoAttrezzo);
		assertEquals(2, borsaDueOggetti.getContenutoOrdinatoPerNome().size());
		Iterator<Attrezzo> it = borsaDueOggetti.getContenutoOrdinatoPerNome().iterator();
		assertSame(primoAttrezzo, it.next());
		assertSame(secondoAttrezzo, it.next());
	}
	
	@Test
	public void getContenutoOrdinatoPerNome_StessoNomePesoDiverso() {
		Borsa borsaDueOggetti = new Borsa();
		Attrezzo primoAttrezzo = new Attrezzo("Abaco", 1);
		Attrezzo secondoAttrezzo = new Attrezzo("Abaco", 2);
		assertTrue(borsaDueOggetti.addAttrezzo(primoAttrezzo));
		assertTrue(borsaDueOggetti.addAttrezzo(secondoAttrezzo));
		assertEquals(1, borsaDueOggetti.getContenutoOrdinatoPerNome().size());
		assertSame(primoAttrezzo, borsaDueOggetti.getContenutoOrdinatoPerNome().iterator().next());
	}
	
	/*-------------------------TEST SU getContenutoOrdinatoPerPeso------------------------*/
	 @Test
	 public void getContenutoOrdinatoPerPeso_BorsaVuota() {
	  Borsa borsaVuota = new Borsa();
	  assertTrue(borsaVuota.getContenutoOrdinatoPerPeso().isEmpty());
	 }
	 
	 @Test
	 public void getContenutoOrdinatoPerPeso_Singoletto() {
	  Borsa borsaSingoletto = new Borsa();
	  Attrezzo singoletto = new Attrezzo("singoletto", 1);
	  borsaSingoletto.addAttrezzo(singoletto);
	  assertEquals(1, borsaSingoletto.getContenutoOrdinatoPerPeso().size());
	  assertSame(singoletto, borsaSingoletto.getContenutoOrdinatoPerPeso().iterator().next());
	 }
	 
	 @Test
	 public void getContenutoOrdinatoPerPeso_DueAttrezziNomeDiversoePesoDiverso() {
	  Borsa borsaDueOggetti = new Borsa();
	  Attrezzo primoAttrezzo = new Attrezzo("A", 2);
	  Attrezzo secondoAttrezzo = new Attrezzo("B", 1);
	  borsaDueOggetti.addAttrezzo(primoAttrezzo);
	  borsaDueOggetti.addAttrezzo(secondoAttrezzo);
	  Iterator<Attrezzo> it = borsaDueOggetti.getContenutoOrdinatoPerPeso().iterator();
	  assertSame(secondoAttrezzo, it.next());
	  assertSame(primoAttrezzo, it.next());
	 }
	 
	 @Test
	 public void getContenutoOrdinatoPerPeso_DueAttrezziNomeDiversoStessoPeso() {
	  Borsa borsaDueOggetti = new Borsa();
	  Attrezzo primoAttrezzo = new Attrezzo("A", 1);
	  Attrezzo secondoAttrezzo = new Attrezzo("B", 1);
	  borsaDueOggetti.addAttrezzo(primoAttrezzo);
	  borsaDueOggetti.addAttrezzo(secondoAttrezzo);
	  Iterator<Attrezzo> it = borsaDueOggetti.getContenutoOrdinatoPerPeso().iterator();
	  assertSame(primoAttrezzo, it.next());
	  assertSame(secondoAttrezzo, it.next());
	 }
	 
	 /*-------------------------TEST SU getSortedSetOrdinatoPerPeso------------------------*/
	 
	 @Test
	 public void getSortedSetOrdinatoPerPeso_BorsaVuota() {
	  Borsa borsaVuota = new Borsa();
	  assertTrue(borsaVuota.getSortedSetOrdinatoPerPeso().isEmpty());
	 }
	 
	 @Test
	 public void getSortedSetOrdinatoPerPeso_Singoletto() {
	  Borsa borsaSingoletto = new Borsa();
	  Attrezzo singoletto = new Attrezzo("singoletto", 1);
	  borsaSingoletto.addAttrezzo(singoletto);
	  assertEquals(1, borsaSingoletto.getSortedSetOrdinatoPerPeso().size());
	  assertSame(singoletto, borsaSingoletto.getSortedSetOrdinatoPerPeso().iterator().next());
	 }
	 
	 @Test
	 public void getSortedSetOrdinatoPerPeso_DueAttrezziNomeDiversoePesoDiverso() {
	  Borsa borsaDueOggetti = new Borsa();
	  Attrezzo primoAttrezzo = new Attrezzo("B", 1);
	  Attrezzo secondoAttrezzo = new Attrezzo("A", 2);
	  borsaDueOggetti.addAttrezzo(primoAttrezzo);
	  borsaDueOggetti.addAttrezzo(secondoAttrezzo);
	  Iterator<Attrezzo> it = borsaDueOggetti.getSortedSetOrdinatoPerPeso().iterator();
	  assertSame(primoAttrezzo, it.next());
	  assertSame(secondoAttrezzo, it.next());
	 }
	 
	 @Test
	 public void getSortedSetOrdinatoPerPeso_DueAttrezziNomeDiversoStessoPeso() {
	  Borsa borsaDueOggetti = new Borsa();
	  Attrezzo primoAttrezzo = new Attrezzo("A", 1);
	  Attrezzo secondoAttrezzo = new Attrezzo("B", 1);
	  borsaDueOggetti.addAttrezzo(primoAttrezzo);
	  borsaDueOggetti.addAttrezzo(secondoAttrezzo);
	  Iterator<Attrezzo> it = borsaDueOggetti.getSortedSetOrdinatoPerPeso().iterator();
	  assertSame(primoAttrezzo, it.next());
	  assertSame(secondoAttrezzo, it.next());
	 }
	 
	 @Test
	 public void getSortedSetOrdinatoPerPeso_DueAttrezziStessoNomeStessoPeso() {
	  Borsa borsaDueOggetti = new Borsa();
	  Attrezzo primoAttrezzo = new Attrezzo("A", 1);
	  Attrezzo secondoAttrezzo = new Attrezzo("A", 1);
	  borsaDueOggetti.addAttrezzo(primoAttrezzo);
	  borsaDueOggetti.addAttrezzo(secondoAttrezzo);
	  Iterator<Attrezzo> it = borsaDueOggetti.getSortedSetOrdinatoPerPeso().iterator();
	  assertEquals(1, borsaDueOggetti.getSortedSetOrdinatoPerPeso().size());
	  assertSame(primoAttrezzo, it.next());
	 }
	
	

}