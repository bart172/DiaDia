package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public abstract class AbstractComando implements Comando{
	
	public void setParametro(String parametro) {};
	
	public void setParametro() {};
	
	abstract public void esegui (Partita partita);
	
	abstract public String getNome();
	
	public String getParametro() {
		return null;
	}

}