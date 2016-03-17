package katse.valuuta.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import katse.valuuta.dao.ValuutaKursDao;
import katse.valuuta.domain.ValuutaKurs;
import katse.valuuta.obj.Allikas;
import katse.valuuta.obj.Tulemus;
import katse.valuuta.obj.TulemusRida;
import katse.valuuta.obj.Valuuta;
import katse.valuuta.util.ConfUtil;
import katse.valuuta.util.ValuutaUtil;
import katse.valuuta.xml.ValuutaXMLConnector;

/*
 * Valuuta kalkuleerimise rakenduse äriloogika
 */
@Component
public class ValuutaService {
	
	@Autowired
	ValuutaKursDao valuutaKursDao;
	
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
		
		ConfUtil conf = new ConfUtil();
		List<Allikas> allikad = conf.getAllikad();
		
		// TODO: ikka kõikidest tabelitest ja kõik kirjutada ümmber sümbolite peale
		// optimeerimiseks TODO: sisestada kohe baasi andmed!!! kui juba pole 
		// (hmm baasis peaks mõned uniqu constaindid ka olema?, et ei kirjutaks dopelt andmeid kp kohta, muidu see rakendus..)
		for(Allikas allikas: allikad){
			if(allikas.getBaas().equals("EEK")){
				ValuutaXMLConnector valuutaXmlCon = new ValuutaXMLConnector(allikas);
				String kp = "2010-12-30"; //fix kuna enam uusi pole..DateUtil.formatDate(new Date(), "yyyy-MM-dd");
				List<ValuutaKurs> kursiTabel = valuutaXmlCon.getKursid(kp);
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
	 * Pärib antud kuupäeva valuutade kursid ja sisestab baasi
	 * 		(TODO: - optimeerimiseks tulevikus nt. tagastub leitud tulemuste listi ilma baasist uuesti otsimata)
	 * @return
	 */
	public void uptadeValuutadByData(String kp){
		
		/*
		 * 1. loeb allikate konfi failist kõik allikad
		 * 2. pärib kõikidelt allikatelt kursitabelid esitatud kuupäeva kohta
		 * 3. sisestab leitud tulemused baasi
		 */
		
		ConfUtil conf = new ConfUtil();
		List<Allikas> allikad = conf.getAllikad();
		
		for(Allikas allikas: allikad){
			
			ValuutaXMLConnector valuutaXmlCon = new ValuutaXMLConnector(allikas);
			//String kp = DateUtil.formatDate(DateUtil.getEile(), "yyyy-MM-dd");
			List<ValuutaKurs> kursiTabel = valuutaXmlCon.getKursid(kp);
			
			for(ValuutaKurs valuutaKurs: kursiTabel){
				valuutaKursDao.insert(valuutaKurs);
			}
		}
	}
	
	/**
	 * 
	 * @param allikas
	 * @return
	 */
	public List<ValuutaKurs> getKursiTabel(Allikas allikas, String kp){
		
		ValuutaXMLConnector valuutaXmlCon = new ValuutaXMLConnector(allikas);
		List<ValuutaKurs> kursiTabel = valuutaXmlCon.getKursid(kp);
		
		return kursiTabel;
	}
	
	/**
	 * 
	 * @param tulemus
	 * @return
	 */
	public Tulemus kalkuleeri(Tulemus tulemus, boolean uuesti){
		
		/*
		 * 1. pärib mälust ehk baasis vastava valuuta kursid antud kuupäeval
		 * 2. kui ei leia tulemusi esitab päringu allikatele
		 * 		- sisestab andmed baasi
		 * 		- leiab tulemused
		 * 3. leitud tulemustest teeb vastavad teisendused
		 * 4. tagastab listi tulemustest
		 */
		try{
			// Iga kp peab olema from ja to paar allika kohta ehk listid peavad olema võrdse suurusega
			// See on siin mõtte koht, et kuidas baasi päringuid teha.. hetkel jääb nii
			List<ValuutaKurs> valuutaKursidFrom = valuutaKursDao.getAllByValuutaAndDate(tulemus.from, tulemus.kp);
			List<ValuutaKurs> valuutaKursidTo = valuutaKursDao.getAllByValuutaAndDate(tulemus.to, tulemus.kp);
			
			if(valuutaKursidFrom == null || valuutaKursidFrom.isEmpty()){
				if(uuesti){
					tulemus.msg = "Ei leidnud anutud kuupäeva (" + tulemus.kp + ") kohta vahetuskursse!";
					return tulemus;
				}
				// ei leidnud midagi, siis pärime allikatest
				uptadeValuutadByData(tulemus.kp);
				// ja teeme otsast peale, kui juba pole teinud.. muidu antud kood läheb ilusti tsükklisse:D 
				//												   ja ei hakka seda isegi testima hetkel
				return kalkuleeri(tulemus, true);
			}
			
			tulemus.tulemused = new ArrayList<TulemusRida>();
			double summa = Double.parseDouble(tulemus.summa);
			for(ValuutaKurs from: valuutaKursidFrom){
				// otsime paarilise
				ValuutaKurs to = null;
				for(ValuutaKurs sobib: valuutaKursidTo){
					if(from.getAllikas().equals(sobib.getAllikas())){
						to = sobib;
						break;
					}
				}
				if(to != null && from != null){
					TulemusRida tulemusRida = new TulemusRida();
					double kurs = ValuutaUtil.toBaseValue(from.getKurs(), to.getKurs());
					tulemusRida.summa = Double.toString(kurs * summa);
					tulemusRida.kurs = Double.toString(kurs);
					tulemusRida.allikas = from.getAllikasNimetus();
					
					tulemus.tulemused.add(tulemusRida);	
				}
			}
			// TODO: õnnestus järelikult võib kasutajale midagi öelda, kui vaja a'la tulemus.msg = .. parima panga valik nt
		}catch(Exception e){
			// siin püüame kõik vead kinni ning otsutame mida teha
			tulemus.error = "Viga! See süsteem vajab veel arendamist! Või juhtus müstiline viga ning proovi teine kord uuesti.";
			e.printStackTrace();
		}
		
		
		return tulemus;
	}
	
	

}
