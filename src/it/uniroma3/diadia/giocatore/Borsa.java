package it.uniroma3.diadia.giocatore;
import java.util.Comparator; 
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private HashMap<String,Attrezzo> attrezzi;
	private int pesoMax;
	private int pesoCorrente;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	public Borsa(int pesoMax) {
		this.attrezzi = new HashMap<>();
		this.pesoMax = pesoMax;
		this.pesoCorrente=0;
	}

	private class Nome implements Comparator<Attrezzo>{
		@Override
		public int compare(Attrezzo a1, Attrezzo a2) {
			return a1.getNome().compareTo(a2.getNome());
		}
	}

	private class Peso implements Comparator<Attrezzo>{
		@Override
		public int compare(Attrezzo a1, Attrezzo a2) {
			if (a1.getPeso() - a2.getPeso() == 0){
				return a1.getNome().compareTo(a2.getNome());
			}else{
				return a1.getPeso() - a2.getPeso();
			}
		}
	}
	
    public static SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(List<Attrezzo> attrezzi) {
        Comparator<Attrezzo> byPesoENome = Comparator.comparing(Attrezzo::getPeso)
            .thenComparing(Attrezzo::getNome);
        SortedSet<Attrezzo> attrezziOrdinati = new TreeSet<>(byPesoENome);
        attrezziOrdinati.addAll(attrezzi);
        return attrezziOrdinati;
    }

	public List<Attrezzo>  getContenutoOrdinatoPer(Comparator<Attrezzo> c){
		List<Attrezzo> l = new ArrayList<>();
		l.addAll(this.attrezzi.values());
		Collections.sort(l, c);
		return l;
	}

	public List<Attrezzo>  getContenutoOrdinatoPerPeso(){
		return this.getContenutoOrdinatoPer(new Peso());
	}

	public List<Attrezzo>  getContenutoOrdinatoPerNome(){
		return this.getContenutoOrdinatoPer(new Nome());
	}

	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		HashMap<Integer, Set<Attrezzo>> m = new HashMap<>();
		Set<Attrezzo> s = null;

		for(Attrezzo a: this.attrezzi.values()){
			if(m.containsKey(a.getPeso())) {
				s = m.get(a.getPeso());
				s.add(a);
			}
			else {
				s = new HashSet<Attrezzo>();
				s.add(a);
				m.put(a.getPeso(), s);
			}
		}
		return m;
	}



	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (attrezzo == null) 
			return false;
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		this.attrezzi.put(attrezzo.getNome(), attrezzo);
		this.pesoCorrente += attrezzo.getPeso();
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
		return this.attrezzi.isEmpty();
	}
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		this.pesoCorrente -= this.attrezzi.get(nomeAttrezzo).getPeso();
		return this.attrezzi.remove(nomeAttrezzo);
	}

	public String toString(){
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()){
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): "); 
			for (Attrezzo a: this.attrezzi.values()) 
				s.append(a.toString()+" ");
		}else{
			s.append("Borsa vuota");
		}
		return s.toString();
	}

}