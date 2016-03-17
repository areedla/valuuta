package katse.valuuta.xml;

import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import katse.valuuta.conf.Allikas;
import katse.valuuta.domain.ValuutaKurs;

public class ValuutaXMLConnector {
	
	//private static Logger LOG = LoggerFactory.getLogger(ValuutaXMLConnector.class);
	
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
	
	public List<ValuutaKurs> getKursid(String date){
		
		XMLHandler xmlHandler = null;
		
		// TODO: throw mingi error kui baas määramata
		// või logi .. hetkel jätame töötlemata
		// XML'idest tulemuste lugemine erinevatest allikatest
		switch(allikas.getBaas()){
			case "EEK":
				xmlHandler = new XMLHandlerEEK();
			case "LTL":
				xmlHandler = new XMLHandlerLTL();	
		}
		if(xmlHandler == null){
			//LOG.info("Ei toeta veel sellist allikat: " + allikas.getBaas());
			return null;
		}
		
		try {
			
			SAXParserFactory parserFactor = SAXParserFactory.newInstance();
			SAXParser parser = parserFactor.newSAXParser();
			xmlHandler.setAllikas(allikas);
			xmlHandler.setDate(date);
			parser.parse(ClassLoader.getSystemResourceAsStream("xml.xml"), xmlHandler); //TODO: url'ilt
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return xmlHandler.getValuutaKursid();
		
	}

}
