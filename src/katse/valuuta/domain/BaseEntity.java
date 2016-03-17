package katse.valuuta.domain;

/**
 * Kõikide objektide baasklass
 * 
 * @author AR
 *
 */
public abstract class BaseEntity {
	
	private Long id;
	private Boolean aktiivne = true;
	// jne. nt. auditväljad
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getAktiivne() {
		return aktiivne;
	}

	public void setAktiivne(Boolean aktiivne) {
		this.aktiivne = aktiivne;
	}

}
