package it.uniroma3.diadia.ambienti;

import java.util.*;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;
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
	private AbstractPersonaggio personaggio;

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
		Set<String> direzioni = this.stanzeAdiacenti.keySet();
		Iterator<String> it = direzioni.iterator();
		while (it.hasNext()) {
			if (it.next() == direzione) {
				return;
			}
		}
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

	public void addPersonaggio(AbstractPersonaggio personaggio) {
		this.personaggio = personaggio;
	}

	public AbstractPersonaggio getPersonaggio() {
		return this.personaggio;
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
				risultato.append(iteratore.next().toString()+" ");
			}
		}

		if (this.getPersonaggio() != null) {
			risultato.append("\nPersonaggio nella stanza: ");
			risultato.append(this.getPersonaggio().toString());
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
