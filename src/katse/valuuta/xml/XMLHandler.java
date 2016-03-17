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
	
	protected String date = null;
	
	protected List<ValuutaKurs> valuutaKursid = new ArrayList<ValuutaKurs>();

	public List<ValuutaKurs> getValuutaKursid() {
		// lihtne ja ajutine ehk igavene lahendus eesti krooni lismiseks
		if(allikas.getBaas().equals("EEK")) valuutaKursid.add(new ValuutaKurs("EEK", "Eesti kroon", "EEK", date, 1.0));
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
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	protected void setProperties(){
		valuutaKurs.setAllikas(allikas.getBaas());
		valuutaKurs.setDate(date);
	}


	protected ValuutaKurs valuutaKurs = null;
	protected String content = null; 
	
	
	@Override
	public void characters(char[] chs, int start, int length) throws SAXException {
	    
		content = String.copyValueOf(chs, start, length).trim();
	}

}
