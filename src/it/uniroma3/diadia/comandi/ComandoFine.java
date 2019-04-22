package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {

	@Override
	public void setParametro(String parametro) {
	}

	@Override
	public void esegui(Partita partita) {
		partita.setFinita();
		System.out.println("Grazie per aver giocato");
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "fine";
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}

}
