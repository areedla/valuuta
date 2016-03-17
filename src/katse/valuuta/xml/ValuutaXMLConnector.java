package katse.valuuta.xml;

import java.io.InputStream;
import java.net.URL;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import katse.valuuta.domain.ValuutaKurs;
import katse.valuuta.obj.Allikas;

public class ValuutaXMLConnector {
	
	private Logger LOG = LoggerFactory.getLogger(ValuutaXMLConnector.class);
	
	private Allikas allikas;
	
	public ValuutaXMLConnector(){
		
	}
	public ValuutaXMLConnector(Allikas allikas){
		this.allikas = allikas;
	}

	public Allikas getAllikas() {
		return allikas;
	}

	public void setAllikas(Allikas allikas) {
		this.allikas = allikas;
	}
	
	public List<ValuutaKurs> getKursid(String kp){
		
		XMLHandler xmlHandler = null;
		
		// TODO: throw mingi error kui baas määramata
		// või logi .. hetkel jätame töötlemata
		// XML'idest tulemuste lugemine erinevatest allikatest
		switch(allikas.getBaas()){
			case "EEK":
				xmlHandler = new XMLHandlerEEK();
				break;
			case "LTL":
				xmlHandler = new XMLHandlerLTL();
				break;
		}
		if(xmlHandler == null){
			LOG.info("Ei toeta veel sellist allikat: " + allikas.getBaas());
			return null;
		}
		
		try {
			
			SAXParserFactory parserFactor = SAXParserFactory.newInstance();
			SAXParser parser = parserFactor.newSAXParser();
			xmlHandler.setAllikas(allikas);
			xmlHandler.setKp(kp);
			String url = allikas.getUrl() + kp;
			LOG.info("Pärime kursid allikat: " + url);
			InputStream is = new URL(url).openStream();			
			parser.parse(is, xmlHandler); //TODO: url'ilt
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return xmlHandler.getValuutaKursid();
		
	}

}
