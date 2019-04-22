package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagica extends Stanza {
	private int numeroAttrezziAggiunti;
	private int numeroMagico;
	private static final int NUMERO_MAGICO_DEFAULT = 4;
	
	
	public StanzaMagica(String nome) {
		super(nome);
		this.numeroMagico = NUMERO_MAGICO_DEFAULT;
	}
	
	public StanzaMagica(String nome, int numeroMagico) {	
		super(nome);
		this.numeroMagico = numeroMagico;
	}
	
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		this.numeroAttrezziAggiunti++;
		if(this.numeroAttrezziAggiunti >= this.numeroMagico) {
			attrezzo = modificaAttrezzo(attrezzo);
		}
		return super.addAttrezzo(attrezzo);
	}

	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder sb = new StringBuilder(attrezzo.getNome());
		sb.reverse();
		return new Attrezzo(sb.toString(), attrezzo.getPeso()*2);
	}
}
