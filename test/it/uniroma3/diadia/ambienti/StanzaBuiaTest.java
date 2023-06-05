package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {
	private StanzaBuia stanza;
	private Attrezzo attrezzo;
	
	
	@Before
	public void setUp() throws Exception {
		stanza = new StanzaBuia("N11");
		attrezzo = new Attrezzo("lanterna", 3);
		
	}

	@Test
	public void testBuiaSi() {
		assertEquals(stanza.toString() + "qui c'è buio pesto", stanza.getDescrizione());
	}
	
	@Test
	public void testBuiaNo() {
		stanza.addAttrezzo(attrezzo);
		assertEquals(stanza.toString(), stanza.getDescrizione());
	}

}
