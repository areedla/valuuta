package katse.valuuta.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import katse.valuuta.obj.Allikas;

/**
 * Util konfiguratsiooni lugemiseks
 * @author AR
 *
 */
public class ConfUtil {
	
	/**
	 * Kõik konfi failis lisatud allikad
	 * @return Allika' list
	 */
	public List<Allikas> getAllikad(){
		
		List<Allikas> allikad = new ArrayList<Allikas>();
		
		BufferedReader br = null;
		String rida = "";
		try {
			Reader reader = new InputStreamReader(getClass().getResourceAsStream("/valuuta_allikad.csv"));
			br = new BufferedReader(reader);
			
			while ((rida = br.readLine()) != null) {
				
				String[] osad = rida.split(";");
				if(osad.length > 2){
					allikad.add(new Allikas(osad[0], osad[1], osad[2]));
				}else{
					//TODO: alati peaks olema else:)
				}
			}
			
		} catch(Exception e) {
			
			// TODO: veatöötlus.. logida midagi, muidu ei saa keegi aru mis juhtus
			// NB! võib eraldi välja tuua nt: FileNotFoundException, IOException..
			e.printStackTrace();
		} finally {
			
			if(br != null) {
				try {	
					br.close();
				} catch (IOException e) {				
					e.printStackTrace();
				}
			}
		}
		
		return allikad;
		
	}

}
