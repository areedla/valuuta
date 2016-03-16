package katse.valuuta.util;

/**
 * Util klass valuuta kursidega arvutamiseks
 * @author AR
 *
 */
public class ValuutaUtil {
	
	/**
	 * Teise valuutabaasi arvutamine
	 * @param base
	 * @param val
	 * @return
	 */
	static double toBaseValue(double base, double val){

		return val/base;	
	}

}
