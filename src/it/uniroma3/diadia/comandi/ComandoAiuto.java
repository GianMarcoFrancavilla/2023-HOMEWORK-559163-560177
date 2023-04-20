package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
	private IO io;
	static final private String[] elencoComandi = {"aiuto", "vai", "prendi", "posa", "fine"};
	
	@Override
	public void esegui(Partita partita) {
		io=new IOConsole();
		// TODO Auto-generated method stub
		for(int i=0; i<elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
		io.mostraMessaggio("");
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

}
