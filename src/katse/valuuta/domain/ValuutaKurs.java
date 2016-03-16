package katse.valuuta.domain;

import javax.persistence.Entity;

/**
 * Ajaloolised kursitabelite andmed
 * @author kasutaja5y
 *
 */
@Entity
public class ValuutaKurs extends BaseEntity{
	

	private String valuuta;	
	private String allikas;		
	private String date; 		// antud ülesande lihtsuse huvides Stringina, 
								// kuna kasutatakse ainult kuupäevi
								// kujul aaaa-MM-dd, NB! baasi indeksid
	private Double kurs;
	
	
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Double getKurs() {
		return kurs;
	}
	public void setKurs(Double kurs) {
		this.kurs = kurs;
	}
	
	

}
