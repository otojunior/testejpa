/**
 * 
 */
package org.otojunior.testejpa.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Ignore;
import org.junit.Test;
import org.otojunior.testejpa.dto.MunicipioDadoBancarioDto;
import org.otojunior.testejpa.entidade.DadoBancario;
import org.otojunior.testejpa.entidade.Municipio;
import org.otojunior.testejpa.entidade.Situacao;

/**
 * @author 01456231650
 *
 */
public class DadoBancarioDaoTest extends AbstractDaoPostgreSqlTest {
	private DadoBancarioDao dao = new DadoBancarioDao();
	
	@Test
	@Ignore
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
	
	@Test
	public void testeGetIdsMunicipioPorDadoBancario() {
		EntityManager em = getEntityManager();
		
		Municipio m01 = new Municipio(1);
		m01.addDadosBancarios(new DadoBancario(100, Date.valueOf("2018-01-01")));
		m01.addDadosBancarios(new DadoBancario(200, Date.valueOf("2018-02-01")));
		m01.addDadosBancarios(new DadoBancario(300, Date.valueOf("2018-03-01")));
		
		Municipio m02 = new Municipio(2);
		m02.addDadosBancarios(new DadoBancario(400, Date.valueOf("2018-03-15")));
		m02.addDadosBancarios(new DadoBancario(500, Date.valueOf("2018-02-15")));
		
		em.persist(m01);
		em.persist(m02);
		
		List<MunicipioDadoBancarioDto> result = dao.getIdsMunicipioPorDadoBancario(em);
		
		for (MunicipioDadoBancarioDto object : result) {
			System.out.println(object.toString());
		}
	}
}
