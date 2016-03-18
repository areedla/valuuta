package katse.valuuta.xml;

import java.io.InputStream;
import java.net.URL;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.ValidationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import katse.valuuta.domain.ValuutaKurs;
import katse.valuuta.exception.ValuutaXMLHandlerException;
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
	
	public List<ValuutaKurs> getKursid(String kp) throws ValuutaXMLHandlerException{
		
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
			LOG.info("Pärime kursid allikast: " + url);
			InputStream is = new URL(url).openStream();			
			parser.parse(is, xmlHandler);
			
		}catch (Exception e) {
			e.printStackTrace(); //see hiljem kui loggimine levelite kaupa paigas
			throw new ValuutaXMLHandlerException("Ei saanud XMLiga hakkama! " + e.getMessage(), xmlHandler.getClass().getName());
			
		}
		
		return xmlHandler.getValuutaKursid();
		
	}

}
