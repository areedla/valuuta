package katse.valuuta.obj;

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
	
	
	
	public String getMsg() {
		return msg;
	}



	public void setMsg(String msg) {
		this.msg = msg;
	}



	public String getError() {
		return error;
	}



	public void setError(String error) {
		this.error = error;
	}



	public String getTulemusKursCaption() {
		return tulemusKursCaption;
	}



	public void setTulemusKursCaption(String tulemusKursCaption) {
		this.tulemusKursCaption = tulemusKursCaption;
	}



	public String getTulemusSummaCaption() {
		return tulemusSummaCaption;
	}



	public void setTulemusSummaCaption(String tulemusSummaCaption) {
		this.tulemusSummaCaption = tulemusSummaCaption;
	}



	public String getSumma() {
		return summa;
	}



	public void setSumma(String summa) {
		this.summa = summa;
	}



	public String getFrom() {
		return from;
	}



	public void setFrom(String from) {
		this.from = from;
	}



	public String getTo() {
		return to;
	}



	public void setTo(String to) {
		this.to = to;
	}



	public String getKp() {
		return kp;
	}



	public void setKp(String kp) {
		this.kp = kp;
	}



	public List<TulemusRida> getTulemused() {
		return tulemused;
	}



	public void setTulemused(List<TulemusRida> tulemused) {
		this.tulemused = tulemused;
	}



	public Tulemus(String summa, String from, String to, String kp){
		
		this.summa = summa;
		this.from = from;
		this.to = to;
		this.kp = kp;
	}

}
