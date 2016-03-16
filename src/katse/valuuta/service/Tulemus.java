package katse.valuuta.service;

import java.util.List;

/**
 * lihtne klass kalkuleerimise tulemuse vastuse jaoks (kontroller ja service omavaheliseks suhtluseks)
 * @author AR
 *
 */
public class Tulemus {
	
	public String msg = "";
	public String error = "";
	public String tulemusKursCaption = "";
	public String tulemusSummaCaption = "";
	public String summa;
	public String from = "";
	public String to = "";
	public String kp = "";
	public List<TulemusRida> tulemused;
	
	public Tulemus(){
		
	}
	
	public Tulemus(String summa, String from, String to, String kp){
		
		this.summa = summa;
		this.from = from;
		this.to = to;
		this.kp = kp;
	}

}
