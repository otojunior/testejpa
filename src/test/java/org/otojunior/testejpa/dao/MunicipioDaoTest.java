package org.otojunior.testejpa.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.otojunior.testejpa.entidade.Aliquota;
import org.otojunior.testejpa.entidade.DadoBancario;
import org.otojunior.testejpa.entidade.Municipio;
import org.otojunior.testejpa.entidade.Situacao;

public class MunicipioDaoTest extends AbstractDaoTest {
	private MunicipioDao dao = new MunicipioDao();
	
	@Test
	public void testSemDadosSemAliquotas() {
		Municipio povoado = new Municipio(1);
		getEntityManager().persist(povoado);
		
		Situacao situacao = dao.getSituacaoByMunicipioId(getEntityManager(), povoado.getId());
		assertEquals(Situacao.SEM_DADOSBANCARIOS_SEM_ALIQUOTAS, situacao);
	}
	
	@Test
	public void testSemDados() {
		Municipio povoado = new Municipio(1);
		povoado.addAliquotas(new Aliquota(1));
		povoado.addAliquotas(new Aliquota(2));
		getEntityManager().persist(povoado);
		
		Situacao situacao = dao.getSituacaoByMunicipioId(getEntityManager(), povoado.getId());
		assertEquals(Situacao.SEM_DADOSBANCARIOS, situacao);
	}
	
	@Test
	public void testSemAliquotas() {
		Municipio povoado = new Municipio(1);
		povoado.addDadosBancarios(new DadoBancario(1));
		povoado.addDadosBancarios(new DadoBancario(2));
		getEntityManager().persist(povoado);
		
		Situacao situacao = dao.getSituacaoByMunicipioId(getEntityManager(), povoado.getId());
		assertEquals(Situacao.SEM_ALIQUOTAS, situacao);
	}
	
	@Test
	public void testSemPendencias() {
		Municipio povoado = new Municipio(1);
		povoado.addDadosBancarios(new DadoBancario(1));
		povoado.addDadosBancarios(new DadoBancario(2));
		povoado.addAliquotas(new Aliquota(1));
		getEntityManager().persist(povoado);
		
		Situacao situacao = dao.getSituacaoByMunicipioId(getEntityManager(), povoado.getId());
		assertEquals(Situacao.SEM_PENDENCIAS, situacao);
	}
}
