/**
 * 
 */
package org.otojunior.testejpa.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.otojunior.testejpa.entidade.AbstractTest;
import org.otojunior.testejpa.entidade.DadoBancario;
import org.otojunior.testejpa.entidade.Municipio;
import org.otojunior.testejpa.entidade.Situacao;

/**
 * @author 01456231650
 *
 */
public class DadoBancarioDaoTest extends AbstractTest {
	@Test
	public void teste() {
		Municipio povoado = new Municipio(1);
		persist(povoado);
		
		Municipio obtido = getEntityManager().find(Municipio.class, povoado.getId());
		assertEquals(Situacao.SEM_DADOSBANCARIOS_SEM_ALIQUOTAS, obtido.getSituacao());
		
		DadoBancario dadoBancario = new DadoBancario(100);
		obtido.addDadosBancarios(dadoBancario);
		persist(dadoBancario);
		
		obtido = getEntityManager().find(Municipio.class, povoado.getId());
		assertEquals(Situacao.SEM_ALIQUOTAS, obtido.getSituacao());
	}
}
