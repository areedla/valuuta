package katse.valuuta.conf;

/**
 * Lihtne objekt allika andmete hoidmiseks (saab kasutada hiljem conf'i cachemisel nt.)
 * @author AR
 *
 */
public class Allikas {
	
	public String baas;
	public String nimetus;
	public String url;
	
	public Allikas(String baas, String nimetus, String url){
		
		this.baas = baas;
		this.nimetus = nimetus;
		this.url = url;
	}

}
