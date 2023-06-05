package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {
	private StanzaBloccata stanza;
	private Attrezzo attrezzo;
	private Stanza stanzaNord;
	private Stanza stanzaOvest;

	@Before
	public void setUp() throws Exception {
		attrezzo = new Attrezzo("osso", 1);
		stanza = new StanzaBloccata("N16", "osso", "ovest");
		stanza.impostaStanzaAdiacente("nord", stanzaNord);
		stanza.impostaStanzaAdiacente("ovest", stanzaOvest);
	}
	
	@Test
	public void testBloccata() {
		assertEquals(stanza, stanza.getStanzaAdiacente("ovest"));
	}

	@Test
	public void testSbloccata() {
		stanza.addAttrezzo(attrezzo);
		assertEquals(stanzaOvest, stanza.getStanzaAdiacente("ovest"));
	}
	
	@Test
	public void testConsentita() {
		assertEquals(stanzaNord, stanza.getStanzaAdiacente("nord"));
	}
	

}
