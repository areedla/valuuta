package katse.valuuta.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import katse.valuuta.domain.ValuutaKurs;

/**
 * ValuutaKurs objekti ja baasi suhtlus
 * @author AR
 *
 */
@Repository
public class ValuutaKursDao extends AbstractDao implements IValuutaKursDao{
	
	@Override
	public List<ValuutaKurs> getAllByValuutaAndDate(String valuuta, String kp) {
		
		List<ValuutaKurs> kursid = getTemplate().query(
		        "select valuuta, nimetus, allikas, kp, kurs from valuuta_kurs where valuuta = ? and kp = ?",
		        new Object[]{valuuta, kp},
		        new RowMapper<ValuutaKurs>() {
		            public ValuutaKurs mapRow(ResultSet rs, int rowNum) throws SQLException {
		            	ValuutaKurs kurs = new ValuutaKurs();
		            	kurs.setValuuta(rs.getString("valuuta"));
		            	kurs.setNimetus(rs.getString("nimetus"));
		            	kurs.setAllikas(rs.getString("allikas"));
		            	kurs.setKp(rs.getString("kp"));
		            	kurs.setKurs(rs.getDouble("kurs"));
		                return kurs;
		            }
		        });
		
		return kursid;
	}

	@Override
	public void insert(ValuutaKurs valuutaKurs) {
		
		getTemplate().update(
		        "insert into valuuta_kurs (valuuta, nimetus, allikas, kp, kurs) values (?, ?, ?, ?, ?)",
			        valuutaKurs.getValuuta(), 
			        valuutaKurs.getNimetus(), 
			        valuutaKurs.getAllikas(), 
			        valuutaKurs.getKp(), 
			        valuutaKurs.getKurs());
	}

}
