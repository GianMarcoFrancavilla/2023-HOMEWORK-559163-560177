package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import java.util.List;

import it.uniroma3.diadia.attrezzi.*;

import org.junit.Before;
import org.junit.Test;
import java.util.Map;
import java.util.Set;

/**
 * Test della classe Borsa
 */

public class BorsaTest {

	private Borsa borsa;
	private Attrezzo attrezzo;
	private Attrezzo attrezzo2;
	private Attrezzo attrezzo3;
	private Attrezzo attrezzo4;
	@Before
	public void setUp() throws Exception {
		this.borsa = new Borsa();
		this.attrezzo = new Attrezzo("Penna", 1);
		this.attrezzo2 = new Attrezzo("Banco",3);
		this.attrezzo3 = new Attrezzo("Armadio",2);
		this.attrezzo4 = new Attrezzo("Lavagna",2);
	}

	/**
	 *  Controlla se aggiunge correttamente l'attrezzo
	 */
	@Test
	public void testAddAttrezzo() {
		assertTrue(borsa.toString(), this.borsa.addAttrezzo(this.attrezzo));
	}

	/**
	 *  Controlla se il peso massimo della Borsa è quello corretto
	 */
	@Test
	public void testGetPesoMax() {
		assertEquals(10, this.borsa.getPesoMax());
	}

	/**
	 *  Controlla se la borsa conteggia il peso al suo interno correttamente
	 */
	@Test
	public void testGetPeso() {
		this.borsa.addAttrezzo(this.attrezzo);
		this.borsa.addAttrezzo(this.attrezzo);
		assertEquals(2,this.borsa.getPeso());
	}

	/**
	 *  Controlla se il metodo che ordina gli attrezzi per nome funziona correttamente
	 */
	@Test
	public void testOrdinaPerNome() {
		this.borsa.addAttrezzo(attrezzo);
		this.borsa.addAttrezzo(attrezzo2);
		this.borsa.addAttrezzo(attrezzo3);
		List<Attrezzo> contenuto = borsa.getContenutoOrdinatoPerNome();
		assertSame("Armadio", contenuto.get(0).getNome());
		assertSame("Banco", contenuto.get(1).getNome());
		assertSame("Penna", contenuto.get(2).getNome());
	}

	/**
	 * Controlla se il metodo che ordina gli attrezzi per peso funziona correttamente
	 */
	@Test
	public void testOrdinaPerPeso() {
		this.borsa.addAttrezzo(attrezzo);
		this.borsa.addAttrezzo(attrezzo2);
		this.borsa.addAttrezzo(attrezzo3);
		List<Attrezzo> contenuto = borsa.getContenutoOrdinatoPerPeso();
		assertSame("Penna", contenuto.get(0).getNome());
		assertSame("Armadio", contenuto.get(1).getNome());
		assertSame("Banco", contenuto.get(2).getNome());
	}

	/**
	 * Controlla se il metodo che raggruppa gli attrezzi per peso funziona correttamente
	 */
	@Test
	public void testRaggruppaPerPeso() {
		this.borsa.addAttrezzo(attrezzo);
		this.borsa.addAttrezzo(attrezzo2);
		this.borsa.addAttrezzo(attrezzo3);
		this.borsa.addAttrezzo(attrezzo4);
		Map<Integer, Set<Attrezzo>> contenuto = borsa.getContenutoRaggruppatoPerPeso();
		assertNotNull(contenuto.get(1));
		assertNotNull(contenuto.get(2));
		assertNotNull(contenuto.get(3));
		assertEquals(1, contenuto.get(1).size());
		assertEquals(2, contenuto.get(2).size());
		assertEquals(1, contenuto.get(3).size());
        assertTrue(contenuto.get(1).contains(attrezzo));
        assertTrue(contenuto.get(2).contains(attrezzo3));
        assertTrue(contenuto.get(2).contains(attrezzo4));
        assertTrue(contenuto.get(3).contains(attrezzo2));
	}

}