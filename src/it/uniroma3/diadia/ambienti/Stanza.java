package it.uniroma3.diadia.ambienti;
import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
	
	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	static final private int NUMERO_MASSIMO_ATTREZZI = 10;
	
	private String nome;
	private Map<String, Stanza> stanzeAdiacenti;
	//private Map<String, Stanza> uscite;
	private ArrayList<Attrezzo> attrezzi;
	private int numeroAttrezzi;
	//private int numeroStanzeAdiacenti;
	
	public Stanza(String nome) {
		//this.uscite = new HashMap<>();
		this.attrezzi = new ArrayList<>();
		this.nome = nome;
		this.stanzeAdiacenti = new HashMap<>();
	}

    /**
     * Restituisce la stanza adiacente nella direzione specificata
     * @param direzione
     */
    public Stanza getStanzaAdiacente(String direzione) {
    	return this.stanzeAdiacenti.get(direzione);
    }
    
    public void impostaStanzaAdiacente(String direzione, Stanza stanzaAdiacente) {
    	this.stanzeAdiacenti.put(direzione,  stanzaAdiacente);
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
    public ArrayList<Attrezzo> getAttrezzi() {
        return this.attrezzi;
    }

    /**
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
        if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
        	this.attrezzi.add(attrezzo);
        	this.numeroAttrezzi++;
        	return true;
        }
        else {
        	return false;
        }
    }

   /**
	* Restituisce una rappresentazione stringa di questa stanza,
	* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	* @return la rappresentazione stringa
	*/
    public String toString() {
    	StringBuilder risultato = new StringBuilder();
    	risultato.append(this.nome);
    	risultato.append("\nUscite: ");
    	
    	
    	for (String direzione : this.stanzeAdiacenti.keySet())
    		if (direzione!=null)
    			risultato.append(" " + direzione);
    	risultato.append("\nAttrezzi nella stanza: ");
    	for (Attrezzo attrezzo : this.attrezzi) {
    		if(attrezzo!=null)
    			risultato.append(attrezzo.toString()+" ");
    	}
    	return risultato.toString();
    }

    /**
	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		Iterator<Attrezzo> iterator = this.attrezzi.iterator();
		while(iterator.hasNext()) {
			Attrezzo a = iterator.next();
			if (a.getNome().equals(nomeAttrezzo)) {
				return true;
			}
		}
		return false;
	}

	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Iterator<Attrezzo> iterator = this.attrezzi.iterator();
		while(iterator.hasNext()) {
			Attrezzo a = iterator.next();
			if (a.getNome().equals(nomeAttrezzo)) {
				return a;
			}
		}
		return null;
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		Iterator<Attrezzo> iteratore = this.attrezzi.iterator();
		while (iteratore.hasNext()) {
			a = iteratore.next();
			if (a.getNome().equals(nomeAttrezzo)) {
				iteratore.remove();
				return true; 
			}
		}
		return false;
	}


	public Set<String> getDirezioni() {
		
		return this.stanzeAdiacenti.keySet();
				
//		String[] direzioni = new String[this.numeroStanzeAdiacenti];
//	    for(int i=0; i<this.numeroStanzeAdiacenti; i++)
//	    	direzioni[i] = this.direzioni[i];
//	    return direzioni;
    }

}