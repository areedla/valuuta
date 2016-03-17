package katse.valuuta.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import katse.valuuta.conf.Allikas;
import katse.valuuta.conf.Conf;
import katse.valuuta.conf.Valuuta;
import katse.valuuta.domain.ValuutaKurs;
import katse.valuuta.util.DateUtil;
import katse.valuuta.xml.ValuutaXMLConnector;

/*
 * Valuuta kalkuleerimise rakenduse äriloogika
 */
@Component
public class ValuutaService {
	
	/**
	 * Kõikide teadaolevate valuutade list
	 * @return
	 */
	public List<Valuuta> getAllValuutad(){
		
		/*
		 * 1. loeb allikate konfi failist kõik allikad
		 * 2. pärib kõikidelt allikatelt kursitabelid eelmise päeva kohta
		 * 		NB! pärime ainult Eesti Panga andmed, sest meid huvitavad valuutade täisnimed
		 * 3. tagastab kõik Valuuta tabeli aktiivsed kirjed
		 */
		
		List<Valuuta> valuutad = new ArrayList<Valuuta>();
		
		List<Allikas> allikad = Conf.getAllikad();
		
		for(Allikas allikas: allikad){
			if(allikas.getBaas().equals("EEK")){
				ValuutaXMLConnector valuutaXmlCon = new ValuutaXMLConnector(allikas);
				String date = DateUtil.formatDate(new Date(), "yyyy-mm-dd");
				List<ValuutaKurs> kursiTabel = valuutaXmlCon.getKursid(date);
				for(ValuutaKurs kurs: kursiTabel){
					valuutad.add(new Valuuta(kurs.getValuuta(), kurs.getNimetus()));
				}
			}
		}
		
		//TODO: sorteerimis kriteerium Valuuta obj juurde
		//Collections.sort(valuutad);
		
		return valuutad;
	}
	
	/**
	 * 
	 * @param allikas
	 * @return
	 */
	public List<ValuutaKurs> getKursiTabel(Allikas allikas, String date){
		
		ValuutaXMLConnector valuutaXmlCon = new ValuutaXMLConnector(allikas);
		List<ValuutaKurs> kursiTabel = valuutaXmlCon.getKursid(date);
		
		return kursiTabel;
	}
	
	/**
	 * 
	 * @param tulemus
	 * @return
	 */
	public Tulemus kalkuleeri(Tulemus tulemus){
		
		
		
		return tulemus;
	}
	
	

}
