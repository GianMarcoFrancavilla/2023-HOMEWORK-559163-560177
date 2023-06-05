package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando{
	private IO io;
	static final private String[] elencoComandi = {"aiuto", "vai", "prendi", "posa", "interagisci", "saluta", "regala", "fine"};
	
	@Override
	public void esegui(Partita partita) {
		io=new IOConsole();
		// TODO Auto-generated method stub
		for(int i=0; i<elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
		io.mostraMessaggio("");
	}

}
