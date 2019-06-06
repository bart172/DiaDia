package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoSaluta extends AbstractComando {
	
	private static final String MESSAGGIO_CHI = "Chi dovrei salutare?";
	private String messaggio;


	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio;
		personaggio = partita.getStanzaCorrente().getPersonaggio();
		if (personaggio != null) {
			this.messaggio = personaggio.saluta();
			System.out.println(this.messaggio);
		} else System.out.println(MESSAGGIO_CHI);
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "saluta";
	}


}
