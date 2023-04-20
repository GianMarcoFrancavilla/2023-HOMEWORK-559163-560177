package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;


public class StanzaBloccataTest {
	private StanzaBloccata stanza;
	private Stanza stanzaNord;
	private Stanza stanzaOvest;
	private Attrezzo attrezzo;
	
	@Before
	public void setUp() throws Exception {
		stanza = new StanzaBloccata("N16","osso","ovest");
		attrezzo = new Attrezzo("osso",1);
		stanza.impostaStanzaAdiacente("nord", stanzaNord);
		stanza.impostaStanzaAdiacente("ovest", stanzaOvest);
	}
	
	@Test
	public void testDirezioneBloccata() {
		assertEquals(stanza,stanza.getStanzaAdiacente("ovest"));
	}
	
	@Test
	public void testDirezioneSbloccata() {
		stanza.addAttrezzo(attrezzo);
		assertEquals(stanzaOvest,stanza.getStanzaAdiacente("ovest"));
	}
	
	@Test
	public void testDirezioneConsentita() {
		assertEquals(stanzaNord,stanza.getStanzaAdiacente("nord"));
	}
	

}
