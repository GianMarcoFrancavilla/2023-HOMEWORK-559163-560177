package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import static it.uniroma3.diadia.giocatore.Borsa.DEFAULT_PESO_MAX_BORSA;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando {
	private String nomeAttrezzo;
	private IO io;

	
	@Override
	public void esegui(Partita partita) {
		 io = new IOConsole();
		if(nomeAttrezzo!=null) {
			if((partita.getLabirinto().getStanzaCorrente().hasAttrezzo(nomeAttrezzo) == true)
					&&(partita.getGiocatore().getBorsa().getPeso() + 
							partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo).getPeso()<DEFAULT_PESO_MAX_BORSA)){
				Attrezzo a = partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
				partita.getLabirinto().getStanzaCorrente().removeAttrezzo(a);
				
				if(partita.getGiocatore().getBorsa().addAttrezzo(a)!=true) {
					io.mostraMessaggio("Non puoi prendere " + nomeAttrezzo + ".");
				}else
					io.mostraMessaggio(a.getNome() + " e' stato aggiuto alla borsa!");
					io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
			}
			else {
				io.mostraMessaggio("nella stanza non e' presente l'oggetto desiderato o la borsa è troppo piena/pesante");
			}
		}
		else
			io.mostraMessaggio("non hai inserito l'oggetto, quale vuoi prendere?");
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;

	}

}
