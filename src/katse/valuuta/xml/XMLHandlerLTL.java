package katse.valuuta.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import katse.valuuta.domain.ValuutaKurs;

public class XMLHandlerLTL extends XMLHandler{

	/*
		<ExchangeRates>
		  <item>
		    <date>2010.12.30</date>
		    <currency>AED</currency>
		    <quantity>10</quantity>
		    <rate>7.1536</rate>
		    <unit>LTL per 10 currency units</unit>
		  </item>
		  <item>
		    <date>2010.12.30</date>
		    <currency>AFN</currency>
		    <quantity>100</quantity>
		    <rate>5.8041</rate>
		    <unit>LTL per 100 currency units</unit>
		  </item>
		  ...
	 
	 */
	
	@Override
	public void startElement(String uri, String localName, 
	                           String tag, Attributes attributes) 
	                           throws SAXException {
	       
		switch(tag){
	      	case "item":
	      		valuutaKurs = new ValuutaKurs();
	      		setProperties();
	      		break;
	    }
	}
	
	@Override
	public void endElement(String uri, String localName, 
	                         String tag) throws SAXException {
	   switch(tag){
	     	case "item":
	     		valuutaKursid.add(valuutaKurs);       
	     		break;
	     	case "currency":
	     		valuutaKurs.setValuuta(content);
	     		break;
	     	case "rate":
	     		valuutaKurs.setKurs(Double.parseDouble(content.replace(",", ".")));
	     		break;
	     	case "quantity":
	     		// hetkel eeldab et xml'is on tagid õiges järjekorras
	     		valuutaKurs.setKurs(valuutaKurs.getKurs()/Double.parseDouble(content.replace(",", ".")));
	     		break;
	   }
	}

}
