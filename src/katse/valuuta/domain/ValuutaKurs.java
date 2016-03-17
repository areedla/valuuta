package katse.valuuta.domain;

/**
 * Ajaloolised kursitabelite andmed
 * @author AR
 *
 */
public class ValuutaKurs extends BaseEntity{
	
	private String valuuta;
	private String nimetus;
	private String allikas;
	private String allikasNimetus;
	private String kp; 		// antud ülesande lihtsuse huvides Stringina, 
								// kuna kasutatakse ainult kuupäevi
								// kujul aaaa-MM-dd, NB! baasi indeksid..
								// NB! date ei ole hea nimetus väljale
	private Double kurs;
	
	public ValuutaKurs(){
		
	}
	
	public ValuutaKurs(String valuuta, String nimetus, 
			String allikas, String allikasNimetus, String kp, double kurs){
		
		this.valuuta = valuuta;
		this.nimetus = nimetus;
		this.allikas = allikas;
		this.allikasNimetus = allikasNimetus;
		this.kp = kp;
		this.kurs = kurs;
	}
	
	
	public String getValuuta() {
		return valuuta;
	}
	public void setValuuta(String valuuta) {
		this.valuuta = valuuta;
	}
	public String getAllikas() {
		return allikas;
	}
	public void setAllikas(String allikas) {
		this.allikas = allikas;
	}
	public String getKp() {
		return kp;
	}
	public void setKp(String kp) {
		this.kp = kp;
	}
	public Double getKurs() {
		return kurs;
	}
	public void setKurs(Double kurs) {
		this.kurs = kurs;
	}
	public String getNimetus() {
		return nimetus;
	}
	public void setNimetus(String nimetus) {
		this.nimetus = nimetus;
	}

	public String getAllikasNimetus() {
		return allikasNimetus;
	}

	public void setAllikasNimetus(String allikasNimetus) {
		this.allikasNimetus = allikasNimetus;
	}

}
