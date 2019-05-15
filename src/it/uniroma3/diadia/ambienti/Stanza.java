package it.uniroma3.diadia.ambienti;

import java.util.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;
/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
 */

public class Stanza {
	private String nome;
	private List<Attrezzo> attrezzi;
	private Map<String, Stanza> stanzeAdiacenti;

	public Stanza (String descrizione) {
		this.nome = descrizione;
		this.attrezzi = new ArrayList<>();
		this.stanzeAdiacenti = new HashMap<>();
	}

	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * @param direzione
	 */
	public Stanza getStanzaAdiacente(String direzione) {
		return this.stanzeAdiacenti.get(direzione);
	}
	/**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione direzione in cui sara' posta la stanza adiacente.
	 * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
	 */

	public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
		this.stanzeAdiacenti.put(direzione, stanza);
	}

	/**
	 * Restituisce la nome della stanza.
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce la descrizione della stanza.
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * @return la collezione di attrezzi nella stanza.
	 */
	public List<Attrezzo> getAttrezzi() {
		return Collections.unmodifiableList(this.attrezzi);
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * @param attrezzo l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false altrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(this.attrezzi.contains(attrezzo))
			return false;
		this.attrezzi.add(attrezzo);
		return true;
	}

	/**
	 * Restituisce una rappresentazione stringa di questa stanza,
	 * stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.nome);
		Iterator<String> it = this.stanzeAdiacenti.keySet().iterator();
		if(this.stanzeAdiacenti.isEmpty())
			risultato.append("\nNon ci sono uscite ");
		else {
			risultato.append("\nUscite: ");
			if(it.hasNext()) {
				risultato.append(" " + this.stanzeAdiacenti.keySet());
			}
		}
		Iterator <Attrezzo> iteratore = this.attrezzi.iterator();
		if(this.attrezzi.isEmpty())
			risultato.append("\nNon ci sono attrezzi nella stanza");
		else {
			risultato.append("\nAttrezzi nella stanza: ");
			if(iteratore.hasNext()) {
				risultato.append(this.attrezzi.toString()+" ");
			}
		}
		return risultato.toString();
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		Iterator<Attrezzo> it = this.attrezzi.iterator();
		Attrezzo a = null;
		while(it.hasNext()) {
			a = it.next();
			if(a.getNome().equals(nomeAttrezzo))
				return true;
		}
		return false;
	}

	/**
	 * Restituisce l'attrezzo attrezzoCercato se presente nella stanza.
	 * @param attrezzoCercato
	 * @return l'attrezzo presente nella stanza.
	 * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String attrezzoCercato) {
		Attrezzo a = null;
		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		while(iteratore.hasNext()) {
			a = iteratore.next();
			if(a.getNome().equals(attrezzoCercato))
				return a;
		}
		return null; 
	}
	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * 
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo nomeAttrezzo) {
		Iterator<Attrezzo> it = this.attrezzi.iterator();
		Attrezzo a = null;
		while(it.hasNext()) {
			a = it.next();
			if(a.getNome().equals(nomeAttrezzo.getNome())) {
				it.remove();
				return true;
			}
		}
		return false;
	}

	public Set<String> getDirezioni() {
		return this.stanzeAdiacenti.keySet();
	}

}

//public class Stanza {
//
//static final private int NUMERO_MASSIMO_DIREZIONI = 4;
//static final private int NUMERO_MASSIMO_ATTREZZI = 10;
//
//private String nome;
//private Attrezzo[] attrezzi;
//private int numeroAttrezzi;
//private Stanza[] stanzeAdiacenti;
//private int numeroStanzeAdiacenti;
//private String[] direzioni;
//
///**
// * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
// * @param nome il nome della stanza
// */
//public Stanza(String nome) {
//    this.nome = nome;
//    this.numeroStanzeAdiacenti = 0;
//    this.numeroAttrezzi = 0;
//    this.direzioni = new String[NUMERO_MASSIMO_DIREZIONI];
//    this.stanzeAdiacenti = new Stanza[NUMERO_MASSIMO_DIREZIONI];
//    this.attrezzi = new Attrezzo[NUMERO_MASSIMO_ATTREZZI];
//}
//
///**
// * Imposta una stanza adiacente.
// *
// * @param direzione direzione in cui sara' posta la stanza adiacente.
// * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
// */
//public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
//	boolean aggiornato = false;
//	for(int i=0; i<this.direzioni.length; i++) {
//		if(direzione != null) {
//			if (direzione.equals(this.direzioni[i])) {
//				this.stanzeAdiacenti[i] = stanza;
//				aggiornato = true;
//			}
//		}
//	}
//	if (!aggiornato)
//		if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
//			this.direzioni[numeroStanzeAdiacenti] = direzione;
//			this.stanzeAdiacenti[numeroStanzeAdiacenti] = stanza;
//			this.numeroStanzeAdiacenti++;
//		}
//}
//
///**
// * Restituisce la stanza adiacente nella direzione specificata
// * @param direzione
// */
//public Stanza getStanzaAdiacente(String direzione) {
//	Stanza stanza = null;
//	for(int i=0; i<this.numeroStanzeAdiacenti; i++)
//		if(direzione != null)
//			if (this.direzioni[i].equals(direzione))
//				stanza = this.stanzeAdiacenti[i];
//	return stanza;
//}
//
///**
// * Restituisce la nome della stanza.
// * @return il nome della stanza
// */
//public String getNome() {
//    return this.nome;
//}
//
///**
// * Restituisce la descrizione della stanza.
// * @return la descrizione della stanza
// */
//public String getDescrizione() {
//    return this.toString();
//}
//
///**
// * Restituisce la collezione di attrezzi presenti nella stanza.
// * @return la collezione di attrezzi nella stanza.
// */
//public Attrezzo[] getAttrezzi() {
//    return this.attrezzi;
//}
/////**
// * Mette un attrezzo nella stanza.
// * @param attrezzo l'attrezzo da mettere nella stanza.
// * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
// */
//public boolean addAttrezzo(Attrezzo attrezzo) {
//    if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
//    	this.attrezzi[numeroAttrezzi] = attrezzo;
//    	this.numeroAttrezzi++;
//    	return true;
//    }
//    else {
//    	return false;
//    }
//}//
///**
//* Restituisce una rappresentazione stringa di questa stanza,
//* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
//* @return la rappresentazione stringa
//*/
//public String toString() {
//	StringBuilder risultato = new StringBuilder();
//	risultato.append(this.nome);
//	risultato.append("\nUscite: ");
//	for (String direzione : this.direzioni)
//		if (direzione!=null)
//			risultato.append(" " + direzione);
//	risultato.append("\nAttrezzi nella stanza: ");
//	for (Attrezzo attrezzo : this.attrezzi) {
//		if(attrezzo!=null)
//			risultato.append(attrezzo.toString()+" ");
//	}
//	return risultato.toString();
//}
//
///**
//* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
//* @return true se l'attrezzo esiste nella stanza, false altrimenti.
//*/
//public boolean hasAttrezzo(String nomeAttrezzo) {
//	boolean trovato;
//	trovato = false;
//	for (Attrezzo attrezzo : this.attrezzi) {
//		if(attrezzo != null) {
//			if (attrezzo.getNome().equals(nomeAttrezzo))
//				trovato = true;
//		}
//	}
//	return trovato;
//}
//
///**
// * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
// * @param nomeAttrezzo
// * @return l'attrezzo presente nella stanza.
// * 		   null se l'attrezzo non e' presente.
// */
//public Attrezzo getAttrezzo(String nomeAttrezzo) {
//	Attrezzo attrezzoCercato;
//	attrezzoCercato = null;
//	for (Attrezzo attrezzo : this.attrezzi) {
//		if(attrezzo != null) {
//			if (attrezzo.getNome().equals(nomeAttrezzo))
//				attrezzoCercato = attrezzo;
//		}
//	}
//	return attrezzoCercato;	
//}
//
///**
// * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
// * @param nomeAttrezzo
// * @return true se l'attrezzo e' stato rimosso, false altrimenti
// */
//public boolean removeAttrezzo(Attrezzo nomeAttrezzo) {
//	if(hasAttrezzo(nomeAttrezzo.getNome()) != false) {
//		for(int i=0; i<this.numeroAttrezzi; i++) {
//			if(this.attrezzi[i].getNome().equals(nomeAttrezzo.getNome())) {
//				this.attrezzi[i] = this.attrezzi[this.numeroAttrezzi-1];
//				this.attrezzi[this.numeroAttrezzi-1] = null;
//				this.numeroAttrezzi = this.numeroAttrezzi-1;
//				return true;
//			}
//		}
//	}
//	return false;
//}
//
//
//	public String[] getDirezioni() {
//		String[] direzioni = new String[this.numeroStanzeAdiacenti];
//	    for(int i=0; i<this.numeroStanzeAdiacenti; i++)
//	    	direzioni[i] = this.direzioni[i];
//	    return direzioni;
//    }
//
//}