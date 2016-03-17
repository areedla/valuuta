package katse.valuuta.conf;

/**
 * Klass valuutadega seotud põhiandmete hoidmiseks
 * @author AR
 *
 */

public class Valuuta{
	
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
	public String toString() {
		return nimetusPikk;
	}
	 
	

}
