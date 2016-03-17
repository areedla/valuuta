package katse.valuuta.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;

import katse.valuuta.domain.ValuutaKurs;

/**
 * ValuutaKurs objekti ja baasi suhtlus
 * @author AR
 *
 */
public class ValuutaKursDao extends AbstractDao implements IValuutaKursDao{
	
	@Override
	public List<ValuutaKurs> getAllByValuutaAndDate(String valuuta, String date) {
		Query query = new Query();
		query.addCriteria(Criteria.where("valuuta").is(valuuta));
		query.addCriteria(Criteria.where("date").is(date));
		return getTemplate().findAll(query, ValuutaKurs.class);
	}

	@Override
	public void insert(ValuutaKurs valuutaKurs) {
		getTemplate().insert(valuutaKurs);
	}

}
