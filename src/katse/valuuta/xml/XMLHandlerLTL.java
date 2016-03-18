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
		
	   double rate = 0;
	   double quantity = 0;
	   switch(tag){
	     	case "item":
	     		valuutaKursid.add(valuutaKurs);       
	     		break;
	     	case "currency":
	     		//System.out.println("currency: " + content);
	     		valuutaKurs.setValuuta(content);
	     		break;
	     	case "rate":
	     		//System.out.println("rate: " + content);
	     		rate = Double.parseDouble(content.replace(",", "."));
	     		valuutaKurs.setKurs(rate);
	     		if(quantity != 0) valuutaKurs.setKurs((rate/quantity));
	     		break;
	     	case "quantity":
	     		//System.out.println("quantity: " + content);
	     		quantity = Double.parseDouble(content.replace(",", "."));
	     		if(rate != 0) valuutaKurs.setKurs((rate/quantity));
	     		break;
	   }
	}

}
