package br.com.leomanzini.system.user.criteria;

import java.util.List;

import br.com.leomanzini.system.user.jpql.dto.SystemUserDTO;
import br.com.leomanzini.system.user.jpql.model.Domain;
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

//		choosingReturn(entityManager);
		
//		choosingMoreThenOneReturn(entityManager);

//		choosingMoreThenOneReturnAbstraction(entityManager);
		
//		passParameters(entityManager);
		
//		order(entityManager);
		
		pagination(entityManager);
		
		entityManager.close();
		entityManagerFactory.close();
	}

	public static void criteriaSelect(EntityManager entityManager) {

		/**
		 * Igual ao JPQL porem mais segura, nao dependemos da criacao de uma query
		 * escrita
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
		CriteriaQuery<Domain> criteriaQuery = criteriaBuilder.createQuery(Domain.class);

		Root<SystemUser> root = criteriaQuery.from(SystemUser.class);
		
		criteriaQuery.select(root.get("domain"));
		
		TypedQuery<Domain> typedQuery = entityManager.createQuery(criteriaQuery);
		List<Domain> resultList = typedQuery.getResultList();

		resultList.forEach(listItem -> System.out.println(listItem));
		
//		Pegando uma String de retorno da query a partir do objeto SystemUser
//		CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
//
//		Root<SystemUser> root = criteriaQuery.from(SystemUser.class);
//		
//		criteriaQuery.select(root.get("name"));
//		
//		TypedQuery<String> typedQuery = entityManager.createQuery(criteriaQuery);
//		List<String> resultList = typedQuery.getResultList();
//
//		resultList.forEach(listItem -> System.out.println(listItem));
	}
	
	public static void choosingMoreThenOneReturnAbstraction(EntityManager entityManager) {

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Object []> criteriaQuery = criteriaBuilder.createQuery(Object [].class);

		Root<SystemUser> root = criteriaQuery.from(SystemUser.class);
		
		criteriaQuery.multiselect(root.get("id"), root.get("name"), root.get("login"));
		
		TypedQuery<Object []> typedQuery = entityManager.createQuery(criteriaQuery);
		List<Object []> resultList = typedQuery.getResultList();

		resultList.forEach(listItem -> System.out.println(String.format("%s, %s, %s", listItem)));
	}
	
	public static void choosingMoreThenOneReturn(EntityManager entityManager) {
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<SystemUserDTO> criteriaQuery = criteriaBuilder.createQuery(SystemUserDTO.class);

		Root<SystemUser> root = criteriaQuery.from(SystemUser.class);
		
		criteriaQuery.select(criteriaBuilder.construct(SystemUserDTO.class, root.get("id"), root.get("name"), root.get("login")));
		
		TypedQuery<SystemUserDTO> typedQuery = entityManager.createQuery(criteriaQuery);
		List<SystemUserDTO> resultList = typedQuery.getResultList();

		resultList.forEach(listItem -> System.out.println(listItem));
	}
	
	public static void passParameters(EntityManager entityManager) {
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<SystemUser> criteriaQuery = criteriaBuilder.createQuery(SystemUser.class);

		Root<SystemUser> root = criteriaQuery.from(SystemUser.class);

		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.equal(root.get("id"), 1));

		TypedQuery<SystemUser> typedQuery = entityManager.createQuery(criteriaQuery);
		SystemUser user = typedQuery.getSingleResult();

		System.out.println(user);
		
		// Passando uma string no where
		
		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.equal(root.get("login"), "ria"));

		typedQuery = entityManager.createQuery(criteriaQuery);
		user = typedQuery.getSingleResult();

		System.out.println(user);
	}
	
	public static void order(EntityManager entityManager) {
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<SystemUser> criteriaQuery = criteriaBuilder.createQuery(SystemUser.class);

		Root<SystemUser> root = criteriaQuery.from(SystemUser.class);

		criteriaQuery.select(root);
		criteriaQuery.orderBy(criteriaBuilder.desc(root.get("name")));

		TypedQuery<SystemUser> typedQuery = entityManager.createQuery(criteriaQuery);
		List<SystemUser> resultList = typedQuery.getResultList();

		resultList.forEach(user -> System.out.println(user));
	}
	
	public static void pagination(EntityManager entityManager) {
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<SystemUser> criteriaQuery = criteriaBuilder.createQuery(SystemUser.class);

		Root<SystemUser> root = criteriaQuery.from(SystemUser.class);

		criteriaQuery.select(root);

		TypedQuery<SystemUser> typedQuery = entityManager.createQuery(criteriaQuery)
				.setFirstResult(0) // Calculo firstResult: firstResult = (PaginaAtual - 1) * QuantidadeRegistrosPagina
				.setMaxResults(2);
		List<SystemUser> resultList = typedQuery.getResultList();

		resultList.forEach(user -> System.out.println(user));
	}
}
