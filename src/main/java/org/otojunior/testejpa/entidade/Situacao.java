package org.otojunior.testejpa.entidade;

import java.util.List;

/**
 * 
 * @author 01456231650
 *
 */
public enum Situacao {
	SEM_DADOSBANCARIOS_SEM_ALIQUOTAS,
	SEM_DADOSBANCARIOS,
	SEM_ALIQUOTAS,
	SEM_PENDENCIAS;
	
	/**
	 * 
	 * @return
	 */
	public static Situacao of(List<DadoBancario> dadosBancarios, List<Aliquota> aliquotas) {
		if (dadosBancarios.isEmpty() && aliquotas.isEmpty()) 
			return Situacao.SEM_DADOSBANCARIOS_SEM_ALIQUOTAS;
		else if(dadosBancarios.isEmpty() && !aliquotas.isEmpty())
			return Situacao.SEM_DADOSBANCARIOS;
		else if(!dadosBancarios.isEmpty() && aliquotas.isEmpty())
			return Situacao.SEM_ALIQUOTAS;
		else 	
			return Situacao.SEM_PENDENCIAS;
	}
	
	/**
	 * 
	 * @return
	 */
	public static Situacao of(Long quantDadosBancarios, Long quantAliquotas) {
		if (quantDadosBancarios == 0 && quantAliquotas == 0) 
			return Situacao.SEM_DADOSBANCARIOS_SEM_ALIQUOTAS;
		else if(quantDadosBancarios == 0 && quantAliquotas > 0)
			return Situacao.SEM_DADOSBANCARIOS;
		else if(quantDadosBancarios > 0 && quantAliquotas == 0)
			return Situacao.SEM_ALIQUOTAS;
		else 	
			return Situacao.SEM_PENDENCIAS;
	}
}
