package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoSaluta extends AbstractComando {

	private IO io;
	@Override
	public void esegui(Partita partita) {
		if(partita.getLabirinto().getStanzaCorrente().getPersonaggio()!=null)
			io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getPersonaggio().saluta());
		else 
			io.mostraMessaggio("Non c'e' alcun personaggio in questa stanza!");
	}
	
	@Override
	public void setIo(IO io) {
		this.io = io;
	}

}
