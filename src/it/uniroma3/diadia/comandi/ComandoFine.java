package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoFine extends AbstractComando {
	private IO io;
	
	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		io=new IOConsole();
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

}
