package katse.valuuta.obj;

/**
 * Klass valuutadega seotud põhiandmete hoidmiseks
 * @author AR
 *
 */

public class Valuuta implements Comparable<Valuuta>{
	
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 2893749823L;
	
	private String nimetus;
	private String nimetusPikk;
	
	public Valuuta(){
		
	}
	
	public Valuuta(String nimetus, String nimetusPikk){
		
		this.nimetus = nimetus;
		this.nimetusPikk = nimetusPikk;
	}
	
	public String getNimetus() {
		return nimetus;
	}
	public void setNimetus(String nimetus) {
		this.nimetus = nimetus;
	}
	public String getNimetusPikk() {
		return nimetusPikk;
	}
	public void setNimetusPikk(String nimetusPikk) {
		this.nimetusPikk = nimetusPikk;
	}
	
	@Override
	public boolean equals(Object o) {
		return nimetus == ((Valuuta) o).getNimetus();
	}
	
	@Override
	public String toString() {
		return nimetusPikk;
	}
	
	@Override
	public int compareTo(Valuuta v) {
        return this.nimetus.compareTo(v.getNimetus());
    }

}
