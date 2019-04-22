package it.uniroma3.diadia.comandi;

import java.util.Scanner;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi {

	@Override
	public Comando costruisciComando(String istruzione) {
		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null;
		String parametro = null;
		Comando comando = null;
		if(scannerDiParole.hasNext()) {
			nomeComando = scannerDiParole.next();
		}
		if(scannerDiParole.hasNext()) {
			parametro = scannerDiParole.next();
		}
		if("vai".equals(nomeComando))
			comando = new ComandoVai();
		else if("aiuto".equals(nomeComando))
			comando = new ComandoAiuto();
		else if("prendi".equals(nomeComando))
			comando = new ComandoPrendi();
		else if("posa".equals(nomeComando))
			comando = new ComandoPosa();
		else if("fine".equals(nomeComando))
			comando = new ComandoFine();
		else if ("guarda".equals(nomeComando))
			comando = new ComandoGuarda();
		else
			comando = new ComandoNonValido();
		comando.setParametro(parametro);
		return comando;
	}

}
