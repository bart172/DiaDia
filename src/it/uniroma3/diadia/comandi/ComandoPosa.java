package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoPosa extends AbstractComando {
	
	private String nomeAttrezzo;


	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		if(partita.getGiocatore().getBorsa().isEmpty())
			System.out.println("La borsa � vuota!");
		else {
			if(partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
				partita.getLabirinto().getStanzaCorrente().addAttrezzo(partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo));
				partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);	
				System.out.println("L'oggetto � stato posato! Ora � nella stanza");
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


}
