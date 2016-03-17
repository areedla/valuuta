package katse.valuuta.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import katse.valuuta.domain.ValuutaKurs;

public class XMLHandlerEEK extends XMLHandler{

	
	/*
	 	<Currency name="AED" text="Araabia Ühendemiraatide dirhem" rate="3,2169600000"></Currency>
	 	<Currency name="ARS" text="Argentina peeso" rate="2,9695600000"></Currency>
	 */
	
	@Override
	public void startElement(String uri, String localName, 
	                           String tag, Attributes attributes) 
	                           throws SAXException {
	       
		switch(tag){
	      	case "Currency":
	      		valuutaKurs = new ValuutaKurs();
	      		setProperties();
	      		valuutaKurs.setValuuta(attributes.getValue("name"));
	      		valuutaKurs.setNimetus(attributes.getValue("text"));
	      		valuutaKurs.setKurs(Double.parseDouble(attributes.getValue("rate").replace(",", ".")));
	      		attributes.getValue("id");
	      		break;
	    }
	}
	
	@Override
	public void endElement(String uri, String localName, 
	                         String tag) throws SAXException {
	   switch(tag){
	     	case "Currency":
	     		valuutaKursid.add(valuutaKurs);       
	     		break;
	   }
	}	

}
