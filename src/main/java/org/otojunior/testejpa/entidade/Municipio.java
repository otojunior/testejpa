/**
 * 
 */
package org.otojunior.testejpa.entidade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

/**
 * @author 01456231650
 *
 */
@Entity
@Access(AccessType.FIELD)
public class Municipio extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="municipio", cascade=CascadeType.PERSIST)
	private List<DadoBancario> dadosBancarios = new ArrayList<>();
	
	@OneToMany(mappedBy="municipio", cascade=CascadeType.PERSIST)
	private List<Aliquota> aliquotas = new ArrayList<>();
	
	@Enumerated
	@Access(AccessType.PROPERTY)
	private Situacao situacao;

	/**
	 * 
	 */
	public Municipio() { }
	
	/**
	 * 
	 * @param codigo
	 */
	public Municipio(Integer codigo) {
		setCodigo(codigo);
	}
	
	/**
	 * @return the dadosBancarios
	 */
	public List<DadoBancario> getDadosBancarios() {
		return dadosBancarios;
	}

	/**
	 * @param dadosBancarios the dadosBancarios to set
	 */
	public void setDadosBancarios(List<DadoBancario> dadosBancarios) {
		this.dadosBancarios = dadosBancarios;
	}

	/**
	 * @return the aliquotas
	 */
	public List<Aliquota> getAliquotas() {
		return aliquotas;
	}

	/**
	 * @param aliquotas the aliquotas to set
	 */
	public void setAliquotas(List<Aliquota> aliquotas) {
		this.aliquotas = aliquotas;
	}
	
	/**
	 * 
	 */
	public void addDadosBancarios(DadoBancario dadoBancario) {
		this.dadosBancarios.add(dadoBancario);
		dadoBancario.setMunicipio(this);
	}
	
	/**
	 * 
	 */
	public void addAliquotas(Aliquota aliquota) {
		this.aliquotas.add(aliquota);
		aliquota.setMunicipio(this);
	}

	/**
	 * @return the situacao
	 */
	public Situacao getSituacao() {
		return situacao;
	}

	/**
	 * @param situacao the situacao to set
	 */
	public void setSituacao(Situacao situacao) {
		this.situacao = Situacao.of(dadosBancarios, aliquotas);
	}
}
