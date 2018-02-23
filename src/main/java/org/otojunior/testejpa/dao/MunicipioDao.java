/**
 * 
 */
package org.otojunior.testejpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.otojunior.testejpa.entidade.Situacao;

/**
 * @author 01456231650
 *
 */
public class MunicipioDao {
	/**
	 * 
	 * @param id
	 * @return
	 */
	
	public Situacao getSituacaoByMunicipioId(EntityManager entityManager, Long id) {
		String jpql = "select count(distinct d.id), count(distinct a.id) "
			+ "from Municipio m "
			+ "left join m.dadosBancarios d "
			+ "left join m.aliquotas a "
			+ "where m.id = :id "
			+ "group by m.id";
		
		Query query = entityManager.createQuery(jpql);
		query.setParameter("id", id);
		Object[] result = (Object[])query.getSingleResult();
		
		return Situacao.of((Long)result[0], (Long)result[1]);
	}
}
