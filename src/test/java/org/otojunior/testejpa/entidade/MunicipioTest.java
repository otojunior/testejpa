/**
 * 
 */
package org.otojunior.testejpa.entidade;

import static org.junit.Assert.*;

import org.junit.Test;
import org.otojunior.testejpa.dao.AbstractDaoTest;

/**
 * @author 01456231650
 *
 */
public class MunicipioTest extends AbstractDaoTest {

	@Test
	public void testSemDadosSemAliquotas() {
		Municipio povoado = new Municipio(1);
		getEntityManager().persist(povoado);
		Municipio municipio = getEntityManager().find(Municipio.class, povoado.getId());
		assertEquals(Situacao.SEM_DADOSBANCARIOS_SEM_ALIQUOTAS, municipio.getSituacao());
	}
	
	@Test
	public void testSemDados() {
		Municipio povoado = new Municipio(1);
		povoado.addAliquotas(new Aliquota(1));
		povoado.addAliquotas(new Aliquota(2));
		getEntityManager().persist(povoado);
		
		Municipio municipio = getEntityManager().find(Municipio.class, povoado.getId());
		assertEquals(Situacao.SEM_DADOSBANCARIOS, municipio.getSituacao());
	}
	
	@Test
	public void testSemAliquotas() {
		Municipio povoado = new Municipio(1);
		povoado.addDadosBancarios(new DadoBancario(1));
		povoado.addDadosBancarios(new DadoBancario(2));
		getEntityManager().persist(povoado);
		
		Municipio municipio = getEntityManager().find(Municipio.class, povoado.getId());
		assertEquals(Situacao.SEM_ALIQUOTAS, municipio.getSituacao());
	}
	
	@Test
	public void testSemPendencias() {
		Municipio povoado = new Municipio(1);
		povoado.addDadosBancarios(new DadoBancario(1));
		povoado.addDadosBancarios(new DadoBancario(2));
		povoado.addAliquotas(new Aliquota(1));
		getEntityManager().persist(povoado);
		
		Municipio municipio = getEntityManager().find(Municipio.class, povoado.getId());
		assertEquals(Situacao.SEM_PENDENCIAS, municipio.getSituacao());
	}
}
