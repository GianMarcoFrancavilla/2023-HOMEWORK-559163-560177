package it.uniroma3.diadia.giocatore;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.List;
import java.util.Set;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private HashMap<String, Attrezzo> attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	private int pesoCorrente;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<>();
		this.numeroAttrezzi = 0;
		this.pesoCorrente=0;
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo==null)
			return false;
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		this.attrezzi.put(attrezzo.getNome(), attrezzo);
		this.pesoCorrente = this.pesoCorrente + attrezzo.getPeso();
		return true;
	}

	public int getPesoMax() {
		return pesoMax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}

	public int getPeso() {
		return this.pesoCorrente;
	}

	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}


	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		this.pesoCorrente = this.pesoCorrente - this.attrezzi.get(nomeAttrezzo).getPeso();
		return this.attrezzi.remove(nomeAttrezzo);
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (Attrezzo a : this.attrezzi.values())
				s.append(a.toString()+" ");
		}
		else {
			s.append("Borsa vuota");
		}
		return s.toString();
	}

	public int getNumeroAttrezzi() {
		return numeroAttrezzi;
	}

	public void setNumeroAttrezzi(int numeroAttrezzi) {
		this.numeroAttrezzi = numeroAttrezzi;
	}

	
	private class Nome implements Comparator<Attrezzo>{
		@Override
		public int compare(Attrezzo a, Attrezzo b) {
			return a.getNome().compareTo(b.getNome());
		}
		
	}
	
	private class Peso implements Comparator<Attrezzo>{
		@Override
		public int compare(Attrezzo a, Attrezzo b) {
			if(a.getPeso()==b.getPeso()) {
			 return a.getNome().compareTo(b.getNome());
			}
			else 
				return a.getPeso()-b.getPeso();
		}
		
	}
	
	public List<Attrezzo> getContenutoOrdinatoPer(Comparator<Attrezzo> c){
		List<Attrezzo> l = new ArrayList<>();
		l.addAll(this.attrezzi.values());
		Collections.sort(l,c);
		return l;
	}
	
	public List<Attrezzo> getContenutoOrdinatoPerNome(){
		return this.getContenutoOrdinatoPer(new Nome());
	}
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		return this.getContenutoOrdinatoPer(new Peso());
	}
	
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		HashMap<Integer,Set<Attrezzo>> mappa = new HashMap<>();
		Set<Attrezzo> see = null;
		
		for(Attrezzo a : this.attrezzi.values()) {
			if(mappa.containsKey(a.getPeso())) {
				see=mappa.get(a.getPeso());
				see.add(a);
			}
			else {
				see = new HashSet<>();
				see.add(a);
				mappa.put(a.getPeso(), see);
			}
				
		}
		return mappa;

	}

	public static SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(List<Attrezzo> attrezzi) {
		Comparator<Attrezzo> byPesoENome = Comparator.comparing(Attrezzo::getPeso)
				.thenComparing(Attrezzo::getNome);
		SortedSet<Attrezzo> attrezziOrdinati = new TreeSet<>(byPesoENome);
		attrezziOrdinati.addAll(attrezzi);
		return attrezziOrdinati;
	}

	

}