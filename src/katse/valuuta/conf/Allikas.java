package katse.valuuta.conf;

/**
 * Lihtne objekt allika andmete hoidmiseks 
	baas
	nimetus
	url
 * @author AR
 *
 */
public class Allikas {
	
	private String baas;
	private String nimetus;
	private String url;
	
	public Allikas(String baas, String nimetus, String url){
		
		this.baas = baas;
		this.nimetus = nimetus;
		this.url = url;
	}

	public String getBaas() {
		return baas;
	}

	public void setBaas(String baas) {
		this.baas = baas;
	}

	public String getNimetus() {
		return nimetus;
	}

	public void setNimetus(String nimetus) {
		this.nimetus = nimetus;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}	

}
