package it.uniroma3.diadia;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.ambienti.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StanzaBloccataTest {
	
	Stanza stanzaCorrente;
	Stanza stanzaNonBloccata;
	StanzaBloccata stanzaBloccata;
	Attrezzo attrezzoSbloccante;
	Attrezzo attrezzoNonSbloccante;
	String direzioneBloccata = new String("direzioneBloccata");
	String direzioneNonBloccata = new String("direzioneNonBloccata");

	@Before
	public void setUp() throws Exception {
		stanzaCorrente = new Stanza("stanzaCorrente");
		stanzaNonBloccata = new Stanza("stanzaNonBloccata");
		stanzaBloccata = new StanzaBloccata("stanzaBloccata", "direzioneBloccata", "attrezzoSbloccante");
		attrezzoSbloccante = new Attrezzo("attrezzoSbloccante", 1);
		attrezzoNonSbloccante = new Attrezzo("attrezzoNonSbloccante", 1);
	}
	
	//test di una stanza non bloccata con stanza null adiacente  nella direzione bloccata
	@Test
	public void testGetStanzaAdiacenteConStanzaNull() {
		stanzaCorrente.impostaStanzaAdiacente(direzioneBloccata, null);
		assertNull(stanzaCorrente.getStanzaAdiacente("direzioneBloccata"));
	}
	@Test
	public void testGetStanzaAdiacenteConStanzaBloccataEOggettoSbloccante() {
		stanzaCorrente.impostaStanzaAdiacente("direzioneBloccata", stanzaBloccata);
		stanzaCorrente.addAttrezzo(attrezzoSbloccante);
		assertEquals(stanzaBloccata, stanzaCorrente.getStanzaAdiacente("direzioneBloccata"));
	}
	
	@Test
	public void testGetStanzaAdiacenteDiUnaStanzaCorrenteConStanzaBloccataAdiacenteEOggettoNonSbloccante() {
		stanzaCorrente.impostaStanzaAdiacente("direzioneBloccata", stanzaBloccata);
		stanzaCorrente.addAttrezzo(attrezzoNonSbloccante);
		assertEquals(stanzaBloccata, stanzaCorrente.getStanzaAdiacente("direzioneBloccata"));
	}

	@Test
	public void testGetStanzaAdiacenteDiUnaStanzaBloccataEOggettoNonSbloccante() {
		stanzaBloccata.addAttrezzo(attrezzoNonSbloccante);
		stanzaBloccata.impostaStanzaAdiacente("direzioneBloccata", stanzaNonBloccata);
		assertEquals(stanzaBloccata, stanzaBloccata.getStanzaAdiacente("direzioneBloccata"));
	}
	
	@Test
	public void testGetStanzaAdiacenteConDirezioneNonBloccataeStanzaNonBloccata() {
		stanzaCorrente.impostaStanzaAdiacente("direzioneNonBloccata",stanzaNonBloccata);
		assertEquals(stanzaNonBloccata, stanzaCorrente.getStanzaAdiacente("direzioneNonBloccata"));	
	}

	@Test
	public void testGetDescrizioneDiStanzaNonBloccata() {
		stanzaCorrente.impostaStanzaAdiacente("direzioneNonBloccata", stanzaNonBloccata);
		assertEquals(stanzaNonBloccata.toString(), stanzaCorrente.getStanzaAdiacente("direzioneNonBloccata").getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneDiStanzaBloccata() {
		stanzaCorrente.impostaStanzaAdiacente("direzioneBloccata", stanzaBloccata);
		stanzaCorrente.addAttrezzo(attrezzoNonSbloccante);
		assertEquals("Ti trovi in una stanza bloccata: " + stanzaBloccata.toString() + "\nLa direzione direzioneBloccata è bloccata se non hai con te attrezzoSbloccante" , stanzaCorrente.getStanzaAdiacente("direzioneBloccata").getDescrizione());

	}

	

}
