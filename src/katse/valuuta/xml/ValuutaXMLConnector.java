package katse.valuuta.xml;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import katse.valuuta.domain.ValuutaKurs;
import katse.valuuta.obj.Allikas;

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
				break;
			case "LTL":
				xmlHandler = new XMLHandlerLTL();
				break;
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
			
			InputStream is = new FileInputStream("C:/ework/valuuta/report.xml");
			parser.parse(is, xmlHandler); //TODO: url'ilt
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return xmlHandler.getValuutaKursid();
		
	}

}
