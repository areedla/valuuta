package katse.valuuta.dao;

import java.util.List;

import katse.valuuta.domain.ValuutaKurs;

public interface IValuutaKursDao {
	
	public List<ValuutaKurs> getAllByValuutaAndDate(String valuuta, String kp);
	public void insert(ValuutaKurs valuutaKurs);

}
