/**
 * 
 */
package org.otojunior.testejpa.entidade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * @author 01456231650
 *
 */
public class AbstractTest {
	private static EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	
	/**
	 * 
	 */
	@BeforeClass
	public static void beforeClass() {
		entityManagerFactory = Persistence.createEntityManagerFactory("default_tests");
	}
	
	/**
	 * 
	 */
	@AfterClass
	public static void afterClass() {
		entityManagerFactory.close();
	}
	
	/**
	 * 
	 */
	@Before
	public void before() {
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
	}
	
	/**
	 * 
	 */
	@After
	public void after() {
		entityManager.getTransaction().rollback();
		entityManager.close();
	}
	
	/**
	 * @return the entityManager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	/**
	 * 
	 * @param entity
	 */
	public void persist(AbstractEntity entity) {
		getEntityManager().persist(entity);
		getEntityManager().flush();
	}
}
