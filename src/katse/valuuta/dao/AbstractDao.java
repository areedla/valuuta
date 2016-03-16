package katse.valuuta.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public abstract class AbstractDao {
	
	  @Autowired
	  private JdbcTemplate jdbcTemplate;

	  protected JdbcTemplate getTemplate() {
	    return jdbcTemplate;
	  }  

}
