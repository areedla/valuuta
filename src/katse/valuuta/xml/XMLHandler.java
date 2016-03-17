package katse.valuuta.xml;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import katse.valuuta.domain.ValuutaKurs;
import katse.valuuta.obj.Allikas;

/**
 * Erievatest allikatest tulevate XML'ide töötlemise baasklass
 * @author AR
 *
 */
public abstract class XMLHandler extends DefaultHandler{
	
	protected Allikas allikas = null;
	
	protected String kp = null;
	
	protected List<ValuutaKurs> valuutaKursid = new ArrayList<ValuutaKurs>();

	public List<ValuutaKurs> getValuutaKursid() {
		// lihtne ja ajutine ehk igavene lahendus omaraha lismiseks:D
		// TODO: if(lisati midagi siis alles), aga testimiseks väljas..
		if(allikas.getBaas().equals("EEK")) valuutaKursid.add(new ValuutaKurs("EEK", 
				"Eesti kroon", "EEK", "Eesti Pank", kp, 1.0));
		if(allikas.getBaas().equals("LTL")) valuutaKursid.add(new ValuutaKurs("LTL", 
				"Leedu litt", "LTL", "Leedu Pank", kp, 1.0));
		return valuutaKursid;
	}

	public void setValuutaKursid(List<ValuutaKurs> valuutaKursid) {
		this.valuutaKursid = valuutaKursid;
	}
	
	public Allikas getAllikas() {
		return allikas;
	}

	public void setAllikas(Allikas allikas) {
		this.allikas = allikas;
	}	
	
	public String getKp() {
		return kp;
	}

	public void setKp(String kp) {
		this.kp = kp;
	}

	protected void setProperties(){
		valuutaKurs.setAllikas(allikas.getBaas());
		valuutaKurs.setAllikasNimetus(allikas.getNimetus());
		valuutaKurs.setKp(kp);
	}


	protected ValuutaKurs valuutaKurs = null;
	protected String content = null; 
	
	
	@Override
	public void characters(char[] chs, int start, int length) throws SAXException {
	    
		content = String.copyValueOf(chs, start, length).trim();
	}

}
