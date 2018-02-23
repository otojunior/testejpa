/**
 * 
 */
package org.otojunior.testejpa.entidade;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author 01456231650
 *
 */
@Entity
public class Aliquota extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Municipio municipio;

	/**
	 * 
	 */
	public Aliquota() { }
	
	/**
	 * 
	 * @param i
	 */
	public Aliquota(Integer codigo) {
		setCodigo(codigo);
	}

	/**
	 * @return the municipio
	 */
	public Municipio getMunicipio() {
		return municipio;
	}

	/**
	 * @param municipio the municipio to set
	 */
	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}
}

