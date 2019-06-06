package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio {

	private static final String MESSAGGIO_DONO = "Sei un vero simpaticone, " +
			"con una mia magica azione, troverai un nuovo oggetto " + 
			"per il tuo borsone!";

	private static final String MESSSAGGIO_SCUSE = "Mi spiace, non ho più nulla...";

	private Attrezzo attrezzo;

	public Mago(String nome, String presentazione, Attrezzo attrezzo) {
		super(nome, presentazione);
		this.attrezzo = attrezzo;
	}

	@Override
	public String agisci(Partita partita) {
		String msg;
		if (attrezzo != null) {
			partita.getStanzaCorrente().addAttrezzo(attrezzo);
			this.attrezzo = null;
			msg = MESSAGGIO_DONO;
		} else {
			msg = MESSSAGGIO_SCUSE;
		}
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		String msg = null;
		if (attrezzo != null) {
			partita.getStanzaCorrente().removeAttrezzo(attrezzo);
			partita.getStanzaCorrente().addAttrezzo(new Attrezzo(attrezzo.getNome(), attrezzo.getPeso()/2));
			msg = "Ho ho ho! Grazie per il dono! Ho eseguito una magia che ne dimezza il peso!";
		} else {
			msg = "Non ho fatto la mia magia perchè non sono riuscito a trovare l'attrezzo che vuoi...";
		}
		
		return msg;
	}

}
