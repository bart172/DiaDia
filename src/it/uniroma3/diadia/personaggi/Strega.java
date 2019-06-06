package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio {



	public Strega(String nome, String presentazione) {
		super(nome, presentazione);
	}

	@Override
	public String agisci(Partita partita) {
		String msg;
		if (!haSalutato()) {
			this.spostaStanzaMenoAttrezzi(partita);
			msg = "Non mi hai salutato! Che sgarbato! Per dispetto ti spostero' nella stanza con meno attrezzi!";
		} else {
			this.spostaStanzaPiuAttrezzi(partita);
			msg = "Dato che mi hai salutato ti spostero' nella stanza con piu' attrezzi!";
		}
		
		return msg;
	}
	
	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		String msg = null;
		if (attrezzo != null) {
			partita.getStanzaCorrente().removeAttrezzo(attrezzo);
			msg = "Hihihi! Grazie per questo regalo... Mi sa proprio che lo terro'! Hihihi!";
		} else {
			msg = "E dai, dammi un regalino... Ti prometto che ti ricompenserò profumatamente... Hihihi!";
		}
		return msg;
	}

	
	/**
	 * Metodo per determinare la stanza in cui la strega ci sposta se non l'abbiamo salutata
	 * @param partita
	 */
	private void spostaStanzaMenoAttrezzi(Partita partita) {
		String[] direzioni = { "nord", "sud", "est", "ovest" };
		String prossimaDirezione = null;		//la direzione in cui verrò spostato
		int menoAttrezzi = 999;					//il numero di attrezzi in una data stanza

		for (String d : direzioni) {
			if (partita.getStanzaCorrente().getStanzaAdiacente(d) != null) {
				if (partita.getStanzaCorrente().getStanzaAdiacente(d).getAttrezzi().size() <= menoAttrezzi) {
					menoAttrezzi = partita.getStanzaCorrente().getStanzaAdiacente(d).getAttrezzi().size();
					prossimaDirezione = d;
				}
			}
		}

		partita.getLabirinto().setStanzaCorrente(partita.getStanzaCorrente().getStanzaAdiacente(prossimaDirezione));

	}

	/**
	 * Metodo per determinare la stanza in cui la strega ci sposta se l'abbiamo salutata
	 * @param partita
	 */
	private void spostaStanzaPiuAttrezzi(Partita partita) {
		String[] direzioni = { "nord", "sud", "est", "ovest" };
		String prossimaDirezione = null;		//la direzione in cui verrò spostato
		int piuAttrezzi = -1;					//il numero di attrezzi in una data stanza

		for (String d : direzioni) {
			if (partita.getStanzaCorrente().getStanzaAdiacente(d) != null) {
				if (partita.getStanzaCorrente().getStanzaAdiacente(d).getAttrezzi().size() >= piuAttrezzi) {
					piuAttrezzi = partita.getStanzaCorrente().getStanzaAdiacente(d).getAttrezzi().size();
					prossimaDirezione = d;
				}
			}
		}

		partita.getLabirinto().setStanzaCorrente(partita.getStanzaCorrente().getStanzaAdiacente(prossimaDirezione));
	}


}
