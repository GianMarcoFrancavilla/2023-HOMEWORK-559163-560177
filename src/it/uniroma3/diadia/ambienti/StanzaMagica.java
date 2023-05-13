package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaMagica extends Stanza {
	final static private int SOGLIA_MAGICA_DEFAULT = 3;
	private int contatoreAttrezziPosati;
	private int sogliaMagica;
	public StanzaMagica(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}
	public StanzaMagica(String nome, int soglia) {
		super(nome);
		this.contatoreAttrezziPosati = 0;
		this.sogliaMagica = soglia;
	}
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(contatoreAttrezziPosati<=sogliaMagica) {
			if (this.attrezzi.size()< NUMERO_MASSIMO_ATTREZZI) {
				this.attrezzi.put(attrezzo.getNome(), attrezzo);
				return true;
			}
			else {
				return false;
			}
		}
		else {
			if (this.attrezzi.size()< NUMERO_MASSIMO_ATTREZZI) {

				Attrezzo attrezzoMod = modificaAttrezzo(attrezzo);
				this.attrezzi.put(attrezzoMod.getNome(), attrezzoMod);
				return true;
			}
			else {
				return false;
			}
		}
	}
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder s = new StringBuilder();
		s.append(attrezzo.getNome());
		StringBuilder s_rev = s.reverse();
		attrezzo.setPeso(attrezzo.getPeso()*2);
		String reverseNome = s_rev.toString();
		attrezzo.setNome(reverseNome);
		return attrezzo;
	}
}