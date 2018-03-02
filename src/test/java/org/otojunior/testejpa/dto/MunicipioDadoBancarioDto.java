/**
 * 
 */
package org.otojunior.testejpa.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author 01456231650
 *
 */
public class MunicipioDadoBancarioDto {
	private String idMunicipio;
	private String codigoMunicipio;
	private String idDadoBancario;
	private String codigoDadoBancario;
	private String vigenciaDadoBancario;
	
	private static SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * 
	 */
	public MunicipioDadoBancarioDto() {	}
	
	/**
	 * 
	 * @param idMunicipio
	 * @param codigoMunicipio
	 * @param idDadoBancario
	 * @param codigoDadoBancario
	 * @param vigenciaDadoBancario
	 * long, int, long, int, java.util.Date
	 */
	public MunicipioDadoBancarioDto(
			Long idMunicipio, 
			Integer codigoMunicipio, 
			Long idDadoBancario,
			Integer codigoDadoBancario, 
			Date vigenciaDadoBancario) {
		setIdMunicipio(String.valueOf(idMunicipio.longValue()));
		setCodigoDadoBancario(String.valueOf(codigoMunicipio.intValue()));
		setIdDadoBancario(String.valueOf(idDadoBancario.longValue()));
		setCodigoDadoBancario(String.valueOf(codigoDadoBancario.intValue()));
		setVigenciaDadoBancario(fmt.format(vigenciaDadoBancario));
	}

	/**
	 * @return the idMunicipio
	 */
	public String getIdMunicipio() {
		return idMunicipio;
	}
	/**
	 * @param idMunicipio the idMunicipio to set
	 */
	public void setIdMunicipio(String idMunicipio) {
		this.idMunicipio = idMunicipio;
	}
	/**
	 * @return the codigoMunicipio
	 */
	public String getCodigoMunicipio() {
		return codigoMunicipio;
	}
	/**
	 * @param codigoMunicipio the codigoMunicipio to set
	 */
	public void setCodigoMunicipio(String codigoMunicipio) {
		this.codigoMunicipio = codigoMunicipio;
	}
	/**
	 * @return the idDadoBancario
	 */
	public String getIdDadoBancario() {
		return idDadoBancario;
	}
	/**
	 * @param idDadoBancario the idDadoBancario to set
	 */
	public void setIdDadoBancario(String idDadoBancario) {
		this.idDadoBancario = idDadoBancario;
	}
	/**
	 * @return the codigoDadoBancario
	 */
	public String getCodigoDadoBancario() {
		return codigoDadoBancario;
	}
	/**
	 * @param codigoDadoBancario the codigoDadoBancario to set
	 */
	public void setCodigoDadoBancario(String codigoDadoBancario) {
		this.codigoDadoBancario = codigoDadoBancario;
	}
	/**
	 * @return the vigenciaDadoBancario
	 */
	public String getVigenciaDadoBancario() {
		return vigenciaDadoBancario;
	}
	/**
	 * @param vigenciaDadoBancario the vigenciaDadoBancario to set
	 */
	public void setVigenciaDadoBancario(String vigenciaDadoBancario) {
		this.vigenciaDadoBancario = vigenciaDadoBancario;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
