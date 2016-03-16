package katse.valuuta.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import katse.valuuta.domain.Valuuta;

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
		
		List<Valuuta> valuutad = new ArrayList<Valuuta>();
		
		return valuutad;
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
