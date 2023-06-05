package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;


public class Cane extends AbstractPersonaggio {

	private static String CIBO_PREFERITO= "osso";

	public Cane(String nome, String presentazione) {
		super(nome, presentazione);
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		if(attrezzo.getNome().equals(CIBO_PREFERITO)) {
			Attrezzo attrezzoCane = new Attrezzo("Spada", 3);
			partita.getLabirinto().getStanzaVincente().addAttrezzo(attrezzoCane);
			return "Il cane ha accettato il mio regalo";
		}
		else {
			partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
			return "Ahia! sono stato morso e ho perso 1 CFU";
		}
	}

	@Override
	public String agisci(Partita partita) {
		return "Bau bau! Se mi dai il cibo preferito ti droppo un attrezzo, altrimenti ti mordo";
	}


}
