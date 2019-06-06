package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoRegala extends AbstractComando {

	private String nomeAttrezzo;

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio = partita.getStanzaCorrente().getPersonaggio();
		String msg = null;;

		if (personaggio != null) {
			msg = personaggio.riceviRegalo(partita.getStanzaCorrente().getAttrezzo(this.nomeAttrezzo), partita);
		} else {
			msg = "Non ho trovato nessuno...";
		}

		System.out.println(msg);

	}

	@Override
	public String getNome() {
		return "regala";
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

}
