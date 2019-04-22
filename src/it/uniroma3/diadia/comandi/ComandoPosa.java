package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoPosa implements Comando {
	private String nomeAttrezzo;

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		this.nomeAttrezzo = parametro;
	}

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		if(partita.getGiocatore().getBorsa().isEmpty())
			System.out.println("La borsa è vuota!");
		else {
			if(partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
				partita.getLabirinto().getStanzaCorrente().addAttrezzo(partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo));
				partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);	
				System.out.println("L'oggetto è stato posato! Ora è nella stanza");
			}
			else
				System.out.println("Non puoi posare " + nomeAttrezzo);
		}
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "posa";
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return this.nomeAttrezzo;
	}

}
