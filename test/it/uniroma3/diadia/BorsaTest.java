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
	
	
	
	/* Da testare:
	 * - hasAttrezzo
	 * - addAttrezzo
	 * - getAttrezzo
	 * - removeAttrezzo
	 */
	@Before
	public void setUp() throws Exception {
		borsa = new Borsa();
		
		primoAttrezzo = new Attrezzo("primoAttrezzo", 1);
		secondoAttrezzo = new Attrezzo("secondoAttrezzo", 2);
		terzoAttrezzo = new Attrezzo("terzoAttrezzo", 3);
		
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
		Attrezzo attrezzoAmmissibile = new Attrezzo("attrezzoAmmissibile", 1);
		assertTrue(this.borsa.addAttrezzo(attrezzoAmmissibile));
	}
	
	@Test
	public void testAddAttrezzoDiUnAttrezzoConPesoTroppoGrande() {
		Attrezzo attrezzoNonAmmissibile = new Attrezzo("attrezzoNonAmmissibile", 11);
		assertFalse(this.borsa.addAttrezzo(attrezzoNonAmmissibile));
	}
	
	@Test
	public void testAddAttrezzoDiUnAttrezzoCheNonEsiste() {
		assertFalse(this.borsa.addAttrezzo(null));
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
	
	@Test
	public void testGetAttrezzoDiUnAttrezzoCheNonENellaBorsa() {
		Attrezzo attrezzoNonNellaBorsa = new Attrezzo("attrezzoNonNellaBorsa", 1);
		assertNull(this.borsa.getAttrezzo("attrezzoNonNellaBorsa"));
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
