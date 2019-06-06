package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends AbstractComando {


	@Override
	public void esegui(Partita partita) {
		System.out.println("Comando sconosciuto");
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "NonValido";
	}
	
}
