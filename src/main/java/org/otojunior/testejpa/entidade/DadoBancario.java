/**
 * 
 */
package org.otojunior.testejpa.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author 01456231650
 *
 */
@Entity
public class DadoBancario extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Municipio municipio;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date vigencia;

	/**
	 * 
	 */
	public DadoBancario() { }
	
	/**
	 * 
	 * @param codigo
	 */
	public DadoBancario(Integer codigo) {
		setCodigo(codigo);
	}
	
	/**
	 * 
	 * @param codigo
	 */
	public DadoBancario(Integer codigo, Date vigencia) {
		setCodigo(codigo);
		setVigencia(vigencia);
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
	void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	/**
	 * @return the vigencia
	 */
	public Date getVigencia() {
		return vigencia;
	}

	/**
	 * @param vigencia the vigencia to set
	 */
	public void setVigencia(Date vigencia) {
		this.vigencia = vigencia;
	}
}
