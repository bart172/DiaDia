package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;
import it.uniroma3.diadia.comandi.ComandoPrendi;

public class ComandoPrendiTest {

	Partita partita;
	Attrezzo attrezzoDaPrendere;

	@Before
	public void setUp() throws Exception {
		partita = new Partita();
		attrezzoDaPrendere = new Attrezzo("attrezzoDaPrendere", 1);
		partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzoDaPrendere);

	}

    /*---------Test getNome-------*/

	@Test
	public void testGetNomePositivo() {
		ComandoPrendi comandoPrendi = new ComandoPrendi();
		assertEquals("prendi", comandoPrendi.getNome());
	}

	@Test
	public void testGetNomeNegativo() {
		ComandoPrendi comandoPrendi = new ComandoPrendi();
		assertNotEquals("comando Sconosciuto", comandoPrendi.getNome());
	}


	/*-----------Test setParametro------------*/
	@Test
	public void testSetParametroPositivo() {
		ComandoPrendi comandoPrendi = new ComandoPrendi();
		comandoPrendi.setParametro("attrezzo1");
		assertEquals("attrezzo1", comandoPrendi.getParametro());
	}

	@Test
	public void testSetParametroNegativo() {
		ComandoPosa comandoPrendi = new ComandoPosa();
		comandoPrendi.setParametro("attrezzo1");
		assertNotEquals("attrezzo2", comandoPrendi.getParametro());
	}


	/*---------Test getParametro-------*/

	@Test
	public void testGetParametroPositivo() {
		ComandoPrendi comandoPrendi = new ComandoPrendi();
		comandoPrendi.setParametro("attrezzoDaPrendere");
		assertEquals("attrezzoDaPrendere", comandoPrendi.getParametro());
	}

	@Test 
	public void testGetParametroNegativo() {
		ComandoPrendi comandoPrendi = new ComandoPrendi();
		comandoPrendi.setParametro("attrezzoDaPrendere");
		assertNotEquals("attrezzoNonDaPrendere", comandoPrendi.getParametro());
	}

	/*---------Test Esegui-------*/

	@Test 
	public void testEseguiDiUnAttrezzoDaPosare() {
		ComandoPrendi comandoPrendi = new ComandoPrendi();
		comandoPrendi.setParametro("attrezzoDaPrendere");
		comandoPrendi.esegui(partita);
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("attrezzoDaPrendere"));
		assertFalse(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("attrezzoDaPrendere"));

	}

	@Test
	public void testEseguiDiUnAttrezzoNonNellaStanza() {
		ComandoPrendi comandoPrendi = new ComandoPrendi();
		comandoPrendi.setParametro("attrezzoNonNellaStanza");
		comandoPrendi.esegui(partita);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("attrezzoNonNellaStanza"));
	}


} 