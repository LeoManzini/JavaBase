package br.com.leomanzini.system.user.criteria;

import java.util.List;

import br.com.leomanzini.system.user.jpql.model.SystemUser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class CriteriaApplication {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev-local-database");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
//		criteriaSelect(entityManager);
		
		criteriaSelect(entityManager);
		
		entityManager.close();
		entityManagerFactory.close();
	}
	
	public static void criteriaSelect(EntityManager entityManager) {
		
		/**
		 * Igual ao JPQL porem mais segura, nao dependemos da criacao de uma query escrita
		 */
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<SystemUser> criteriaQuery = criteriaBuilder.createQuery(SystemUser.class);
		
		Root<SystemUser> root = criteriaQuery.from(SystemUser.class);
		
		criteriaQuery.select(root);
		
		TypedQuery<SystemUser> typedQuery = entityManager.createQuery(criteriaQuery);
		List<SystemUser> resultList = typedQuery.getResultList();

		resultList.forEach(user -> System.out.println(user));
	}
	
	public static void choosingReturn(EntityManager entityManager) {
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
	}
}
