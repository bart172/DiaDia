package it.uniroma3.diadia;

import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BorsaTest {
	
	Borsa borsa;
	
	Attrezzo primoAttrezzo;
	Attrezzo secondoAttrezzo;
	Attrezzo terzoAttrezzo;
	Attrezzo attrezzoAmmissibile;
	Attrezzo attrezzoNonAmmissibile;
	Attrezzo attrezzoNonNellaBorsa;
	

	@Before
	public void setUp() throws Exception {
		borsa = new Borsa();
		
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
	
	@Test
	public void testAddAttrezzoDiUnAttrezzoConPesoTroppoGrande() {
		assertFalse(this.borsa.addAttrezzo(attrezzoNonAmmissibile));
	}
		
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
	
	
}