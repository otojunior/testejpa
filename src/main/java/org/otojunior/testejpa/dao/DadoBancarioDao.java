/**
 * 
 */
package org.otojunior.testejpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.otojunior.testejpa.dto.MunicipioDadoBancarioDto;
import org.otojunior.testejpa.entidade.DadoBancario;

/**
 * @author 01456231650
 *
 */
public class DadoBancarioDao {
	
	public List<MunicipioDadoBancarioDto> getIdsMunicipioPorDadoBancario(EntityManager entityManager) {
		String jpql = "select new org.otojunior.testejpa.dto.MunicipioDadoBancarioDto(m.id, m.codigo, d.id, d.codigo, d.vigencia) "
			+ " from Municipio m "
			+ " join m.dadosBancarios d "
			+ " where concat(d.municipio.id, d.vigencia) in ("
			+ "		select concat(d2.municipio.id, max(d2.vigencia))"
			+ "		from DadoBancario d2 "
			+ "		group by d2.municipio.id)";
		
		TypedQuery<MunicipioDadoBancarioDto> query = entityManager.createQuery(jpql, MunicipioDadoBancarioDto.class);
		List<MunicipioDadoBancarioDto> resultList = query.getResultList();
		return resultList;
	}
}
