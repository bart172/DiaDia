package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {

	private Stanza stanzaSenzaStanzeAdiacenti;
	private Stanza stanzaConTutteStanzeAdiacenti;

	private Stanza stanzaNord;
	private Stanza stanzaSud;
	private Stanza stanzaEst;
	private Stanza stanzaOvest;
	
	/* Tutti gli attrezzi si trovano in stanzaConTutteStanzeAdiacenti */
	private Attrezzo attrezzo1;
	private Attrezzo attrezzo2;
	private Attrezzo attrezzo3;

	/*
	 * Faccio test su:
	 *  getStanzaAdiacente;
	 * 	hasAttrezzo;
	 * 	getAttrezzo;
	 */

	@Before
	public void setUp() throws Exception {

		stanzaNord = new Stanza("stanzaNord");;
		stanzaSud = new Stanza("stanzaSud");
		stanzaEst = new Stanza("stanzaEst");
		stanzaOvest = new Stanza("stanzaOvest");

		this.stanzaSenzaStanzeAdiacenti  = new Stanza("stanzaSenzaStanzeAdiacenti");
		this.stanzaConTutteStanzeAdiacenti = new Stanza("stanzaConTutteStanzeAdiacenti");

		this.stanzaConTutteStanzeAdiacenti.impostaStanzaAdiacente("nord", this.stanzaNord);
		this.stanzaConTutteStanzeAdiacenti.impostaStanzaAdiacente("sud", this.stanzaSud);
		this.stanzaConTutteStanzeAdiacenti.impostaStanzaAdiacente("est", this.stanzaEst);
		this.stanzaConTutteStanzeAdiacenti.impostaStanzaAdiacente("ovest", this.stanzaOvest);
		
		this.attrezzo1 = new Attrezzo("attrezzo1", 10);
		this.attrezzo2 = new Attrezzo("attrezzo2", 20);
		this.attrezzo3 = new Attrezzo("attrezzo3", 30);
		
		
		this.stanzaConTutteStanzeAdiacenti.addAttrezzo(this.attrezzo1);
		this.stanzaConTutteStanzeAdiacenti.addAttrezzo(this.attrezzo2);
		this.stanzaConTutteStanzeAdiacenti.addAttrezzo(this.attrezzo3);
		
		

	}
	

	/*-----------------------------TEST SU getStanzaAdiacente-----------------------------------*/

	@Test
	public void testGetStanzaAdiacenteDiStanzaSenzaAdiacenti() {
		assertNull(this.stanzaSenzaStanzeAdiacenti.getStanzaAdiacente("nord"));
	}

	@Test
	public void testGetStanzaAdianteDiStanzaConTutteStanzeAdiacenti() {
		assertEquals(this.stanzaSud, this.stanzaConTutteStanzeAdiacenti.getStanzaAdiacente("sud"));
	}
	
	@Test
	public void testGetStanzaAdiacenteSenzaDirezione() {
		assertNull(this.stanzaConTutteStanzeAdiacenti.getStanzaAdiacente(""));
	}
	
	/*-----------------------------TEST SU hasAttrezzo-----------------------------------------*/
	
	@Test
	public void testHasAttrezzoDiUnAttrezzoInUnaStanza() {
		assertTrue(this.stanzaConTutteStanzeAdiacenti.hasAttrezzo("attrezzo2"));
	}
	
	@Test
	public void testHasAttrezzoDiUnAttrezzoCheNonEsiste() {
		assertFalse(this.stanzaConTutteStanzeAdiacenti.hasAttrezzo("attrezzoCheNonEsiste"));
	}
	
	@Test
	public void testHasAttrezzoDiUnAttrezzoInUnaStanzaSenzaAttrezzi() {
		assertFalse(this.stanzaNord.hasAttrezzo("attrezzo1"));
	}
	
	/*-----------------------------TEST SU getAttrezzo-----------------------------------------*/

	@Test 
	public void testGetAttrezzoDiUnAttrezzoInUnaStanza() {
		assertEquals(this.attrezzo1, this.stanzaConTutteStanzeAdiacenti.getAttrezzo("attrezzo1"));
	}
	
	@Test 
	public void testGetAttrezzoDiUnAttrezzoCheNonEsiste() {
		assertNull(this.stanzaConTutteStanzeAdiacenti.getAttrezzo("attrezzoCheNonEsiste"));
	}
	
	
	@Test 
	public void testGetAttrezzoDiUnAttrezzoInUnaStanzaSenzaAttrezzi() {
		assertNull(this.stanzaSenzaStanzeAdiacenti.getAttrezzo("attrezzo1"));
	}
	
	
	
}
