package it.uniroma3.diadia;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;


public class StanzaTest {
	private Stanza stanzaSenzaAdiacenti; //stanza senza adiacenti
	private Stanza stanzaTutteAdiacenti; //stanza con stanze adiacenti in tutte le direzioni
	
	private Stanza stanzaNord; //stanza adiacente a nord
	private Stanza stanzaSud; //stanza adiacente a sud
	private Stanza stanzaEst; //stanza adiacente a est
	private Stanza stanzaOvest;  //stanza adiacente a ovest
	
	private Attrezzo attrezzo1;
	private Attrezzo attrezzo2;
	private Attrezzo attrezzo3;
	
	@Before
	public void setUp() {
		stanzaSenzaAdiacenti = new Stanza ("stanzaSenzaAdiacenti");
		stanzaTutteAdiacenti = new Stanza ("stanzaTutteAdiacenti");
		stanzaNord = new Stanza ("stanzaNord");
		stanzaSud = new Stanza ("stanzaSud");
		stanzaEst = new Stanza ("stanzaEst");
		stanzaOvest = new Stanza ("stanzaOvest");

		this.stanzaTutteAdiacenti.impostaStanzaAdiacente("nord", stanzaNord);
		this.stanzaTutteAdiacenti.impostaStanzaAdiacente("sud", stanzaSud);
		this.stanzaTutteAdiacenti.impostaStanzaAdiacente("est", stanzaEst);
		this.stanzaTutteAdiacenti.impostaStanzaAdiacente("ovest", stanzaOvest);
		
		attrezzo1 = new Attrezzo ("attrezzo1", 1);
		attrezzo2 = new Attrezzo ("attrezzo2", 2);		
		attrezzo3 = new Attrezzo ("attrezzo3", 3);	
		
		//tutti gli attrezzi sono nella stanzaTutteAdiacenti
		this.stanzaTutteAdiacenti.addAttrezzo(attrezzo1);
		this.stanzaTutteAdiacenti.addAttrezzo(attrezzo2);
		this.stanzaTutteAdiacenti.addAttrezzo(attrezzo3);
		
	}

/*Test su getStanzaAdiacente*/	
	
	@Test
	//verifica che la stanza priva di adiacenti non abbia effettivamente stanze adiacenti in una direzione a caso; restituendo null
	public void testGetStanzaAdiacenteDiStanzaSenzaAdiacenti() {
		assertNull(this.stanzaSenzaAdiacenti.getStanzaAdiacente("nord"));
	}
	
	@Test
	//verifica l'uguaglianza tra una stanza adiacente di StanzaTutteAdiacenti e la stanza adiacente fissata nel setUp()
	public void testGetStanzaAdiacenteDiStanzaTutteAdiacenti() {
		assertEquals(this.stanzaSud, this.stanzaTutteAdiacenti.getStanzaAdiacente("sud"));
	}
	
	@Test
	//verifica che, non inserendo una direzione dalla stanza adiacente di StanzaTutteAdiacenti, restituisca null
	public void testGetStanzaAdiacenteDiStanzaTutteAdiacentiSenzaDirezione () {
		assertNull(this.stanzaTutteAdiacenti.getStanzaAdiacente(""));
	}
	
	
/*Test su hasAttrezzo*/
	
	@Test
	//verifica la presenza di un attrezzo in una stanza
	public void testHasAttrezzoDiUnAttrezzoInUnaStanza() {
		assertTrue(this.stanzaTutteAdiacenti.hasAttrezzo("attrezzo2"));
	}

	@Test
	//verifica la presenza di un attrezzo che non esiste
	public void testHasAttrezzoDiUnAttrezzoCheNonEsiste() {
		assertFalse(this.stanzaTutteAdiacenti.hasAttrezzo("attrezzo5"));
	}
	
	@Test
	//verifica la presenza di una attrezzo in una stanza senza attrezzi
	public void testHasAttrezziDiUnAttrezzoInUnaStanzaSenzaAttrezzi() {
		assertFalse(this.stanzaSenzaAdiacenti.hasAttrezzo("attrezzo2"));
	}
	
/*Test su getAttrezzo*/	
	@Test
	//restituisce l'attrezzo cercato nella stanzaTutteAdiacenti
	public void testGetAttrezzoDiUnAttrezzoInUnaStanza() {
		assertEquals (attrezzo3, this.stanzaTutteAdiacenti.getAttrezzo("attrezzo3"));
	}

	@Test
	//verifica che non ci sia un determinato attrezzo in una stanza
	public void testGetAttrezzoDiUnAttrezzoCheNonEsiste() {
		assertNull(this.stanzaTutteAdiacenti.getAttrezzo(""));
	}
	
	@Test
	//verifica che non ci sia un attrezzo in una stanza priva di attrezzi
	public void testGetAttrezzoDiUnAttrezzoInUnaStanzaSenzaAttrezzi(){
		assertNull(this.stanzaSenzaAdiacenti.getAttrezzo("attrezzo1"));
	}
	
/*Test su addAttrezzo*/
	@Test
	/*verifica che aggiunga un singolo attrezzo alla stanza*/
	public void addAttrezzoSingolo () {
		assertTrue(this.stanzaSenzaAdiacenti.addAttrezzo(attrezzo2));
	}
	
	@Test
	/*aggiunge un numero di attrezzi maggiore di 10*/
	public void addAttrezzoMassimoAttrezzi() {
		for(int i=0; i<10; i++) {
			this.stanzaSenzaAdiacenti.addAttrezzo(new Attrezzo("attrezzo"+i, 1));
		}
		assertFalse(this.stanzaSenzaAdiacenti.addAttrezzo(attrezzo3));
	}
	
}

	
	
	
	
	
	
	
	
	
	
