package katse.valuuta.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
	static public List<Allikas> getAllikad(){
		
		List<Allikas> allikad = new ArrayList<Allikas>();
		
		BufferedReader br = null;
		String rida = "";
		
		try {
			br = new BufferedReader(new FileReader("C:/ework/valuuta/valuuta_allikad.csv"));
			
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
