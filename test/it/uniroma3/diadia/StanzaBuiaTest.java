package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.ambienti.Stanza;

public class StanzaBuiaTest {

	StanzaBuia stanzaBuia;
	Stanza stanzaNonBuia;
	Attrezzo oggettoChiave;
	Attrezzo attrezzoNonChiave;

	@Before
	public void setUp() throws Exception {
		stanzaBuia = new StanzaBuia("stanzaBuia", "oggettoChiave");
		stanzaNonBuia = new Stanza("stanzaNonBuia");
		oggettoChiave = new Attrezzo("oggettoChiave", 1);
		attrezzoNonChiave = new Attrezzo("attrezzoNonChiave", 2);

	}

	@Test
	public void testStanzaAncoraBuia() {
		assertEquals("Qui c'� buio pesto! Se solo avessi un oggettoChiave...", stanzaBuia.getDescrizione());
	}

	@Test
	public void testStanzaBuiaDiventaVisibile() {
		stanzaBuia.addAttrezzo(oggettoChiave);
		assertNotEquals("Qui c'� buio pesto! Se solo avessi un oggettoChiave...", stanzaBuia.getDescrizione());
	}

	@Test
	public void testStanzaBuiaDopoAverRimossoOggettoChiave() {

		stanzaBuia.removeAttrezzo(oggettoChiave);	
		assertEquals("Qui c'� buio pesto! Se solo avessi un oggettoChiave...", stanzaBuia.getDescrizione());	
	}

	@Test
	public void testStanzaBuiaConOggettoNonChiave() {
		stanzaBuia.addAttrezzo(attrezzoNonChiave);
		assertEquals("Qui c'� buio pesto! Se solo avessi un oggettoChiave...", stanzaBuia.getDescrizione());
	}

}