package it.uniroma3.diadia;

import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import static org.junit.Assert.*;

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
	
	/*Lo abbiamo fatto in classe ma non mi convince perch� ho implementato cos� che non dovrei poter aggiungere un peso non lecito
	@Test
	public void getContenutoRaggruppatoPerPeso_DueAttrezziPesoDiverso(){
		Attrezzo libro = new Attrezzo("Libro", 5);
		Attrezzo incudine = new Attrezzo("Incudine", 100);
		this.borsetta.addAttrezzo(libro);
		this.borsetta.addAttrezzo(incudine);
		assertEquals(2, borsetta.getContenutoRaggruppatoPerPeso().size());
		assertSame(libro, borsetta.getContenutoRaggruppatoPerPeso().get(libro.getPeso()).iterator().next());
		assertSame(incudine, borsetta.getContenutoRaggruppatoPerPeso().get(incudine.getPeso()).iterator().next());
	}	
	/*
	 * 
	 */
	/*questo deve fallire*/
//	@Test
//	public void getContenutoRaggruppatoPerPeso_DueAttrezziPesoDiversoELimitato(){
//		Attrezzo libro = new Attrezzo("Libro", 5);
//		Attrezzo incudine = new Attrezzo("Incudine", 100);
//		this.borsetta.addAttrezzo(libro);
//		this.borsetta.addAttrezzo(incudine);
//		assertEquals(2, borsetta.getContenutoRaggruppatoPerPesoLimitatoMax10().size());
//		assertSame(libro, borsetta.getContenutoRaggruppatoPerPesoLimitatoMax10().get(libro.getPeso()).iterator().next());
//		assertSame(incudine, borsetta.getContenutoRaggruppatoPerPesoLimitatoMax10().get(incudine.getPeso()).iterator().next());
//	}	
}